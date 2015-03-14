package com.eethan.ineedu.databasebeans;

public class Province {

	public int pid;
	public int provinceID;
	public String pname;
	
	public Province(int pid, int provinceID, String pname) {
		super();
		this.pid = pid;
		this.provinceID = provinceID;
		this.pname = pname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Province(){}
	
	
}
