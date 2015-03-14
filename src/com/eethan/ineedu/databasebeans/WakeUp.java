package com.eethan.ineedu.databasebeans;

import java.sql.Date;

public class WakeUp {
	public int waid;
	public int userId;
	public String sex;
	public int auth;
	public String acquirement;
	public String scope;
	public String date;
	public int pairUserId;
	
	public WakeUp(int userId,String sex,int auth,String aquirement,String scope,String date,int pairUserId)
	{
		this.userId = userId;
		this.sex = sex;
		this.auth = auth;
		this.acquirement = aquirement;
		this.scope = scope;
		this.date = date;
		this.pairUserId = pairUserId;
	}
	public WakeUp(){
	}
	
	public int getWaid() {
		return waid;
	}
	public void setWaid(int waid) {
		this.waid = waid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public String getAquirement() {
		return acquirement;
	}
	public void setAquirement(String aquirement) {
		this.acquirement = aquirement;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPairUserId() {
		return pairUserId;
	}
	public void setPairUserId(int pairUserId) {
		this.pairUserId = pairUserId;
	}
	
	
}
