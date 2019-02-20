package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import entity.BattleResult;
import entity.BattleSkill;
import entity.Kind;
import entity.Pet;
import entity.User;
import util.BaseDao;

public class GameDaoImpl extends BaseDao implements GameDao{
	BaseDao baseDao = new BaseDao();

	/**
	 * 
	 * 用户部分*********************************************************************************************************************
	 */

	/*
	 * 用户注册
	 * 
	 */
	public int register(String uname, String password, String nickName) {
		if (uname != null && password != null) {
			String sql = "insert into user(uname,password,nickName) values(?,?,?)";
			int result = super.update(sql, uname, password, nickName);
			return result;
		} else {
			return 0;
		}
	}

	// 得出所有用户名，用于避免注册重复
	public List showUnames() {
		String sql="select uname from user";
		return super.queryColumnList(sql, new ColumnListHandler());
	}

	/*
	 * 用户登陆
	 * 
	 */
	public User login(String uname, String password) {
		String sql = "select * from user where uname=?";
		List<User> users = super.queryList(sql,new BeanListHandler<User>(User.class), uname);
		if (users.size() != 0) {
			String password2 = users.get(0).getPassword();
			if (password2.equals(password)) {
				return users.get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	/**
	 * pet部分****************************************************************************************************************
	 */
	/*
	 * 创建一个宠物
	 */
	public Pet CreatePet(User user) {
		Pet pet = new Pet();
		pet.setOhp();
		pet.setOwg();
		pet.setOwf();
		pet.setOtg();
		pet.setOtf();
		pet.setOsd();
		pet.setPinzhi();
		pet.setRhp();
		pet.setBhp(pet.getRhp());
		pet.setRwg();
		pet.setRwf();
		pet.setRtg();
		pet.setRtf();
		pet.setRsd();
		int kindNo = new Random().nextInt(4) + 1;
		Kind kind = getKindValue(kindNo);
		pet.setKhp(kind.getKhp());
		pet.setKwg(kind.getKwg());
		pet.setKwf(kind.getKwf());
		pet.setKtg(kind.getKtg());
		pet.setKtf(kind.getKtf());
		pet.setKsd(kind.getKsd());
		pet.setImgL(kind.getImgL());
		pet.setName(kind.getName());
		pet.setShuxing(kind.getShuxing());
		pet.setSkill1(kind.getSkill1());
		pet.setSkillpp1(kind.getSkillpp1());
		pet.setSkill2(kind.getSkill2());
		pet.setSkillpp2(kind.getSkillpp2());
		pet.setSkill3(kind.getSkill3());
		pet.setSkillpp3(kind.getSkillpp3());
		pet.setSkill4(kind.getSkill4());
		pet.setSkillpp4(kind.getSkillpp4());
		pet.setExp(0);
		pet.setExpMax();
		pet.setUid(user.getUid());
		pet.setOwnerName(user.getNickName());
		String sql = "insert into pets values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
		super.update(sql, null, pet.getKhp(), pet.getKwg(), pet.getKwf(), pet.getKtg(), pet.getKtf(), pet.getKsd(),
				pet.getOhp(), pet.getOwg(), pet.getOwf(), pet.getOtg(), pet.getOtf(), pet.getOsd(), pet.getRhp(),
				pet.getRwg(), pet.getRwf(), pet.getRtg(), pet.getRtf(), pet.getRsd(), pet.getLv(), pet.getPinzhi(),
				pet.getImgL(), pet.getName(), pet.getShuxing(), pet.getSkill1(), pet.getSkillpp1(), pet.getSkill2(),
				pet.getSkillpp2(), pet.getSkill3(), pet.getSkillpp3(), pet.getSkill4(), pet.getSkillpp4(), pet.getBhp(),
				pet.getExp(), pet.getExpMax(), pet.getUid(), pet.getOwnerName());
		pet = showPet(user, showPetsCount(user));
		System.out.println(pet);
		return pet;
	}

	/*
	 * 根据编号删除宠物
	 */
	public int deletePet(User user, int no) {
		int uid = user.getUid();
		String sql = "delete from pets where no=? and uid=?";
		int result = super.update(sql, no,uid);
		return result;
	}

	/*
	 * 改变战斗时生命值
	 */
	public void changeBhp(User user, int no, int hp) {
		int uid = user.getUid();
		String sql = "update pets set bhp=? where no=? and uid=?";
		int result =super.update(sql, hp, no, uid );
	}

	/*
	 * 恢复宠物战斗生命值
	 */
	public void recover(User user) {
		List<Pet> pets = showPets(user);
		for (Pet pet : pets) {
			changeBhp(user, pet.getNo(), pet.getRhp());
		}
	}

	/*
	 * 获得训练师第n个的宠物
	 */
	public Pet showPet(User user, int n) {
		List<Pet> list = showPets(user);
		Pet pet = list.get(n - 1);
		return pet;
	}

	/*
	 * 获得训练师所有宠物
	 */
	public List<Pet> showPets(User user) {
		int uid = user.getUid();
		String sql = "select * from pets where uid=?";
		List<Pet> list = super.queryList(sql, new BeanListHandler<Pet>(Pet.class), uid);
		return list;
	}

	/*
	 * 训练师宠物个数
	 * 
	 */
	public int showPetsCount(User user) {
		List<Pet> list = showPets(user);
		int count = list.size();
		return count;
	}

	/*
	 * 第n个和第一个互换
	 * 
	 */
	public void petToFirst(User user, int n) {
		int uid = user.getUid();
		Pet pet = showPet(user, n);
		int no = pet.getNo();
		Pet pet2 = showPet(user, 1);
		int no2 = pet2.getNo();
		String sql = "update pets set no=0 where no =" + no + " and uid=" + uid;
		super.update(sql);
		String sql2 = "update pets set no=" + no + " where no =" + no2 + " and uid=" + uid;
		super.update(sql2);
		String sql3 = "update pets set no=" + no2 + " where no =0 and uid=" + uid;
		super.update(sql3);
	}

	/*
	 * 宠物升级经验结算存储
	 */
	public Pet petExp(User user, Pet pet) {
		if (pet.getExp() > pet.getExpMax()) {
			pet.setLv(pet.getLv() + 1);
			pet.setExp(pet.getExp() - pet.getExpMax());
			pet.setExpMax();
			pet.setRhp();
			pet.setRwg();
			pet.setRwf();
			pet.setRtg();
			pet.setRtf();
			pet.setRsd();
		}
		String sql = "update pets set lv=?,exp=?,expMax=?,rhp=?,rwg=?,rwf=?,rtg=?,rtf=?,rsd=? where no=? and uid=?";
		super.update(sql,pet.getLv(), pet.getExp(), pet.getExpMax(), pet.getRhp(), pet.getRwg(), pet.getRwf(),
				pet.getRtg(), pet.getRtf(), pet.getRsd(), pet.getNo(), user.getUid());
		return pet;
	}

	/*
	 * 宠物战斗力排行榜
	 */
	public List<Pet> getRanking() {
		String sql = "SELECT * from pets where uid<>2 ORDER BY rhp+rwg+rwf+rtg+rtf+rsd DESC";
		List<Pet> list = super.queryList(sql, new BeanListHandler<Pet>(Pet.class));
		return list;
	}

	/**
	 * kind部分****************************************************************************************************************
	 */
	/*
	 * kind编号返回kind对象
	 */
	public Kind getKindValue(int no) {
		String sql = "select * from kind where no=?";
		List<Kind> list = super.queryList(sql, new BeanListHandler<Kind>(Kind.class), no);
		Kind kind = list.get(0);
		System.out.println(kind);
		return kind;
	}

	/**
	 * battle部分****************************************************************************************************************
	 */

	/*
	 * 技能编号获得技能
	 * 
	 */
	public BattleSkill getSkill(int no) {
		String sql = "select * from skill where no=?";
		List<BattleSkill> list = super.queryList(sql, new BeanListHandler<BattleSkill>(BattleSkill.class), no);
		BattleSkill skill = list.get(0);
		return skill;
	}
	/*
	 * 获得该宠物的所有技能
	 * 
	 */
	public List<BattleSkill> getSkills(Pet pet) {
		List<BattleSkill> list = new ArrayList<BattleSkill>();
		if (null != pet.getSkill1()) {
			BattleSkill bs1 = getSkill(pet.getSkill1());
			list.add(bs1);
		}
		if (null != pet.getSkill2()) {
			BattleSkill bs2 = getSkill(pet.getSkill2());
			list.add(bs2);
		}
		if (null != pet.getSkill3()) {
			BattleSkill bs3 = getSkill(pet.getSkill3());
			list.add(bs3);
		}
		if (null != pet.getSkill4()) {
			BattleSkill bs4 = getSkill(pet.getSkill4());
			list.add(bs4);
		}

		return list;
	}

	/*
	 *  技能编号获得技能名
	 * 
	 */
	public String getSkillName(int no) {
		BattleSkill skill = getSkill(no);
		String name = skill.getSkillName();
		return name;
	}

	/*
	 * 技能1，2，3，4获得对应位置的技能
	 * 
	 */
	public BattleSkill getSkillbyAtkNo(Pet pet, int no) {
		int skillNo = 0;
		switch (no) {
		case 1:
			skillNo = pet.getSkill1();
			break;
		case 2:
			skillNo = pet.getSkill2();
			break;
		case 3:
			skillNo = pet.getSkill3();
			break;
		case 4:
			skillNo = pet.getSkill4();
			break;
		}
		BattleSkill skill = getSkill(skillNo);
		return skill;
	}

	/*
	 *  随机释放技能
	 * 
	 */
	public BattleSkill getSkillbyRandom(Pet pet) {
		Integer skillNo = null;
		int random = new Random().nextInt(40) / 10;
		System.out.println(random);
		switch (random) {
		case 0:
			skillNo = pet.getSkill1();
			break;
		case 1:
			skillNo = pet.getSkill2();
			break;
		case 2:
			skillNo = pet.getSkill3();
			break;
		case 3:
			skillNo = pet.getSkill4();
			break;
		}
		System.out.println(skillNo);
		if (skillNo == null) {
			return getSkillbyRandom(pet);
		} else {
			BattleSkill skill = getSkill(skillNo);
			return skill;
		}
	}

	/*
	 * 两个训练师，宠物进行战斗
	 */
	public BattleResult petsBattle(User user1, Pet pet1, BattleSkill bs1, User user2, Pet pet2, BattleSkill bs2) {
		BattleResult br = new BattleResult();
		int no1 = pet1.getNo();
		int no2 = pet2.getNo();
		int hurt = 0;
		Boolean first = pet1.getRsd() >= pet2.getRsd();
		if (first) {
			br.setFirst(1);
		} else {
			br.setFirst(2);
		}
		// 1先攻开始
		if (first) {
			if ("w".equals(bs1.getKind())) {
				hurt = ((((pet1.getLv() * 2 / 5 + 2) * bs1.getPower() * pet1.getRwg() / pet2.getRwf())) / 50 + 2)
						* (new Random().nextInt(39) + 217) / 255;
			} else if ("t".equals(bs1.getKind())) {
				hurt = ((((pet1.getLv() * 2 / 5 + 2) * bs1.getPower() * pet1.getRtg() / pet2.getRtf())) / 50 + 2)
						* (new Random().nextInt(39) + 217) / 255;

			}
			br.setHurt1(hurt);
			if (pet2.getBhp() - hurt <= 0) {
				pet2.setBhp(0);
				changeBhp(user2, no2, 0);
				br.setHurt2(0);
				br.setWin(1);
				return br;
			}
			pet2.setBhp(pet2.getBhp() - hurt);
			changeBhp(user2, no2, pet2.getBhp());
			if ("w".equals(bs2.getKind())) {
				hurt = ((((pet2.getLv() * 2 / 5 + 2) * bs2.getPower() * pet2.getRwg() / pet1.getRwf())) / 50 + 2)
						* (new Random().nextInt(39) + 217) / 255;

			} else if ("t".equals(bs2.getKind())) {
				hurt = ((((pet2.getLv() * 2 / 5 + 2) * bs2.getPower() * pet2.getRtg() / pet1.getRtf())) / 50 + 2)
						* (new Random().nextInt(39) + 217) / 255;

			}
			br.setHurt2(hurt);
			if (pet1.getBhp() - hurt <= 0)

			{
				pet1.setBhp(0);
				changeBhp(user1, no1, 0);
				br.setWin(2);
				return br;
			}
			pet1.setBhp(pet1.getBhp() - hurt);
			changeBhp(user1, no1, pet1.getBhp());

		} else {
			// 2先攻
			if ("w".equals(bs2.getKind())) {
				hurt = ((((pet2.getLv() * 2 / 5 + 2) * bs2.getPower() * pet2.getRwg() / pet1.getRwf())) / 50 + 2)
						* (new Random().nextInt(39) + 217) / 255;

			} else if ("t".equals(bs2.getKind())) {
				hurt = ((((pet2.getLv() * 2 / 5 + 2) * bs2.getPower() * pet2.getRtg() / pet1.getRtf())) / 50 + 2)
						* (new Random().nextInt(39) + 217) / 255;

			}
			br.setHurt2(hurt);
			if (pet1.getBhp() - hurt <= 0) {
				pet1.setBhp(0);
				changeBhp(user1, no1, 0);
				br.setHurt1(0);
				br.setWin(2);
				return br;
			}
			pet1.setBhp(pet1.getBhp() - hurt);
			changeBhp(user1, no1, pet1.getBhp());
			if ("w".equals(bs1.getKind())) {
				hurt = ((((pet1.getLv() * 2 / 5 + 2) * bs1.getPower() * pet1.getRwg() / pet2.getRwf())) / 50 + 2)
						* (new Random().nextInt(39) + 217) / 255;

			} else if ("t".equals(bs1.getKind())) {
				if ("w".equals(bs1.getKind())) {
					hurt = ((((pet1.getLv() * 2 / 5 + 2) * bs1.getPower() * pet1.getRtg() / pet2.getRtf())) / 50 + 2)
							* (new Random().nextInt(39) + 217) / 255;

				}
			}
			br.setHurt1(hurt);
			if (pet2.getBhp() - hurt <= 0) {
				pet2.setBhp(0);
				changeBhp(user2, no2, 0);
				br.setWin(1);
				return br;
			}
			pet2.setBhp(pet2.getBhp() - hurt);
			changeBhp(user2, no2, pet2.getBhp());
		}
		br.setWin(0);
		return br;
	}

	/*
	 * 捕捉宠物 X=( (3×MaxHP−2×CurrentHP)/3×MaxHP×Rate稀有度×Ball精灵球修正) ×Status异常状态修正
	 * 当X≥255时，捕获必定成功。
	 *  当X＜255时，
	 *  求出Y： Y = {1048560/(16711680 / X)的0.25次方}​
	 * 从0～65535间随机产生四个数，每有一个数字小于Y，精灵球摇晃一次。
	 *  如果四个数字全部小于Y，捕获成功。
	 * 因为球和状态暂时未实现，所以暂定稀有度为175，捕捉难度适中，以后再改
	 */
	public int catchPet(int rhp, int bhp) {
		int x = 175 * 1 * 1 * (3 * rhp - 2 * bhp) / (3 * rhp);
		int count = 0;
		if (x > 255) {
			count = 5;
		} else {
			int y = 1048560 / (int) Math.pow((16711680 / x), 0.25);
			for (int i = 0; i < 4; i++) {
				if (new Random().nextInt(65535) < y) {
					count++;
				} else {
					break;
				}
			}
		}
		return count;
	}

	/*
	 *  捕捉成功后，将野生的宠物加入到自己的宠物列表
	 */
	public int getPet(User user, Pet pet) {
		String sql = "update pets set uid=?,ownerName=? where no=?";
		return super.update(sql, user.getUid(), user.getNickName(), pet.getNo());
	}

	/*
	 *  单次pet2进攻，用于捕捉失败后，野生宠物攻击我方
	 */
	public BattleResult petsBattleSingel(User user1, Pet pet1, User user2, Pet pet2, BattleSkill bs2) {
		BattleResult br = new BattleResult();
		int no1 = pet1.getNo();
		int no2 = pet2.getNo();
		int hurt = 0;
		if ("w".equals(bs2.getKind())) {
			hurt = ((((pet2.getLv() * 2 / 5 + 2) * bs2.getPower() * pet2.getRwg() / pet1.getRwf())) / 50 + 2)
					* (new Random().nextInt(39) + 217) / 255;

		} else if ("t".equals(bs2.getKind())) {
			hurt = ((((pet2.getLv() * 2 / 5 + 2) * bs2.getPower() * pet2.getRtg() / pet1.getRtf())) / 50 + 2)
					* (new Random().nextInt(39) + 217) / 255;

		}
		br.setHurt2(hurt);
		if (pet1.getBhp() - hurt <= 0) {
			pet1.setBhp(0);
			br.setWin(22);
		} else {
			pet1.setBhp(pet1.getBhp() - hurt);
			br.setWin(20);
		}
		changeBhp(user1, no1, pet1.getBhp());
		return br;

	}
/*
 * 删除野生的随机宠物
 */
	public int deleteRandomPets() {
		int uid = 2;
		String sql = "delete from pets where  uid=?";
		int result = super.update(sql, uid);
		return result;
	}

	public static void main(String[] args) {
		GameDao gameImpl = new GameDaoImpl ();
		// System.out.println(gameImpl.catchPet(20,1));
		// User user=new User();
		// Pet pet=new Pet();
		// user.setUid(1);
		// pet.setNo(29);
		// gameImpl.getPet(user, pet);
		// gameImpl.deleteRandomPets();
		System.out.println(gameImpl.showUnames());
	}
}
