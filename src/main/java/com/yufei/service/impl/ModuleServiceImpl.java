package com.yufei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yufei.dao.ModuleDao;
import com.yufei.pojo.Module;
import com.yufei.pojo.Page;
import com.yufei.pojo.SonModule;
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

	@Override
	public Page<Module> findAllByModule(Page p, Module m) {
		Integer maxCount = dao.findCount(m);
		PageHelper.startPage(p.getPageNum(), p.getEveryCount());
		List<Module> list = dao.findAllByModule(m);
		p.setMaxCount(maxCount);
		p.setList(list);
		p.setMaxPage((int)Math.ceil(maxCount*1.0/p.getEveryCount()));
		return p;
	}

	@Override
	public void addModule(Module m) {
		dao.addModule(m); 	
	}

	@Override
	public Module findByMid(Integer mid) {
		return dao.findByMid(mid);
	}

	@Override
	public void updateModule(Module m) {
		dao.updateModule(m);
	}

	@Override
	public void deleteModule(Integer mid) {
		dao.deleteSonModule(mid);
		dao.deleteModule(mid);
		
	}

	@Override
	public List<Module> findAll() {
		return dao.findAll();
	}

}
