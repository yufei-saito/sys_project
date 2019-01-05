package com.yufei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yufei.dao.UserDao;
import com.yufei.pojo.Page;
import com.yufei.pojo.User;
import com.yufei.pojo.User_Role;
import com.yufei.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	@Override
	public User login(User u) {
		return dao.login(u);
	}

	@Override
	public Page<User> findAll(Page p,User u) {
		Integer maxCount = dao.findCount(u);
		PageHelper.startPage(p.getPageNum(), p.getEveryCount());
		List<User> list = dao.findAll(u);
		p.setMaxCount(maxCount);
		p.setList(list);
		p.setMaxPage((int)Math.ceil(maxCount*1.0/p.getEveryCount()));
		return p;
		
	}

	@Override
	public User findByUid(Integer uid) {
		return dao.findByUid(uid);
	}

	@Override
	public void updateUser(User u) {
		dao.updateUser(u);
		
	}

	@Override
	public void deleteUser_Role(Integer uid) {
		dao.deleteUser_Role(uid);
		
	}

	@Override
	public void addUser_Role(User_Role ur) {
		dao.addUser_Role(ur);
		
	}

	@Override
	public void offUser(Integer uid) {
		dao.offUser(uid);
		
	}

	@Override
	public void onUser(Integer uid) {
		dao.onUser(uid);	
	}

	@Override
	public void deleteUser(Integer uid) {
		dao.deleteUser_Role(uid);
		dao.deleteUser(uid);
		
	}

	@Override
	public Integer addUser(User user) {
		return dao.addUser(user);
		
	}

	@Override
	public void updatePwd(User myuser) {
		dao.updatePwd(myuser);
	}

}
