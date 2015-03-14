package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;
import com.eethan.ineedu.databasebeans.Wish;
import com.eethan.ineedu.databasebeans.WishComment;

public class DetailWishJsonObject {
	private Wish wish;
	private UserInfo myUserInfo;//主人信息
	private List<WishComment> wishComments;
	private List<UserInfo> commentUserInfos;
	private List<UserLocation> commUserLocations;
	private UserDetailInfo userDetailInfo;
	
	public DetailWishJsonObject(){}
	
	public List<UserLocation> getCommUserLocations() {
		return commUserLocations;
	}


	public void setCommUserLocations(List<UserLocation> commUserLocations) {
		this.commUserLocations = commUserLocations;
	}


	public DetailWishJsonObject(Wish wish,UserInfo myUserInfo,
			List<WishComment> wishComments,List<UserInfo> commentUserInfos,List<UserLocation> commUserLocations,UserDetailInfo userDetailInfo){
		this.setWish(wish);
		this.setMyUserInfo(myUserInfo);
		this.setWishComments(wishComments);
		this.setCommentUserInfos(commentUserInfos);
		this.setCommUserLocations(commUserLocations);
		this.userDetailInfo = userDetailInfo;
	}

	
	public UserDetailInfo getUserDetailInfo() {
		return userDetailInfo;
	}

	public void setUserDetailInfo(UserDetailInfo userDetailInfo) {
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


	public Wish getWish() {
		return wish;
	}


	public void setWish(Wish wish) {
		this.wish = wish;
	}


	public List<WishComment> getWishComments() {
		return wishComments;
	}


	public void setWishComments(List<WishComment> wishComments) {
		this.wishComments = wishComments;
	}
}
