package com.yufei.pojo;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer gid;
	private String gname;
	private List<User> users;
	
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Group [gid=" + gid + ", gname=" + gname + "]";
	}
	
	

}
