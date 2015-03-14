package com.eethan.ineedu.databasebeans;


public class LovePopularityIncrease{


	public int id;
	public int userId;//用户
	public int oldLoveNum;//上次的爱心值
	public int oldPopularityNum ;//上次的人气值
	public int increaseLoveNum;//爱心增长值
	public int increasePopularityNum ;//人气增长值
	
	

	/** default constructor */
	public LovePopularityIncrease() {
	}

	/** full constructor */
	public LovePopularityIncrease(int id,int userId,int oldLoveNum,
			int oldPopularityNum, int increaseLoveNum, int increasePopularityNum) {
		this.id = id;
		this.userId = userId;
		this.oldLoveNum = oldLoveNum;
		this.oldPopularityNum = oldPopularityNum;
		this.increaseLoveNum = increaseLoveNum;
		this.increasePopularityNum = increasePopularityNum;
	}
	
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public int getOldLoveNum() {
		return oldLoveNum;
	}
	public int getOldPopularityNum() {
		return oldPopularityNum;
	}
	public int getIncreaseLoveNum() {
		return increaseLoveNum;
	}
	public int getIncreasePopularityNum() {
		return increasePopularityNum;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setOldLoveNum(int oldLoveNum) {
		this.oldLoveNum = oldLoveNum;
	}
	public void setOldPopularityNum(int oldPopularityNum) {
		this.oldPopularityNum = oldPopularityNum;
	}
	public void setIncreaseLoveNum(int increaseLoveNum) {
		this.increaseLoveNum = increaseLoveNum;
	}
	public void setIncreasePopularityNum(int increasePopularityNum) {
		this.increasePopularityNum = increasePopularityNum;
	}
}

