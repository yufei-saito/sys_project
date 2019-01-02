package com.yufei.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.yufei.pojo.Module;
import com.yufei.pojo.Page;
import com.yufei.pojo.Role;
import com.yufei.pojo.SonModule;
import com.yufei.pojo.User;
import com.yufei.service.ModuleService;
import com.yufei.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private ModuleService ms;
	
	@RequestMapping("/UserLogin.action")
	public String login(User u,HttpServletRequest request) {
		User user = us.login(u);
		if(null==user) {
			request.setAttribute("msg", "你输入的用户名或密码有误");
			return "index";
		}
		request.getSession().setAttribute("user", user);
		
		List<Role> roles = user.getRoles();
		List<Module> modules = new ArrayList<Module>();
		
		for (Role role : roles) {
			List<Module> mlist = ms.findByGid(role.getRid());
			modules.addAll(mlist);
		}
		
		
		request.getSession().setAttribute("modules", modules);
		
		return "redirect:main.jsp";
	}
	
	@RequestMapping("/UserList.action")
	public String list(User u,Page p,Model m) {
		if(p==null) {
			p = new Page<>();
		}
		PageHelper.startPage(p.getPageNum(), p.getEveryCount());
		List<User> list = us.findAll(u);
		m.addAttribute("list", list);
		return "userlist";
	}
}
