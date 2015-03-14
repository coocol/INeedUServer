package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Notification;

public class NotificationJsonObject {
	private List<Notification> notifications;
	private boolean result;
	
	public NotificationJsonObject(){}
	

	public NotificationJsonObject(List<Notification> notifications,boolean result){
		this.notifications = notifications;
		this.result = result;
	}
	
	public List<Notification> getNotifications() {
		return notifications;
	}
	public boolean getResult() {
		return result;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
}
