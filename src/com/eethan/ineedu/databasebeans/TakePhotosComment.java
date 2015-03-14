package com.eethan.ineedu.databasebeans;

public class TakePhotosComment {
	public int id;
	public int photoId;
	public int userId;
	public int commentedUserId;
	public String time;
	public String content;
	
	public TakePhotosComment(int id,int photoId,int userId,int commentedUserId,String time,String content)
	{
		this.id = id;
		this.photoId =photoId;
		this.userId = userId;
		this.commentedUserId = commentedUserId;
		this.time = time;
		this.content = content;
	}
	public TakePhotosComment(int photoId,int userId,int commentedUserId,String time,String content)
	{
		this.photoId =photoId;
		this.userId = userId;
		this.commentedUserId = commentedUserId;
		this.time = time;
		this.content = content;
	}
	public TakePhotosComment(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCommentedUserId() {
		return commentedUserId;
	}
	public void setCommentedUserId(int commentedUserId) {
		this.commentedUserId = commentedUserId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String cotent) {
		this.content = cotent;
	}
}
