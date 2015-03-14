package com.eethan.ineedu.databasebeans;


public class PourlistenComment {
	public int id;//每一条评论唯一id
	public int pourlistenId;//对应pourlisten中的id,即哪一条倾诉倾听
	public int userId;//谁评论的
	public int commentedUserId;//对谁发出的评论
	public long time;//评论的时间
	public String comment;//评论的内容
	
	
	public PourlistenComment(){}
	
	public PourlistenComment(int id, int pourlistenId,
			int userId, int commentedUserId,long time, String comment) {
		this.id = id;
		this.pourlistenId = pourlistenId;
		this.userId = userId;
		this.commentedUserId = commentedUserId;               
		this.time = time;
		this.comment = comment;
	}
	
	public int getId() {
		return id;
	}
	public int getPourlistenId() {
		return pourlistenId;
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
	public void setPourlistenId(int pourlistenId) {
		this.pourlistenId = pourlistenId;
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
