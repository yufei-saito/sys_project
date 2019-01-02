package com.yufei.pojo;

import java.io.Serializable;
import java.util.List;

public class Module  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer mid;
	private String mname;
	private String mtext;
	private List<SonModule> sonModules;
	private List<Role> roles;
	
	
	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtext() {
		return mtext;
	}

	public void setMtext(String mtext) {
		this.mtext = mtext;
	}
	

	public List<SonModule> getSonModules() {
		return sonModules;
	}

	public void setSonModules(List<SonModule> sonModules) {
		this.sonModules = sonModules;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	

	

	@Override
	public String toString() {
		return "Module [mid=" + mid + ", mname=" + mname + ", mtext=" + mtext + "]";
	}
	
	
	
}
