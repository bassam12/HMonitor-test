package com.prav.android.mhealth;

public class Patient {
	private String id,pname,pbgroup;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPbgroup() {
		return pbgroup;
	}

	public void setPbgroup(String pbgroup) {
		this.pbgroup = pbgroup;
	}
	@Override
	public String toString() {
		return  id+ " - " +pname + " - " + pbgroup;
	}
}
