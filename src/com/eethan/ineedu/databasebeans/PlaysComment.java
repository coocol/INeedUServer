package com.eethan.ineedu.databasebeans;

public class PlaysComment {
	public int id;
	public int playsId;
	public int userId;
	public int commentedUserId;
	public String time;
	public String content;
	
	public PlaysComment(int playsId,int userId,int commentedUserId,String time,String content)
	{
		this.playsId = playsId;
		this.userId = userId;
		this.commentedUserId = commentedUserId;
		this.time = time;
		this.content = content;
	}
	public PlaysComment()
	{
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getPlaysId() {
		return playsId;
	}
	public void setPlaysId(int playsId) {
		this.playsId = playsId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCommentedUserId() {
		return commentedUserId;
	}
	public void setCommentedUserId(int commentedUserId) {
		this.commentedUserId = commentedUserId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
