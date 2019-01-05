package com.yufei.service;

import java.util.List;

import com.yufei.pojo.Module;
import com.yufei.pojo.Page;
import com.yufei.pojo.SonModule;

public interface ModuleService {
	List<Module> findByGid(Integer rid);

	Page<Module> findAllByModule(Page p, Module m);

	void addModule(Module m);

	Module findByMid(Integer mid);

	void updateModule(Module m); 
	
	void deleteModule(Integer mid);

	List<Module> findAll();

}
