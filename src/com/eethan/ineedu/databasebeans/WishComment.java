package com.eethan.ineedu.databasebeans;

public class WishComment {
	public int id;
	public int wishId;
	public int userId;
	public int commentedUserId;
	public String time;
	public String content;
	
	
	public WishComment(int wishId,int userId,int commentedUserId,String time,String content)
	{
		this.wishId =wishId;
		this.setUserId(userId);
		this.setCommentedUserId(commentedUserId);
		this.setTime(time);
		this.setContent(content);
	}
	public WishComment(){}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getWishId() {
		return wishId;
	}


	public void setWishId(int wishId) {
		this.wishId = wishId;
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


	public void setContent(String content) {
		this.content = content;
	}
}
