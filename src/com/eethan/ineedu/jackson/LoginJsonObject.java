package com.eethan.ineedu.jackson;

import com.eethan.ineedu.databasebeans.User;
import com.eethan.ineedu.databasebeans.UserInfo;

public class LoginJsonObject {
	private User user;
	private UserInfo userInfo;
	private boolean result;
	
	public LoginJsonObject(){}
	
	public LoginJsonObject(User user,UserInfo userInfo,boolean result){
		this.user = user;
		this.userInfo = userInfo;
		this.result = result;
	}
	
	
	public User getUser() {
		return user;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public boolean getResult() {
		return result;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
}
