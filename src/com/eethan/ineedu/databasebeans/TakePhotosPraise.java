package com.eethan.ineedu.databasebeans;

public class TakePhotosPraise {
	public int id;
	public int photoId;
	public int userId;
	public int praisedUserId;
	
	public TakePhotosPraise(int photoId,int userId,int praisedUserId)
	{
		this.photoId = photoId;
		this.userId = userId;
		this.praisedUserId = praisedUserId;
	}
	public TakePhotosPraise(){}
	
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
	public int getPraisedUserId() {
		return praisedUserId;
	}
	public void setPraisedUserId(int praisedUserId) {
		this.praisedUserId = praisedUserId;
	}
}
