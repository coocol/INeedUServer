package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Mood;
import com.eethan.ineedu.databasebeans.MoodComment;
import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class DetailMoodJsonObject {

	private Mood mood;
	private UserInfo myUserInfo;
	private List<MoodComment> moodComments;
	private List<UserInfo> commentUserInfos;
	private List<UserLocation> commentUserLocations;
	private UserDetailInfo userDetailInfo;
	
	public DetailMoodJsonObject(){}
	
	public Mood getMood() {
		return mood;
	}
	public void setMood(Mood mood) {
		this.mood = mood;
	}
	public List<MoodComment> getMoodComments() {
		return moodComments;
	}
	public void setMoodComments(List<MoodComment> moodComments) {
		this.moodComments = moodComments;
	}
	public UserDetailInfo getUserDetailInfo() {
		return userDetailInfo;
	}
	public void setUserDetailInfo(UserDetailInfo userDetailInfo) {
		this.userDetailInfo = userDetailInfo;
	}
	public List<UserLocation> getCommentUserLocations() {
		return commentUserLocations;
	}
	public void setCommentUserLocations(List<UserLocation> commentUserLocations) {
		this.commentUserLocations = commentUserLocations;
	}
	
	public DetailMoodJsonObject(Mood mood,UserInfo myUserInfo,
			List<MoodComment> moodComments,List<UserInfo> commentUserInfos,List<UserLocation> commentUserLocatons,UserDetailInfo userDetailInfo){
		this.mood = mood;
		this.myUserInfo = myUserInfo;
		this.moodComments = moodComments;
		this.commentUserInfos = commentUserInfos;
		this.commentUserLocations = commentUserLocatons;
		this.userDetailInfo = userDetailInfo;
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
	
}
