package com.yufei.service;

import java.util.List;

import com.yufei.pojo.Page;
import com.yufei.pojo.SonModule;

public interface SonModuleService {
	List<SonModule> findByGid(Integer mid);

	Page<SonModule> findSonModule(Page p, Integer mid);

	void addSonModule(SonModule sm);

	SonModule findBySid(Integer sid);

	void updateSonModule(SonModule sm); 
}	
