package com.yufei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yufei.dao.UserDao;
import com.yufei.pojo.User;
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
	public List<User> findAll(User u) {
		return dao.findAll(u);
		
	}

}
