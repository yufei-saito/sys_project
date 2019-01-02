package com.yufei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yufei.dao.ModuleDao;
import com.yufei.pojo.Module;
import com.yufei.service.ModuleService;


@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleDao dao;
	
	@Override
	public List<Module> findByGid(Integer rid) {
		
		return dao.findByGid(rid);
	}

}
