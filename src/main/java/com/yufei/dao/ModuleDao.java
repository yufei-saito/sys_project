package com.yufei.dao;

import java.util.List;

import com.yufei.pojo.Module;
import com.yufei.pojo.SonModule;

public interface ModuleDao {
	
	List<Module> findByGid(Integer rid);

	Integer findCount(Module m);

	List<Module> findAllByModule(Module m);

	void addModule(Module m); 
	
	Module findByMid(Integer mid);
	
	void updateModule(Module m);
	
	void deleteModule(Integer mid);
	
	void deleteSonModule(Integer mid);

	List<Module> findAll();
	
	void deleteRole_Module(Integer mid);

}
