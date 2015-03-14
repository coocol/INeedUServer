package com.eethan.ineedu.databasebeans;

public class College {

	public int coid;
	public String name;
	public int provinceID;
	
	public College(){}
	public int getCoid() {
		return coid;
	}
	public void setCoid(int coid) {
		this.coid = coid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public College(int coid, String name, int provinceID) {
		super();
		this.coid = coid;
		this.name = name;
		this.provinceID = provinceID;
	}
	public int getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}
}
