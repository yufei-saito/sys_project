package com.yufei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yufei.dao.SonModuleDao;
import com.yufei.pojo.Page;
import com.yufei.pojo.SonModule;
import com.yufei.service.SonModuleService;


@Service
@Transactional
public class SonModuleServiceImpl implements SonModuleService {
	
	@Autowired
	private SonModuleDao dao;
	
	@Override
	public List<SonModule> findByMid(Integer mid) {
		return dao.findByMid(mid);
	}

	@Override
	public Page<SonModule> findSonModule(Page p, Integer mid) {
		Integer maxCount = dao.findCount(mid);
		p.setMaxCount(maxCount);
		PageHelper.startPage(p.getPageNum(), p.getEveryCount());
		List<SonModule> list = dao.findByMidDesc(mid);
		p.setList(list);
		p.setMaxPage((int)Math.ceil(maxCount*1.0/p.getEveryCount()));
		return p;
	}

	@Override
	public void addSonModule(SonModule sm) {
		dao.addSonModule(sm);
	}

	@Override
	public SonModule findBySid(Integer sid) {
		return dao.findBySid(sid);
	}

	@Override
	public void updateSonModule(SonModule sm) {
		dao.updateSonModule(sm);
	}

	@Override
	public List<SonModule> findByMidDesc(Integer mid) {
		return dao.findByMidDesc(mid);
	}
	
	
}
