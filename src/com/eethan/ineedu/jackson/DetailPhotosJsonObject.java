package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.TakePhotos;
import com.eethan.ineedu.databasebeans.TakePhotosComment;
import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class DetailPhotosJsonObject {
	private TakePhotos takePhotos;
	private UserInfo myUserInfo;
	private List<TakePhotosComment> photosComments;
	private List<UserInfo> commentUserInfos;
	private List<UserLocation> commentUserLocations;
	private UserInfo atWho;//转发谁的
	private UserDetailInfo userDetailInfo;
	
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
	
	public DetailPhotosJsonObject(TakePhotos takePhotos,UserInfo myUserInfo,
			List<TakePhotosComment> photosComments,List<UserInfo> commentUserInfos,List<UserLocation> commentUserLocatons,UserDetailInfo userDetailInfo,UserInfo atWho){
		this.takePhotos = takePhotos;
		this.myUserInfo = myUserInfo;
		this.photosComments = photosComments;
		this.commentUserInfos = commentUserInfos;
		this.commentUserLocations = commentUserLocatons;
		this.userDetailInfo = userDetailInfo;
		this.atWho = atWho;
	}
	public DetailPhotosJsonObject(){}
	
	public TakePhotos getTakePhotos() {
		return takePhotos;
	}
	public void setTakePhotos(TakePhotos takePhotos) {
		this.takePhotos = takePhotos;
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
	public List<TakePhotosComment> getPhotosComments() {
		return photosComments;
	}
	public void setPhotosComments(List<TakePhotosComment> photosComments) {
		this.photosComments = photosComments;
	}
	public UserInfo getAtWho() {
		return atWho;
	}
	public void setAtWho(UserInfo atWho) {
		this.atWho = atWho;
	}
	
}
