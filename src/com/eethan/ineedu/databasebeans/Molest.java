package com.eethan.ineedu.databasebeans;

public class Molest {
	public int mid;
	public int userId;
	public int commentedUserId;
	public String content;
	public String time;
	public Molest() {
		// TODO Auto-generated constructor stub
	}
	public Molest(int userId,int commentedUserId,String content,String time) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.commentedUserId = commentedUserId;
		this.content = content;
		this.time = time;
	}
}
