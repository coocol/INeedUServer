package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.TakePhotos;
import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;

public class RefreshPhotosJsonObject {
	private List<TakePhotos> takePhotos;
	private List<UserInfo> ownerUserInfos;//发布者
	private List<UserInfo> beAtManUserInfos;//被@的人们
	private int lastNum;
	private List<UserDetailInfo> userDetailInfos;
	
	public RefreshPhotosJsonObject(List<TakePhotos> takePhotos,List<UserInfo> userInfos,
			List<UserInfo> beAtManUserInfos,List<UserDetailInfo> userDetailInfo,int lastNum){
		this.takePhotos = takePhotos;
		this.ownerUserInfos = userInfos;
		this.beAtManUserInfos = beAtManUserInfos;
		this.userDetailInfos = userDetailInfo;
		this.lastNum = lastNum;
	}
	public List<UserDetailInfo> getUserDetailInfo() {
		return userDetailInfos;
	}
	public void setUserDetailInfo(List<UserDetailInfo> userDetailInfo) {
		this.userDetailInfos = userDetailInfo;
	}
	public RefreshPhotosJsonObject(){}
	public List<TakePhotos> getTakePhotos() {
		return takePhotos;
	}

	public void setTakePhotos(List<TakePhotos> takePhotos) {
		this.takePhotos = takePhotos;
	}

	public List<UserInfo> getOwnerUserInfos() {
		return ownerUserInfos;
	}

	public void setOwnerUserInfos(List<UserInfo> ownerUserInfos) {
		this.ownerUserInfos = ownerUserInfos;
	}

	public List<UserInfo> getBeAtManUserInfos() {
		return beAtManUserInfos;
	}

	public void setBeAtManUserInfos(List<UserInfo> beAtManUserInfos) {
		this.beAtManUserInfos = beAtManUserInfos;
	}

	public int getLastNum() {
		return lastNum;
	}

	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}

	
}
