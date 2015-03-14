package com.eethan.ineedu.jackson;


public class WakeUpJsonObject {
	private int boyNum;
	private int girlNum;
	private int totalNum;
	private int pairId=0;
	private int auth;
	private int matchCondition;
	private String sex;
	private String require;
	private String pairTele;
	
	public WakeUpJsonObject(int boyNum,int girlNum,int totalNum,int pairId,int auth,int matchCondition,
			String sex,String require,String pairTele){
		this.boyNum = boyNum;
		this.girlNum = girlNum;
		this.totalNum = totalNum;
		this.pairId = pairId;
		this.auth = auth;
		this.matchCondition = matchCondition;
		this.sex = sex;
		this.require = require;
		this.pairTele =pairTele;
	}
	public WakeUpJsonObject(){}
	
	public int getBoyNum() {
		return boyNum;
	}
	public void setBoyNum(int boyNum) {
		this.boyNum = boyNum;
	}
	public int getGirlNum() {
		return girlNum;
	}
	public void setGirlNum(int girlNum) {
		this.girlNum = girlNum;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	public String getRequire() {
		return require;
	}
	public void setRequire(String require) {
		this.require = require;
	}
	public int getPairId() {
		return pairId;
	}
	public void setPairId(int pairId) {
		this.pairId = pairId;
	}
	public String getPairTele() {
		return pairTele;
	}
	public void setPairTele(String pairTele) {
		this.pairTele = pairTele;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getMatchCondition() {
		return matchCondition;
	}
	public void setMatchCondition(int matchCondition) {
		this.matchCondition = matchCondition;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	
}
