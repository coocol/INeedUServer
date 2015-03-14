package com.eethan.ineedu.databasebeans;

public class Notification{


	public int id;//一条通知唯一id
	public int notificationId;//因为哪一个需求或倾诉倾听而通知  -1为赞
	public int userId;//通知的人userId
	public int noticedId;//被通知的人userId
	public long time;//时间
	public int noticeFlag;//通知类型，需求未通知时为1，倾诉倾听未通知时为2，通知过了为-1


	/** default constructor */
	public Notification() {
	}

	/** full constructor */
	public Notification(int notificationId, int userId,
			int noticedId, long time, int noticeFlag) {
		this.notificationId = notificationId;
		this.userId = userId;
		this.noticedId = noticedId;
		this.time = time;
		this.noticeFlag = noticeFlag;
	}
	
	
	public int getId() {
		return id;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public int getUserId() {
		return userId;
	}
	public int getNoticedId() {
		return noticedId;
	}
	public long getTime() {
		return time;
	}
	public int getNoticeFlag() {
		return noticeFlag;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setNoticedId(int noticedId) {
		this.noticedId = noticedId;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public void setNoticeFlag(int noticeFlag) {
		this.noticeFlag = noticeFlag;
	}


}