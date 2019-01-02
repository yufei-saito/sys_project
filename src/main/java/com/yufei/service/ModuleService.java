package com.yufei.service;

import java.util.List;

import com.yufei.pojo.Module;

public interface ModuleService {
	List<Module> findByGid(Integer rid); 
}
