package com.yufei.dao;

import java.util.List;

import com.yufei.pojo.User;
import com.yufei.pojo.User_Role;

public interface UserDao {
	User login(User u);
	List<User> findAll(User u);
	Integer findCount(User u);
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
