package com.yufei.dao;

import java.util.List;

import com.yufei.pojo.User;

public interface UserDao {
	User login(User u);
	List<User> findAll(User u);
}
