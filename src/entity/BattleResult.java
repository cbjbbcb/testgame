package entity;

public class BattleResult {
	private int win;
	private int first;
	private int hurt1;
	private int hurt2;
	private String skill1;
	private String skill2;
	private int exp;
	private int up;
	private String name1;
	private String name2;
	private int rhp1;
	private int rhp2;
	private int bhp1;
	private int bhp2;
	private String imgL1;
	private String imgL2;
	@Override
	public String toString() {
		return "BattleResult [win=" + win + ", first=" + first + ", hurt1=" + hurt1 + ", hurt2=" + hurt2 + ", skill1="
				+ skill1 + ", skill2=" + skill2 + ", exp=" + exp + ", up=" + up + ", name1=" + name1 + ", name2="
				+ name2 + ", rhp1=" + rhp1 + ", rhp2=" + rhp2 + ", bhp1=" + bhp1 + ", bhp2=" + bhp2 + ", imgL1=" + imgL1
				+ ", imgL2=" + imgL2 + "]";
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public int getRhp1() {
		return rhp1;
	}

	public void setRhp1(int rhp1) {
		this.rhp1 = rhp1;
	}

	public int getRhp2() {
		return rhp2;
	}

	public void setRhp2(int rhp2) {
		this.rhp2 = rhp2;
	}

	public int getBhp1() {
		return bhp1;
	}

	public void setBhp1(int bhp1) {
		this.bhp1 = bhp1;
	}

	public int getBhp2() {
		return bhp2;
	}

	public void setBhp2(int bhp2) {
		this.bhp2 = bhp2;
	}

	public String getImgL1() {
		return imgL1;
	}

	public void setImgL1(String imgL1) {
		this.imgL1 = imgL1;
	}

	public String getImgL2() {
		return imgL2;
	}

	public void setImgL2(String imgL2) {
		this.imgL2 = imgL2;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getHurt1() {
		return hurt1;
	}

	public void setHurt1(int hurt1) {
		this.hurt1 = hurt1;
	}

	public int getHurt2() {
		return hurt2;
	}

	public void setHurt2(int hurt2) {
		this.hurt2 = hurt2;
	}

	public String getSkill1() {
		return skill1;
	}

	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}

	public String getSkill2() {
		return skill2;
	}

	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}

}
