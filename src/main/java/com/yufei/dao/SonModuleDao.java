package com.yufei.dao;

import java.util.List;

import com.yufei.pojo.SonModule;

public interface SonModuleDao {
	List<SonModule> findByMid(Integer mid);
	
	Integer findCount(Integer mid);

	void addSonModule(SonModule sm);
	
	void updateSonModule(SonModule sm);
	
	SonModule findBySid(Integer sid);

	List<SonModule> findByMidDesc(Integer mid);
}
