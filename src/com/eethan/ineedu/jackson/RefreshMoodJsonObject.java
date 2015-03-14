package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Mood;
import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class RefreshMoodJsonObject {

	public RefreshMoodJsonObject(){}
	
	private List<Mood> moods;
	private List<UserDetailInfo> userDetailInfos;
	private List<UserInfo> ownerUserInfos;
	private List<UserInfo> atUserInfos;
	private List<UserLocation> userLocations;
	private int lastNum;
	
	public RefreshMoodJsonObject(List<Mood> moods,List<UserDetailInfo> userDetailInfos,
			List<UserInfo> ownerUserInfos,List<UserInfo> atUserInfos,List<UserLocation> userLocations,int lastnum){
		this.moods = moods;
		this.userDetailInfos = userDetailInfos;
		this.userLocations = userLocations;
		this.atUserInfos = atUserInfos;
		this.ownerUserInfos = ownerUserInfos;
		this.lastNum = lastnum;
	}

	public int getLastNum() {
		return lastNum;
	}

	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}

	public List<UserDetailInfo> getUserDetailInfos() {
		return userDetailInfos;
	}

	public void setUserDetailInfos(List<UserDetailInfo> userDetailInfos) {
		this.userDetailInfos = userDetailInfos;
	}

	public List<UserInfo> getOwnerUserInfos() {
		return ownerUserInfos;
	}

	public void setOwnerUserInfos(List<UserInfo> ownerUserInfos) {
		this.ownerUserInfos = ownerUserInfos;
	}

	public List<UserInfo> getAtUserInfos() {
		return atUserInfos;
	}

	public void setAtUserInfos(List<UserInfo> atUserInfos) {
		this.atUserInfos = atUserInfos;
	}

	public List<UserLocation> getUserLocations() {
		return userLocations;
	}

	public void setUserLocations(List<UserLocation> userLocations) {
		this.userLocations = userLocations;
	}

	public List<Mood> getMoods() {
		return moods;
	}

	public void setMoods(List<Mood> moods) {
		this.moods = moods;
	}
}
