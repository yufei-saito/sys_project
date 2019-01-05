package com.yufei.service.impl;

import java.util.List;

import org.apache.log4j.DailyRollingFileAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yufei.dao.RoleDao;
import com.yufei.pojo.Page;
import com.yufei.pojo.Role;
import com.yufei.pojo.RoleVo;
import com.yufei.pojo.User;
import com.yufei.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao dao;

	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<Role> findAllByRole(Page p, Role r) {
		Integer maxCount = dao.findCount(r);
		PageHelper.startPage(p.getPageNum(), p.getEveryCount());
		List<Role> list = dao.findAllByRole(r);
		p.setMaxCount(maxCount);
		p.setList(list);
		p.setMaxPage((int)Math.ceil(maxCount*1.0/p.getEveryCount()));
		return p;
	}

	@Override
	public void addRole(Role r) {
		dao.addRole(r);
		
	}

	@Override
	public Role findByRid(Integer rid) {
		return dao.findByRid(rid);
	}

	@Override
	public void updateRole(Role r) {
		dao.updateRole(r);
	}

	@Override
	public void deleteRole(Integer rid) {
		dao.deleteRole_Module(rid);
		dao.deleteRole(rid);
		
	}

	@Override
	public List<Integer> findRole_Module(Integer rid) {
		return dao.findRole_Module(rid);
	}

	@Override
	public void updateRoleModule(Integer rid, Integer[] mids) {
		dao.deleteRole_Module(rid);
		for (Integer mid : mids) {
			RoleVo rv = new RoleVo(rid, mid);
			dao.addRole_Module(rv);
		}
		
	}


	
	
	
}
