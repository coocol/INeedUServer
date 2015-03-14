package com.eethan.ineedu.databasebeans;

public class WishFlower {
	public int id;
	public int wishId;
	public int userId;
	public int praisedUserId;
	
	public WishFlower(int wishId,int userId,int praisedUserId)
	{
		this.wishId = wishId;
		this.userId = userId;
		this.praisedUserId = praisedUserId;
	}
	public WishFlower() {
		// TODO Auto-generated constructor stub
	}

	
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
	public int getPraisedUserId() {
		return praisedUserId;
	}
	public void setPraisedUserId(int praisedUserId) {
		this.praisedUserId = praisedUserId;
	}
}
