package com.yufei.pojo;

import java.io.Serializable;
import java.util.List;

public class Page<E> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pageNum;
	private Integer everyCount;
	private Integer maxPage;
	private Integer maxCount;
	private List<E> list;
	public Page() {
		super();
		pageNum =1;
		everyCount = 10;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getEveryCount() {
		return everyCount;
	}
	public void setEveryCount(Integer everyCount) {
		this.everyCount = everyCount;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	public Integer getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	
	
	
	

}
