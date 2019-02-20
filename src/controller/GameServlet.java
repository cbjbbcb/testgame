package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.mysql.fabric.Response;
import com.sun.javafx.collections.MappingChange.Map;

import dao.GameDaoImpl;
import entity.BattleResult;
import entity.BattleSkill;
import entity.Pet;
import entity.User;
import service.GameService;
import service.GameServiceImpl;

public class GameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		GameService gameServiceImpl = new GameServiceImpl();
		HttpSession session = req.getSession();
		if ("login".equals(op)) {

			String uname = req.getParameter("uname");
			String password = req.getParameter("password");
			User user = gameServiceImpl.login(uname, password);
			HashMap<String, Object> result = new HashMap<String, Object>();
			if (user != null) {
				session.setAttribute("user", user);// 保存用户数据到session
				session.setMaxInactiveInterval(600);// 600s不与服务器交互则清除session
				result.put("code", 1);
			} else {
				result.put("code", 0);
			}
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter print = resp.getWriter();
			print.print(JSON.toJSONString(result));
			print.flush();
			print.close();
			return;
		} else if ("register".equals(op)) {
			String uname = req.getParameter("uname");
			String password = req.getParameter("password");
			String nickName = req.getParameter("nickName");
			if (gameServiceImpl.register(uname, password, nickName) == 1) {
				User user = gameServiceImpl.login(uname, password);
				session.setAttribute("user", user);// 保存用户数据到session
				session.setMaxInactiveInterval(600);// 600s不与服务器交互则清除session
				gameServiceImpl.CreatePet(user);
				resp.sendRedirect(req.getContextPath() + "/game?op=mypets");
			} else {
				resp.sendRedirect("register.jsp");
			}
			return;
		} else if ("showUnames".equals(op)) {
			String phone = req.getParameter("phone");
			List<String> list=gameServiceImpl.showUnames();
			int result=1;
			for (String uname : list) {
				if(uname.equals(phone)) {
					result=0;
				}
			}
			System.out.println(result);
			HashMap<String, Object> results = new HashMap<String, Object>();
			results.put("result",result);
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter print = resp.getWriter();
			print.print(JSON.toJSONString(results));
			print.flush();
			print.close();	
		}else if ("out".equals(op)) {
			session.invalidate();
			resp.sendRedirect("mygame.jsp");
			return;
		} else if ("mypets".equals(op)) {
			session.removeAttribute("battleResult");
			User user = (User) session.getAttribute("user");
			List<Pet> list = gameServiceImpl.showPets(user);
			session.setAttribute("list", list);
			Pet pet = (Pet) list.get(0);
			session.setAttribute("pet", pet);
			List<BattleSkill> skills = gameServiceImpl.getSkills(pet);
			session.setAttribute("skills", skills);
			resp.sendRedirect("mygame.jsp");
			return;
		} else if ("toFirst".equals(op)) {
			User user = (User) session.getAttribute("user");
			int n = Integer.parseInt(req.getParameter("n"));
			gameServiceImpl.petToFirst(user, n);
			resp.sendRedirect(req.getContextPath() + "/game?op=mypets");
			return;
		} else if ("add".equals(op)) {
			User user = (User) session.getAttribute("user");
			Pet pet = gameServiceImpl.CreatePet(user);
			resp.sendRedirect(req.getContextPath() + "/game?op=mypets");
		} else if ("delete".equals(op)) {
			User user = (User) session.getAttribute("user");
			int deleteNo = Integer.parseInt(req.getParameter("deleteNo"));
			gameServiceImpl.deletePet(user, deleteNo);
			resp.sendRedirect(req.getContextPath() + "/game?op=mypets");
			return;
		} else if ("recover".equals(op)) {
			User user = (User) session.getAttribute("user");
			gameServiceImpl.recover(user);
			resp.sendRedirect(req.getContextPath() + "/game?op=mypets");
			return;
		} else if ("battle".equals(op)) {
			User user = (User) session.getAttribute("user");
			List<Pet> list = gameServiceImpl.showPets(user);
			session.setAttribute("list", list);
			Pet pet = (Pet) list.get(0);
			if (pet.getBhp() == 0) {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				pw.print("<script type=\"text/javascript\">alert(\"您的宠物死亡了哦，请先前往医院治疗\");location.href='"
						+ req.getContextPath() + "/game?op=mypets';</script>");
				return;
			}
			session.setAttribute("pet", pet);
			List<BattleSkill> skills = gameServiceImpl.getSkills(pet);
			session.setAttribute("skills", skills);
			BattleResult br = (BattleResult) session.getAttribute("battleResult");
			User user2 =gameServiceImpl.login("random", "123");// 随机对手
			// 若未战斗
			if (br == null || br.getWin() == 1 || br.getWin() == 2) {
				Pet pet2 = gameServiceImpl.CreatePet(user2);
				session.setAttribute("pet2", pet2);
				br = new BattleResult();
				br.setWin(-1);
				session.setAttribute("battleResult", br);
				resp.sendRedirect(req.getContextPath() + "/battle.jsp");
			} else {
				int atk1 = Integer.parseInt(req.getParameter("atk"));
				BattleSkill bs1 = gameServiceImpl.getSkillbyAtkNo(pet, atk1);
				Pet pet2 = (Pet) session.getAttribute("pet2");
				BattleSkill bs2 = gameServiceImpl.getSkillbyRandom(pet2);
				br = gameServiceImpl.petsBattle(user, pet, bs1, user2, pet2, bs2);
				// 如果己方赢了，结算经验
				if (br.getWin() == 1) {
					int expGet = 128 * pet2.getLv() / 7;
					br.setExp(expGet);
					int exp = pet.getExp() + expGet;
					// 判断升级
					pet.setExp(exp);
					if (exp > pet.getExpMax()) {
						br.setUp(1);
					} else {
						br.setUp(0);
					}
					// 数据库对经验，升级，能力提升做结算
					pet = gameServiceImpl.petExp(user, pet);
					// 删除随机敌人
				}
				if (br.getWin() == 1 || br.getWin() == 2) {
					// 如果战斗结束那么删除野生宠物
					gameServiceImpl.deletePet(user2, pet2.getNo());
				}
				br.setSkill1(bs1.getSkillName());
				br.setSkill2(bs2.getSkillName());
				br.setName1(pet.getName());
				br.setName2(pet2.getName());
				br.setRhp1(pet.getRhp());
				br.setRhp2(pet2.getRhp());
				br.setBhp1(pet.getBhp());
				br.setBhp2(pet2.getBhp());
				session.setAttribute("pet", pet);
				session.setAttribute("pet2", pet2);
				session.setAttribute("battleResult", br);
				System.out.println(br);
				//
				resp.setContentType("application/json;charset=utf-8");
				PrintWriter print = resp.getWriter();
				print.print(JSON.toJSONString(br));
				print.flush();
				print.close();
				return;
			}
		} else if ("battleRemove".equals(op)) {
			User user = (User) session.getAttribute("user");
			List<Pet> list = gameServiceImpl.showPets(user);
			session.setAttribute("list", list);
			Pet pet = (Pet) list.get(0);
			session.removeAttribute("battleResult");
			User user2 = gameServiceImpl.login("random", "123");// 随机对手
			if (pet.getBhp() == 0) {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter pw = resp.getWriter();
				pw.print("<script type=\"text/javascript\">alert(\"您的宠物死亡了哦，请先前往医院治疗\");location.href='"
						+ req.getContextPath() + "/game?op=mypets';</script>");
				return;
			}
			Pet pet2 =gameServiceImpl.CreatePet(user2);
			session.setAttribute("pet2", pet2);
			session.setAttribute("pet", pet);
			List<BattleSkill> skills = gameServiceImpl.getSkills(pet);
			session.setAttribute("skills", skills);
			BattleResult br = (BattleResult) session.getAttribute("battleResult");
			br = new BattleResult();
			br.setWin(-1);
			br.setName1(pet.getName());
			br.setName2(pet2.getName());
			br.setRhp2(pet2.getRhp());
			br.setBhp2(pet2.getBhp());
			br.setImgL2(pet2.getImgL());
			session.setAttribute("battleResult", br);
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter print = resp.getWriter();
			print.print(JSON.toJSONString(br));
			print.flush();
			print.close();
			return;
		} else if ("catchpet".equals(op)) {
			int rhp2 = Integer.parseInt(req.getParameter("rhp2"));
			int bhp2 = Integer.parseInt(req.getParameter("bhp2"));
			int count = gameServiceImpl.catchPet(rhp2, bhp2);
			User user = (User) session.getAttribute("user");
			Pet pet2 = (Pet) session.getAttribute("pet2");
			Pet pet = (Pet) session.getAttribute("pet");
			BattleResult br = new BattleResult();
			if (count > 3) {
				gameServiceImpl.getPet(user, pet2);
				br.setWin(21);
			} else {
				User user2 = gameServiceImpl.login("random", "123");
				BattleSkill bs2 = gameServiceImpl.getSkillbyRandom(pet2);
				br = gameServiceImpl.petsBattleSingel(user, pet, user2, pet2, bs2);
				br.setName1(pet.getName());
				br.setSkill2(bs2.getSkillName());
				br.setBhp1(pet.getBhp());
			}
			br.setName2(pet2.getName());
			session.setAttribute("pet", pet);
			session.setAttribute("pet2", pet2);
			HashMap result = new HashMap();
			result.put("count", count);
			result.put("br", br);
			session.setAttribute("battleResult", br);
			resp.setContentType("application/json;charset=utf-8");
			PrintWriter print = resp.getWriter();
			print.print(JSON.toJSONString(result));
			print.flush();
			print.close();
		} else if ("ranking".equals(op)) {
			List<Pet> petsRanking = gameServiceImpl.getRanking();
			session.setAttribute("petsRanking", petsRanking);
			resp.sendRedirect("ranking.jsp");
		}
	}
}
