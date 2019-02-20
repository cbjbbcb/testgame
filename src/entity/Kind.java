package entity;

import java.util.List;

import util.BaseDao;

/**
 * 种族值表
 * 
 * @author Administrator
 *
 */
public class Kind {
	private int no;
	private int khp;
	private int kwg;
	private int kwf;
	private int ktg;
	private int ktf;
	private int ksd;
	private String imgL;
	private String name;
	private String shuxing;
	private Integer skill1;
	private Integer skillpp1;
	private Integer skill2;
	private Integer skillpp2;
	private Integer skill3;
	private Integer skillpp3;
	private Integer skill4;
	private Integer skillpp4;

	@Override
	public String toString() {
		return "Kind [no=" + no + ", khp=" + khp + ", kwg=" + kwg + ", kwf=" + kwf + ", ktg=" + ktg + ", ktf=" + ktf
				+ ", ksd=" + ksd + ", imgL=" + imgL + ", name=" + name + ", shuxing=" + shuxing + "]";
	}

	public Integer getSkill1() {
		return skill1;
	}

	public void setSkill1(Integer skill1) {
		this.skill1 = skill1;
	}

	public Integer getSkillpp1() {
		return skillpp1;
	}

	public void setSkillpp1(Integer skillpp1) {
		this.skillpp1 = skillpp1;
	}

	public Integer getSkill2() {
		return skill2;
	}

	public void setSkill2(Integer skill2) {
		this.skill2 = skill2;
	}

	public Integer getSkillpp2() {
		return skillpp2;
	}

	public void setSkillpp2(Integer skillpp2) {
		this.skillpp2 = skillpp2;
	}

	public Integer getSkill3() {
		return skill3;
	}

	public void setSkill3(Integer skill3) {
		this.skill3 = skill3;
	}

	public Integer getSkillpp3() {
		return skillpp3;
	}

	public void setSkillpp3(Integer skillpp3) {
		this.skillpp3 = skillpp3;
	}

	public Integer getSkill4() {
		return skill4;
	}

	public void setSkill4(Integer skill4) {
		this.skill4 = skill4;
	}

	public Integer getSkillpp4() {
		return skillpp4;
	}

	public void setSkillpp4(Integer skillpp4) {
		this.skillpp4 = skillpp4;
	}

	public String getShuxing() {
		return shuxing;
	}

	public void setShuxing(String shuxing) {
		this.shuxing = shuxing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgL() {
		return imgL;
	}

	public void setImgL(String imgL) {
		this.imgL = imgL;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getKhp() {
		return khp;
	}

	public void setKhp(int khp) {
		this.khp = khp;
	}

	public int getKwg() {
		return kwg;
	}

	public void setKwg(int kwg) {
		this.kwg = kwg;
	}

	public int getKwf() {
		return kwf;
	}

	public void setKwf(int kwf) {
		this.kwf = kwf;
	}

	public int getKtg() {
		return ktg;
	}

	public void setKtg(int ktg) {
		this.ktg = ktg;
	}

	public int getKtf() {
		return ktf;
	}

	public void setKtf(int ktf) {
		this.ktf = ktf;
	}

	public int getKsd() {
		return ksd;
	}

	public void setKsd(int ksd) {
		this.ksd = ksd;
	}

}
