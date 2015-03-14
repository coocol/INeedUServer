package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class SearchUserJsonObject {

	private List<UserInfo> userInfos;
	private List<UserLocation> userLocations;

	private boolean result;
	
	public SearchUserJsonObject(){}

	public SearchUserJsonObject(List<UserInfo> userInfos,boolean result){
		this.userInfos = userInfos;
		this.result = result;
	}
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public boolean getResult() {
		return result;
	}
	
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}

	public List<UserLocation> getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(List<UserLocation> userLocations) {
		this.userLocations = userLocations;
	}
	
	
}
