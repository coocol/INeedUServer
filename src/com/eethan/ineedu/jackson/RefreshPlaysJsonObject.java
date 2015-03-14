package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Plays;
import com.eethan.ineedu.databasebeans.UserInfo;

public class RefreshPlaysJsonObject {
	private List<Plays> plays;
	private List<UserInfo> ownerUserInfos;//发布者
	private int lastNum;
	
	
	public RefreshPlaysJsonObject(List<Plays> plays,List<UserInfo> userInfos,
			int lastNum){
		this.setPlays(plays);
		this.ownerUserInfos = userInfos;
		this.lastNum = lastNum;
	}
	public RefreshPlaysJsonObject(){}
	

	public List<UserInfo> getOwnerUserInfos() {
		return ownerUserInfos;
	}

	public void setOwnerUserInfos(List<UserInfo> ownerUserInfos) {
		this.ownerUserInfos = ownerUserInfos;
	}


	public int getLastNum() {
		return lastNum;
	}

	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	public List<Plays> getPlays() {
		return plays;
	}
	public void setPlays(List<Plays> plays) {
		this.plays = plays;
	}

}
