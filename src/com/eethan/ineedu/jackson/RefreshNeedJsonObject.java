package com.eethan.ineedu.jackson;


import java.util.List;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserDetailInfo;

public class RefreshNeedJsonObject {
	private List<Need> needs;
	private List<UserInfo> userInfos;
	private List<UserInfo> solveUserInfos;
	private List<UserDetailInfo> userDetailInfos;
	
	public List<UserDetailInfo> getUserDetailInfos() {
		return userDetailInfos;
	}

	public void setUserDetailInfos(List<UserDetailInfo> userDetailInfos) {
		this.userDetailInfos = userDetailInfos;
	}
	private int lastNum;

	public RefreshNeedJsonObject(){}
	
	public RefreshNeedJsonObject(List<Need> needs,List<UserInfo> userInfos,List<UserInfo> solveUserInfos,List<UserDetailInfo> userDetailInfos,int lastNum){
		this.needs = needs;
		this.userInfos = userInfos;
		this.solveUserInfos = solveUserInfos;
		this.userDetailInfos = userDetailInfos;
		this.lastNum = lastNum;
	}
	
	public List<Need> getNeeds() {
		return needs;
	}
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}
	public List<UserInfo> getSolveUserInfos() {
		return solveUserInfos;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setNeeds(List<Need> needs) {
		this.needs = needs;
	}
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	public void setSolveUserInfos(List<UserInfo> solveUserInfos) {
		this.solveUserInfos = solveUserInfos;
	}
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
}
