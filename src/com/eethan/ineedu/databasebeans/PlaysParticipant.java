package com.eethan.ineedu.databasebeans;

public class PlaysParticipant {
	public int id;
	public int playsId;
	public int userId;
	public int ownerId;
	
	public PlaysParticipant(int playsId,int userId,int ownerId) {
		// TODO Auto-generated constructor stub
		this.playsId = playsId;
		this.userId = userId;
		this.ownerId = ownerId;
	}
	public PlaysParticipant() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlaysId() {
		return playsId;
	}
	public void setPlaysId(int playsId) {
		this.playsId = playsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOwner() {
		return ownerId;
	}
	public void setOwner(int owner) {
		this.ownerId = owner;
	}
	
	
}
