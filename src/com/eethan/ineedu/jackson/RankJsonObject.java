package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.LovePopularityIncrease;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class RankJsonObject {
	private List<UserInfo> userInfos;
	private List<UserLocation> userLocations;
	
	private List<UserInfo> icreaseUserInfos;
	private List<UserLocation> icreaseuserLocations;
	private List<LovePopularityIncrease> lovePopularityIncreases;
	
	public RankJsonObject() {}
	
	public RankJsonObject(List<UserInfo> userInfos,List<UserLocation> userLocations,
			List<UserInfo> icreaseUserInfos,List<UserLocation> icreaseuserLocations,
			List<LovePopularityIncrease> lovePopularityIncreases) {
		this.userInfos = userInfos;
		this.userLocations = userLocations;
		this.icreaseUserInfos = icreaseUserInfos;
		this.icreaseuserLocations = icreaseuserLocations;
		this.lovePopularityIncreases = lovePopularityIncreases;
	}
	
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}
	public List<UserLocation> getUserLocations() {
		return userLocations;
	}
	public List<UserInfo> getIcreaseUserInfos() {
		return icreaseUserInfos;
	}
	public List<UserLocation> getIcreaseuserLocations() {
		return icreaseuserLocations;
	}
	public List<LovePopularityIncrease> getLovePopularityIncreases() {
		return lovePopularityIncreases;
	}
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	public void setUserLocations(List<UserLocation> userLocations) {
		this.userLocations = userLocations;
	}
	public void setIcreaseUserInfos(List<UserInfo> icreaseUserInfos) {
		this.icreaseUserInfos = icreaseUserInfos;
	}
	public void setIcreaseuserLocations(List<UserLocation> icreaseuserLocations) {
		this.icreaseuserLocations = icreaseuserLocations;
	}
	public void setLovePopularityIncreases(
			List<LovePopularityIncrease> lovePopularityIncreases) {
		this.lovePopularityIncreases = lovePopularityIncreases;
	}
}
