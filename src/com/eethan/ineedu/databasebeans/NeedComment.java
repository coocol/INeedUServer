package com.eethan.ineedu.databasebeans;


public class NeedComment {
	public int id;//每一条评论唯一id
	public int needId;//对应need中的id，即哪一条需求
	public int userId;//谁评论的
	public int commentedUserId;//对谁发出的评论
	public long time;//评论的时间
	public String comment;//评论的内容
	
	
	public NeedComment(){}
	
	public NeedComment(int id, int needId,
			int userId, int commentedUserId,long time, String comment) {
		this.id = id;
		this.needId = needId;
		this.userId = userId;
		this.commentedUserId = commentedUserId; 
		this.time = time;
		this.comment = comment;
	}
	
	public int getId() {
		return id;
	}
	public int getNeedId() {
		return needId;
	}
	public int getUserId() {
		return userId;
	}
	public int getCommentedUserId() {
		return commentedUserId;
	}
	public long getTime() {
		return time;
	}
	public String getComment() {
		return comment;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNeedId(int needId) {
		this.needId = needId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setCommentedUserId(int commentedUserId) {
		this.commentedUserId = commentedUserId;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
