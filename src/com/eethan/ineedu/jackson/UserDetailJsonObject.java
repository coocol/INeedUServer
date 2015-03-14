package com.eethan.ineedu.jackson;

import java.util.ArrayList;

import com.eethan.ineedu.databasebeans.Album;
import com.eethan.ineedu.databasebeans.User;
import com.eethan.ineedu.databasebeans.UserDescInfo;
import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class UserDetailJsonObject {
	
	public UserDetailJsonObject(){}

	public UserDescInfo getUserDescInfo() {
		return userDescInfo;
	}

	public void setUserDescInfo(UserDescInfo userDescInfo) {
		this.userDescInfo = userDescInfo;
	}
	public User user;
	public UserInfo userInfo;
	public UserDetailInfo userDetailInfo;
	public UserLocation userLocation;
	public ArrayList<Album> albums;
	public UserDescInfo userDescInfo;
	
	
	
	public UserDetailJsonObject(User user,UserInfo userInfo,UserDetailInfo userDetailInfo,UserLocation userLocation,UserDescInfo userDescInfo,ArrayList<Album> photourlList){
		this.user = user;
		this.userInfo = userInfo;
		this.userDetailInfo = userDetailInfo;
		this.userLocation = userLocation;
		this.albums = photourlList;
		this.userDescInfo = userDescInfo;
	}


	public ArrayList<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(ArrayList<Album> albums) {
		this.albums = albums;
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
