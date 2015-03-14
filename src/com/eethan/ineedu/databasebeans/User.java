package com.eethan.ineedu.databasebeans;


public class User{
	public int id;//用户唯一ID
	public String tele;//用户电话
	public String password;//用户密码
	public String email;//用户邮箱
	//qq第三方登陆使用
	public String uid;
	public String imageUrl;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int id,String tele,String password,String email) {
		this.id = id;
		this.tele = tele;
		this.password = password;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public String getTele() {
		return tele;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
