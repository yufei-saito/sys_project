package com.yufei.pojo;

public class RoleVo {
	
	private Integer rid;
	private Integer mid;
	public RoleVo(Integer rid, Integer mid) {
		super();
		this.rid = rid;
		this.mid = mid;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "RoleVo [rid=" + rid + ", mid=" + mid + "]";
	}
	
	
}
