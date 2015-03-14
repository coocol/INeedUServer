package com.eethan.ineedu.databasebeans;

public class UserDetailInfo {
	
	public int id;//用户详细资料信息唯一ID
	public int userId;//对应于User中的ID
	public String signature;//个人签名
	public String school;//学校
	public String academy;//学院
	public String grade;//年级
	
	
	public UserDetailInfo() {}
	
	
	public UserDetailInfo(int id,int userId,String signature,String school,String academy,String grade){
		this.id = id;
		this.userId = userId;
		this.signature = signature;
		this.school = school;
		this.academy = academy;
		this.grade = grade;
	}
	
	
	public int getId() {
		return id;
	}
	public int getUserId() {
		return userId;
	}
	public String getSignature() {
		return signature;
	}
	public String getSchool() {
		return school;
	}
	public String getAcademy() {
		return academy;
	}
	public String getGrade() {
		return grade;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
