package com.eethan.ineedu.databasebeans;



public class UserInfo{
	public int id;//用户资料信息唯一ID
	public int userId;//对应于User中的ID
	public String nickName;//昵称
	public String realName;//真实姓名
	public String sex;//性别
	public int loveNum;//用户爱心值
	public int popularityNum;//用户人气值
	public int flag;//标记
	
	public UserInfo(){}
	
	public UserInfo(int id,int userId,String nickName,String realName,String sex,int loveNum,int popularityNum) {
		this.id = id;
		this.userId = userId;
		this.nickName = nickName;
		this.realName = realName;
		this.sex = sex;
		this.loveNum = loveNum;
		this.popularityNum = popularityNum;
	}
	
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public String getNickName() {
		return nickName;
	}
	public String getRealName() {
		return realName;
	}
	public String getSex() {
		return sex;
	}
	public int getLoveNum() {
		return loveNum;
	}
	public int getPopularityNum() {
		return popularityNum;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setLoveNum(int loveNum) {
		this.loveNum = loveNum;
	}
	public void setPopularityNum(int popularityNum) {
		this.popularityNum = popularityNum;
	}
}
