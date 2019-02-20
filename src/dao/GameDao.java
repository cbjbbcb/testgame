package dao;

import java.util.List;

import entity.BattleResult;
import entity.BattleSkill;
import entity.Kind;
import entity.Pet;
import entity.User;

public interface GameDao {

	/**
	 * 
	 * 用户部分*********************************************************************************************************************
	 */

	/*
	 * 用户注册
	 * 
	 */
	public int register(String uname, String password, String nickName);

	/*
	 * 得出所有用户名，用于避免注册重复
	 */
	public List showUnames();

	/*
	 * 用户登陆
	 * 
	 */
	public User login(String uname, String password);

	/**
	 * pet部分****************************************************************************************************************
	 */
	/*
	 * 创建一个宠物
	 */
	public Pet CreatePet(User user);

	/*
	 * 根据编号删除宠物
	 */
	public int deletePet(User user, int no);

	/*
	 * 改变战斗时生命值
	 */
	public void changeBhp(User user, int no, int hp);

	/*
	 * 恢复宠物战斗生命值
	 */
	public void recover(User user);

	/*
	 * 获得训练师第n个的宠物
	 */
	public Pet showPet(User user, int n);

	/*
	 * 获得训练师所有宠物
	 */
	public List<Pet> showPets(User user);

	/*
	 * 训练师宠物个数
	 * 
	 */
	public int showPetsCount(User user);

	/*
	 * 第n个和第一个互换
	 * 
	 */
	public void petToFirst(User user, int n);

	/*
	 * 宠物升级经验结算存储
	 */
	public Pet petExp(User user, Pet pet);

	/*
	 * 宠物战斗力排行榜
	 */
	public List<Pet> getRanking();

	/**
	 * kind部分****************************************************************************************************************
	 */
	/*
	 * kind编号返回kind对象
	 */
	public Kind getKindValue(int no);

	/**
	 * battle部分****************************************************************************************************************
	 */

	/*
	 * 技能编号获得技能
	 * 
	 */
	public BattleSkill getSkill(int no);

	/*
	 * 技能编号获得技能名
	 * 
	 */
	public String getSkillName(int no);
	/*
	 * 获得该宠物的所有技能
	 * 
	 */
	public List<BattleSkill> getSkills(Pet pet);
	/*
	 * 技能1，2，3，4获得对应位置的技能
	 * 
	 */
	public BattleSkill getSkillbyAtkNo(Pet pet, int no);

	/*
	 * 随机释放技能
	 * 
	 */
	public BattleSkill getSkillbyRandom(Pet pet);

	/*
	 * 两个训练师，宠物进行战斗
	 */
	public BattleResult petsBattle(User user1, Pet pet1, BattleSkill bs1, User user2, Pet pet2, BattleSkill bs2);

	/*
	 * 捕捉宠物 X=( (3×MaxHP−2×CurrentHP)/3×MaxHP×Rate稀有度×Ball精灵球修正) ×Status异常状态修正
	 * 当X≥255时，捕获必定成功。 当X＜255时， 求出Y： Y = {1048560/(16711680 / X)的0.25次方}​
	 * 从0～65535间随机产生四个数，每有一个数字小于Y，精灵球摇晃一次。 如果四个数字全部小于Y，捕获成功。
	 * 因为球和状态暂时未实现，所以暂定稀有度为175，捕捉难度适中，以后再改
	 */

	public int catchPet(int rhp, int bhp);

	/*
	 * 捕捉成功后，将野生的宠物加入到自己的宠物列表
	 */
	public int getPet(User user, Pet pet);

	/*
	 * 单次pet2进攻，用于捕捉失败后，野生宠物攻击我方
	 */
	public BattleResult petsBattleSingel(User user1, Pet pet1, User user2, Pet pet2, BattleSkill bs2);

	/*
	 * 删除野生的随机宠物
	 */
	public int deleteRandomPets();

}
