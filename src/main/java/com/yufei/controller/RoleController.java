package com.yufei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.RdbmsOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yufei.pojo.Module;
import com.yufei.pojo.Page;
import com.yufei.pojo.Role;
import com.yufei.pojo.RoleVo;
import com.yufei.service.ModuleService;
import com.yufei.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService rs;
	
	@Autowired
	private ModuleService ms;
	
	//Ajax请求获取角色列表
	@RequestMapping("/RoleListAjax.action")
	public @ResponseBody List<Role> roleListAjax(){
		
		return rs.findAll();
	};
	
	
	//查询角色列表
	@RequestMapping("/RoleList.action")
	public String roleList(Role r,Page p,Model m) {
		Page<Role> page = rs.findAllByRole(p,r);
		m.addAttribute("page", page);
		m.addAttribute("r_cond", r);
		return "roleList";
	}
	
	//添加角色
	@RequestMapping("/RoleAdd.action")
	public String roleAdd(Role r) {
		rs.addRole(r);
		return "redirect:/RoleList.action";
	}
	
	//根据RID查询单个角色
	@RequestMapping("/RoleEdit.action")
	public String roleEdit(Integer rid,Model m) {
		Role r =rs.findByRid(rid);
		m.addAttribute("editRole", r);
		return "roleEdit";
	}
	
	//更新角色
	@RequestMapping("/RoleUpdate.action")
	public String roleUpdate(Role r) {
		rs.updateRole(r);
		return "redirect:/RoleList.action";
	}
	
	//删除角色
	@RequestMapping("/RoleDelete.action")
	public String roleDelete(Integer rid) {
		rs.deleteRole(rid);
		return "redirect:/RoleList.action";
	}
	
	//根据RID获取权限
	@RequestMapping("/RoleModule.action")
	public String roleModule(Integer rid,Model m) {
		List<Integer> array =rs.findRole_Module(rid);
		List<Module> list = ms.findAll();
		m.addAttribute("array", array);
		m.addAttribute("list", list);
		m.addAttribute("rid", rid);
		m.addAttribute("size", list.size());
		return "roleModule";
	}
	
	//根据RID修改权限
	@RequestMapping("/RoleModuleUpdate.action")
	public String roleModuleUpdate(Integer rid, Integer[] mids ) {
		rs.updateRoleModule(rid,mids);

		return "redirect:/RoleList.action";
	}
	
}
