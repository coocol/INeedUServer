package com.eethan.ineedu.databasebeans;

public class MoodComment {

	public int id;
	public int moodId;
	public int userId;
	public int commentedUserId;
	public String time;
	public String content;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMoodId() {
		return moodId;
	}
	public void setMoodId(int moodId) {
		this.moodId = moodId;
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
	public MoodComment(int moodId,int userId,int commentedUserId,String time,String content)
	{
		this.moodId =moodId;
		this.setUserId(userId);
		this.setCommentedUserId(commentedUserId);
		this.setTime(time);
		this.setContent(content);
	}
	public MoodComment(){}
}
