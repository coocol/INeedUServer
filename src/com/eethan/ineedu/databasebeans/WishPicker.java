package com.eethan.ineedu.databasebeans;

public class WishPicker {
	
	public WishPicker(){}
	
	public WishPicker(int id,int wid,int uid,int oid){
		this.id = id; 
		this.userId=uid;
		this.ownerId = oid;
		this.wishId = wid;
	}

	public int id;
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
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int wishId;
	public int ownerId;
	public int userId;
}
