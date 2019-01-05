package com.yufei.dao;

import java.util.List;

import com.yufei.pojo.Role;
import com.yufei.pojo.RoleVo;
import com.yufei.pojo.User;

public interface RoleDao {
	List<Role> findAll();
	List<Role> findAllByRole(Role r);
	Integer findCount(Role r);
	void addRole(Role r);
	Role findByRid(Integer rid);
	void updateRole(Role r);
	void deleteRole_Module(Integer rid);
	void deleteRole(Integer rid);
	List<Integer> findRole_Module(Integer rid);
	void addRole_Module(RoleVo rv);

}
