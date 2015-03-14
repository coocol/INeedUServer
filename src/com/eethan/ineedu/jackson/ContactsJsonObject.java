package com.eethan.ineedu.jackson;

import java.util.List;

import com.eethan.ineedu.databasebeans.Contact;
import com.eethan.ineedu.databasebeans.UserInfo;

public class ContactsJsonObject {
	private List<Contact> generalContacts;
	private List<UserInfo> generalUserInfos;
	
	private List<Contact> recentContacts;
	private List<UserInfo> recentUserInfos;
	
	public ContactsJsonObject(List<Contact> generalContacts, List<UserInfo> generalUserInfos,
			List<Contact> recentContacts,List<UserInfo> recentUserInfos) {
		// TODO Auto-generated constructor stub
		this.setGeneralContacts(generalContacts);
		this.setGeneralUserInfos(generalUserInfos);
		this.setRecentContacts(recentContacts);
		this.setRecentUserInfos(recentUserInfos);
	}
	public ContactsJsonObject() {
		// TODO Auto-generated constructor stub
	}
	public List<Contact> getGeneralContacts() {
		return generalContacts;
	}
	public void setGeneralContacts(List<Contact> generalContacts) {
		this.generalContacts = generalContacts;
	}
	public List<UserInfo> getGeneralUserInfos() {
		return generalUserInfos;
	}
	public void setGeneralUserInfos(List<UserInfo> generalUserInfos) {
		this.generalUserInfos = generalUserInfos;
	}
	public List<Contact> getRecentContacts() {
		return recentContacts;
	}
	public void setRecentContacts(List<Contact> recentContacts) {
		this.recentContacts = recentContacts;
	}
	public List<UserInfo> getRecentUserInfos() {
		return recentUserInfos;
	}
	public void setRecentUserInfos(List<UserInfo> recentUserInfos) {
		this.recentUserInfos = recentUserInfos;
	}
}
