package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Notification;
import com.eethan.ineedu.databasebeans.UserInfo;

public class AllNotificationsJsonObject {
	private List<Notification> notifications;
	private List<UserInfo> userInfos;//回复者的信息
	private List<String> comments;
	private boolean result;
	private int lastNum;
	
	public AllNotificationsJsonObject()
	{}
	public AllNotificationsJsonObject(List<Notification> notifications,
			List<UserInfo> userInfos,List<String> comments,boolean result,int lastNum)
	{
		this.notifications=notifications;
		this.userInfos=userInfos;
		this.comments=comments;
		this.result=result;
		this.lastNum=lastNum;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	public List<UserInfo> getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
}
