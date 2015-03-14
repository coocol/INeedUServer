package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.Wish;
import com.eethan.ineedu.databasebeans.WishWithWannaNum;

public class RefreshWishJsonObject {
	private List<Wish> wishs;
	private List<WishWithWannaNum> wishWithWannaNums;
	private List<UserInfo> ownerUserInfos;//发布者\
	public List<WishWithWannaNum> getWishWithWannaNums() {
		return wishWithWannaNums;
	}
	public void setWishWithWannaNums(List<WishWithWannaNum> wishWithWannaNums) {
		this.wishWithWannaNums = wishWithWannaNums;
	}
	private List<UserDetailInfo> userDetailInfos;
	public List<UserDetailInfo> getUserDetailInfos() {
		return userDetailInfos;
	}
	public void setUserDetailInfos(List<UserDetailInfo> userDetailInfos) {
		this.userDetailInfos = userDetailInfos;
	}
	private int lastNum;
	
	public RefreshWishJsonObject(List<UserInfo> userInfos,List<UserDetailInfo> userDetailInfos,
			int lastNum,List<WishWithWannaNum> wannaNums){
		this.ownerUserInfos = userInfos;
		this.userDetailInfos = userDetailInfos;
		this.lastNum = lastNum;
		this.wishWithWannaNums = wannaNums;
	}
	
	public RefreshWishJsonObject(List<Wish> wishs,List<UserInfo> userInfos,List<UserDetailInfo> userDetailInfos,
			int lastNum){
		this.setWishs(wishs);
		this.ownerUserInfos = userInfos;
		this.userDetailInfos = userDetailInfos;
		this.lastNum = lastNum;
	}
	
	public RefreshWishJsonObject(){}
	

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
	public List<Wish> getWishs() {
		return wishs;
	}
	public void setWishs(List<Wish> wishs) {
		this.wishs = wishs;
	}

	
}
