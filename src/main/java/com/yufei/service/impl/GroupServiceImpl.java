package com.yufei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yufei.dao.GroupDao;
import com.yufei.pojo.Group;
import com.yufei.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupDao dao;
	
	@Override
	public List<Group> findAll() {
		return dao.findAll();
	}

}
