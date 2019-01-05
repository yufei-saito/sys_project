package com.yufei.service;

import java.util.List;

import com.yufei.pojo.Module;
import com.yufei.pojo.Page;
import com.yufei.pojo.Role;
import com.yufei.pojo.RoleVo;

public interface RoleService {
	List<Role> findAll();

	Page<Role> findAllByRole(Page p, Role r);

	void addRole(Role r);

	Role findByRid(Integer rid);

	void updateRole(Role r);

	void deleteRole(Integer rid);

	List<Integer> findRole_Module(Integer rid);

	void updateRoleModule(Integer rid, Integer[] mids);

}
