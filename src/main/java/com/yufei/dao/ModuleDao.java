package com.yufei.dao;

import java.util.List;

import com.yufei.pojo.Module;

public interface ModuleDao {
	
	List<Module> findByGid(Integer rid); 
}
