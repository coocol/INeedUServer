package com.eethan.ineedu.databasebeans;

public class Contact {
	public int cid;
	public int userId;
	public int contactId;
	public int type;
	public String time;
	
	public Contact(int userId,int contactId,int type,String time) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		this.contactId = contactId;
		this.type = type;
		this.time = time;
	}
	public Contact(){}
	
}
