package com.yufei.service;

import java.util.List;

import com.yufei.pojo.User;

public interface UserService {
	User login(User u);

	List<User> findAll(User u);
}
