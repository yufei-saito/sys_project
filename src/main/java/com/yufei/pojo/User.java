package com.yufei.pojo;

import java.io.Serializable;
import java.util.List;

public class User  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer uid;
	private String uname;
	private String upassword;
	private String nickname;
	private String phone;
	private String email;
	private Integer ustatus;
	private String utext;
	private Group group;
	private List<Role> roles;
	
	
	


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUpassword() {
		return upassword;
	}


	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getUstatus() {
		return ustatus;
	}


	public void setUstatus(Integer ustatus) {
		this.ustatus = ustatus;
	}


	public String getUtext() {
		return utext;
	}


	public void setUtext(String utext) {
		this.utext = utext;
	}


	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", nickname=" + nickname
				+ ", phone=" + phone + ", email=" + email + ", ustatus=" + ustatus + ", utext=" + utext + "]";
	}
	
	

}
