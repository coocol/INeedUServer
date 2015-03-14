package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Plays;
import com.eethan.ineedu.databasebeans.PlaysComment;
import com.eethan.ineedu.databasebeans.TakePhotosComment;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class DetailPlaysJsonObject {
	private Plays plays;
	private UserInfo myUserInfo;//主人信息
	private List<PlaysComment> comments;
	private List<UserInfo> commentUserInfos;
	private List<Integer> members;//所有已报名成员
	private List<UserLocation> commentUserLocations;
	public List<UserLocation> getCommentUserLocations() {
		return commentUserLocations;
	}
	public void setCommentUserLocations(List<UserLocation> commentUserLocations) {
		this.commentUserLocations = commentUserLocations;
	}
	
	public DetailPlaysJsonObject(){}
	
	public DetailPlaysJsonObject(Plays plays,UserInfo myUserInfo,
			List<PlaysComment> comments,List<UserInfo> commentUserInfos,List<UserLocation> commuserLocations,
			List<Integer> members){
		this.setPlays(plays);
		this.setMyUserInfo(myUserInfo);
		this.setComments(comments);
		this.setCommentUserInfos(commentUserInfos);
		this.members = members;
		this.commentUserLocations = commuserLocations;
	}

	public Plays getPlays() {
		return plays;
	}

	public void setPlays(Plays plays) {
		this.plays = plays;
	}

	public UserInfo getMyUserInfo() {
		return myUserInfo;
	}

	public void setMyUserInfo(UserInfo myUserInfo) {
		this.myUserInfo = myUserInfo;
	}

	
	public List<UserInfo> getCommentUserInfos() {
		return commentUserInfos;
	}

	public void setCommentUserInfos(List<UserInfo> commentUserInfos) {
		this.commentUserInfos = commentUserInfos;
	}

	public List<PlaysComment> getComments() {
		return comments;
	}

	public void setComments(List<PlaysComment> comments) {
		this.comments = comments;
	}

	public List<Integer> getMembers() {
		return members;
	}

	public void setMembers(List<Integer> members) {
		this.members = members;
	}

	
}
