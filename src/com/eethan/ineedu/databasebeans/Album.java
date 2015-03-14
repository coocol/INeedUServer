package com.eethan.ineedu.databasebeans;

public class Album {

	public Album(){}
	
	public Album(int id,int userId,String photoUrl){
		this.id = id;
		this.userId = userId;
		this.photoUrl = photoUrl;
	}
	
	public int id;
	public int userId;
	public String photoUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
