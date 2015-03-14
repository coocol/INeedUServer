package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Need;
import com.eethan.ineedu.databasebeans.NeedComment;
import com.eethan.ineedu.databasebeans.UserDetailInfo;
import com.eethan.ineedu.databasebeans.UserInfo;
import com.eethan.ineedu.databasebeans.UserLocation;

public class DetailNeedJsonObject {
	private Need need;
	private UserInfo myUserInfo;
	private List<UserInfo> otherUserInfos;
	private List<NeedComment> needComments;
	private UserInfo solveUserInfo;
	private List<UserLocation> otherUserLocations;
	private UserDetailInfo userDetailInfo;

	public UserDetailInfo getUserDetailInfo() {
		return userDetailInfo;
	}

	public void setUserDetailInfo(UserDetailInfo userDetailInfo) {
		this.userDetailInfo = userDetailInfo;
	}

	public List<UserLocation> getOtherUserLocations() {
		return otherUserLocations;
	}

	public void setOtherUserLocations(List<UserLocation> otherUserLocations) {
		this.otherUserLocations = otherUserLocations;
	}

	public DetailNeedJsonObject() {
	}

	public DetailNeedJsonObject(Need need, UserInfo myUserInfo,
			List<UserInfo> otherUserInfos,List<UserLocation> otherUserLocations, List<NeedComment> needComments,
			UserInfo solveUserInfo,UserDetailInfo userDetailInfo) {
		this.need = need;
		this.myUserInfo = myUserInfo;
		this.otherUserInfos = otherUserInfos;
		this.needComments = needComments;
		this.solveUserInfo = solveUserInfo;
		this.otherUserLocations = otherUserLocations;
		this.userDetailInfo = userDetailInfo;
	}

	public Need getNeed() {
		return need;
	}

	public UserInfo getMyUserInfo() {
		return myUserInfo;
	}

	public List<UserInfo> getOtherUserInfos() {
		return otherUserInfos;
	}

	public List<NeedComment> getNeedComments() {
		return needComments;
	}

	public UserInfo getSolveUserInfo() {
		return solveUserInfo;
	}

	public void setNeed(Need need) {
		this.need = need;
	}

	public void setMyUserInfo(UserInfo myUserInfo) {
		this.myUserInfo = myUserInfo;
	}

	public void setOtherUserInfos(List<UserInfo> otherUserInfos) {
		this.otherUserInfos = otherUserInfos;
	}

	public void setNeedComments(List<NeedComment> needComments) {
		this.needComments = needComments;
	}

	public void setSolveUserInfo(UserInfo solveUserInfo) {
		this.solveUserInfo = solveUserInfo;
	}

}
