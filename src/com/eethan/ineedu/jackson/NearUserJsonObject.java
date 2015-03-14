package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class NearUserJsonObject {

	private List<UserInfo> userInfos;
	private List<UserLocation> userLocations;
	private List<UserDetailInfo> userDetailInfos;
	public List<UserDetailInfo> getUserDetailInfos() {
		return userDetailInfos;
	}

	public void setUserDetailInfos(List<UserDetailInfo> userDetailInfos) {
		this.userDetailInfos = userDetailInfos;
	}
	private int lastNum;
	
	public NearUserJsonObject(){}
	
	public NearUserJsonObject(List<UserInfo> userInfos,List<UserLocation> userLocations,List<UserDetailInfo> userDetailInfos,int lastNum){
		this.userInfos = userInfos;
		this.userLocations = userLocations;
		this.userDetailInfos = userDetailInfos;
		this.lastNum = lastNum;
	}
	
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}
	public List<UserLocation> getUserLocations() {
		return userLocations;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	public void setUserLocations(List<UserLocation> userLocations) {
		this.userLocations = userLocations;
	}
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
}
