package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Molest;
import com.eethan.ineedu.databasebeans.UserInfo;

public class MolestJsonObject {
	private List<Molest> molests;
	private List<UserInfo> userInfos;
	private List<UserInfo> commentedUserInfos;
	private int lastNum;
	
	public MolestJsonObject() {
		// TODO Auto-generated constructor stub
	}
	public MolestJsonObject(List<Molest> molests,List<UserInfo> userInfos,
			List<UserInfo> commentedUserInfos,int lastNum) {
		// TODO Auto-generated constructor stub
		this.setMolests(molests);
		this.setUserInfos(userInfos);
		this.setCommentedUserInfos(commentedUserInfos);
		this.setLastNum(lastNum);
	}
	public List<Molest> getMolests() {
		return molests;
	}
	public void setMolests(List<Molest> molests) {
		this.molests = molests;
	}
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	public List<UserInfo> getCommentedUserInfos() {
		return commentedUserInfos;
	}
	public void setCommentedUserInfos(List<UserInfo> commentedUserInfos) {
		this.commentedUserInfos = commentedUserInfos;
	}
}
