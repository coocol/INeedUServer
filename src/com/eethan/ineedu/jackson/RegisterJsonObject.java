package com.eethan.ineedu.jackson;

import com.eethan.ineedu.databasebeans.User;
import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class RegisterJsonObject {
	private User user;
	private UserInfo userInfo;
	private UserDetailInfo userDetailInfo;
	private UserLocation userLocation;
	
	public RegisterJsonObject(){}
	
	public RegisterJsonObject(User user,UserInfo userInfo,UserDetailInfo userDetailInfo,UserLocation userLocation){
		this.user = user;
		this.userInfo = userInfo;
		this.userDetailInfo = userDetailInfo;
		this.userLocation = userLocation;
	}
	
	public User getUser() {
		return user;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public UserDetailInfo getUserDetailInfo() {
		return userDetailInfo;
	}
	public UserLocation getUserLocation() {
		return userLocation;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public void setUserDetailInfo(UserDetailInfo userDetailInfo) {
		this.userDetailInfo = userDetailInfo;
	}
	public void setUserLocation(UserLocation userLocation) {
		this.userLocation = userLocation;
	}
	
	
}
