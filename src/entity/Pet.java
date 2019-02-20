package entity;

import java.util.Random;

import util.BaseDao;

public class Pet {
	/*
	 * 种族值
	 */

	private int khp;
	private int kwg;
	private int kwf;
	private int ktg;
	private int ktf;
	private int ksd;
	/*
	 * 个体值
	 */
	private int ohp;
	private int owg;
	private int owf;
	private int otg;
	private int otf;
	private int osd;
	/**
	 * 实际值
	 */
	private int rhp;
	private int rwg;
	private int rwf;
	private int rtg;
	private int rtf;
	private int rsd;
	private int lv = 5;
	private String pinzhi;
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
	private int no;
	private int bhp;
	private int exp;
	private int expMax;
	private int uid;
	private String ownerName;
	
	
	public String getOwnerName() {
	return ownerName;
}

public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int emp) {
		this.exp = emp;
	}

	public int getExpMax() {
		return expMax;
	}

	public void setExpMax() {
		this.expMax = (int) (this.lv * this.lv * this.lv * 0.8);
	}

	public int getBhp() {
		return bhp;
	}

	public void setBhp(int bhp) {
		this.bhp = bhp;
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

	public String getPinzhi() {
		return pinzhi;
	}

	public void setPinzhi(String pinzhi) {
		this.pinzhi = pinzhi;
	}

	public String getImgL() {
		return imgL;
	}

	public void setImgL(String imgL) {
		this.imgL = imgL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShuxing() {
		return shuxing;
	}

	public void setShuxing(String shuxing) {
		this.shuxing = shuxing;
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setOhp(int ohp) {
		this.ohp = ohp;
	}

	public void setOwg(int owg) {
		this.owg = owg;
	}

	public void setOwf(int owf) {
		this.owf = owf;
	}

	public void setOtg(int otg) {
		this.otg = otg;
	}

	public void setOtf(int otf) {
		this.otf = otf;
	}

	public void setOsd(int osd) {
		this.osd = osd;
	}

	public void setRhp(int rhp) {
		this.rhp = rhp;
	}

	public void setRwg(int rwg) {
		this.rwg = rwg;
	}

	public void setRwf(int rwf) {
		this.rwf = rwf;
	}

	public void setRtg(int rtg) {
		this.rtg = rtg;
	}

	public void setRtf(int rtf) {
		this.rtf = rtf;
	}

	public void setRsd(int rsd) {
		this.rsd = rsd;
	}

	public void setPinzhi() {
		int sum = ohp + owg + owf + otg + otf + osd;
		if (sum > 150) {
			pinzhi = "S";
		} else if (sum > 130) {
			pinzhi = "A";
		} else if (sum > 110) {
			pinzhi = "B";
		} else if (sum > 90) {
			pinzhi = "C";
		} else {
			pinzhi = "D";
		}
	}

	public int getRhp() {
		return rhp;
	}

	// [LV×(HP种族值+HP个体值)÷50]+[LV×(努力LV)÷100]+10+LV
	public void setRhp() {
		this.rhp = lv * (khp + ohp) / 50 + lv / 100 + 10 + lv;
	}

	public int getRwg() {
		return rwg;
	}

	public void setRwg() {
		this.rwg = lv * (kwg + owg) / 50 + lv / 100 + 10 + lv;
	}

	public int getRwf() {
		return rwf;
	}

	public void setRwf() {
		this.rwf = lv * (kwf + owf) / 50 + lv / 100 + 10 + lv;
	}

	public int getRtg() {
		return rtg;
	}

	public void setRtg() {
		this.rtg = lv * (ktg + otg) / 50 + lv / 100 + 10 + lv;
	}

	public int getRtf() {
		return rtf;
	}

	public void setRtf() {
		this.rtf = lv * (ktf + otf) / 50 + lv / 100 + 10 + lv;
	}

	public int getRsd() {
		return rsd;
	}

	public void setRsd() {
		this.rsd = lv * (ksd + osd) / 50 + lv / 100 + 10 + lv;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getOhp() {
		return ohp;
	}

	public void setOhp() {
		this.ohp = new Random().nextInt(32);
	}

	public int getOwg() {
		return owg;
	}

	public void setOwg() {
		this.owg = new Random().nextInt(32);
	}

	public int getOwf() {
		return owf;
	}

	public void setOwf() {
		this.owf = new Random().nextInt(32);
	}

	public int getOtg() {
		return otg;
	}

	public void setOtg() {
		this.otg = new Random().nextInt(32);
	}

	public int getOtf() {
		return otf;
	}

	public void setOtf() {
		this.otf = new Random().nextInt(32);
	}

	public int getOsd() {
		return osd;
	}

	public void setOsd() {
		this.osd = new Random().nextInt(32);
	}

	@Override
	public String toString() {
		return "Pet [khp=" + khp + ", kwg=" + kwg + ", kwf=" + kwf + ", ktg=" + ktg + ", ktf=" + ktf + ", ksd=" + ksd
				+ ", ohp=" + ohp + ", owg=" + owg + ", owf=" + owf + ", otg=" + otg + ", otf=" + otf + ", osd=" + osd
				+ ", rhp=" + rhp + ", rwg=" + rwg + ", rwf=" + rwf + ", rtg=" + rtg + ", rtf=" + rtf + ", rsd=" + rsd
				+ ", lv=" + lv + ", pinzhi=" + pinzhi + ", imgL=" + imgL + ", name=" + name + ", shuxing=" + shuxing
				+ ", skill1=" + skill1 + ", skillpp1=" + skillpp1 + ", skill2=" + skill2 + ", skillpp2=" + skillpp2
				+ ", skill3=" + skill3 + ", skillpp3=" + skillpp3 + ", skill4=" + skill4 + ", skillpp4=" + skillpp4
				+ ", no=" + no + ", bhp=" + bhp + ", exp=" + exp + ", expMax=" + expMax + ", uid=" + uid
				+ ", ownerName=" + ownerName + "]";
	}

}
