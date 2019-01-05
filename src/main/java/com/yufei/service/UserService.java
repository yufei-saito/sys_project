package com.yufei.service;


import com.yufei.pojo.Page;
import com.yufei.pojo.User;
import com.yufei.pojo.User_Role;

public interface UserService {
	User login(User u);

	Page<User> findAll(Page p ,User u);

	User findByUid(Integer uid);
	
	void updateUser(User u);

	void deleteUser_Role(Integer uid);

	void addUser_Role(User_Role ur);

	void offUser(Integer uid);
	
	void onUser(Integer uid);

	void deleteUser(Integer uid);

	Integer addUser(User user);

	void updatePwd(User myuser);

	
}
