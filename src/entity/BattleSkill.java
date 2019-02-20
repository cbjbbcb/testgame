package entity;

import java.util.List;
import java.util.Random;

import util.BaseDao;

public class BattleSkill {
	private int no;
	private String skillName;
	private Integer power;
	private String desciption;
	private String kind;
	private int pp;
	private String shuxing;
	private int mingzhong;

	@Override
	public String toString() {
		return "BattleSkill [no=" + no + ", skillName=" + skillName + ", power=" + power + ", desciption=" + desciption
				+ ", kind=" + kind + ", pp=" + pp + ", shuxing=" + shuxing + ", mingzhong=" + mingzhong + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public String getShuxing() {
		return shuxing;
	}

	public void setShuxing(String shuxing) {
		this.shuxing = shuxing;
	}

	public int getMingzhong() {
		return mingzhong;
	}

	public void setMingzhong(int mingzhong) {
		this.mingzhong = mingzhong;
	}


}
