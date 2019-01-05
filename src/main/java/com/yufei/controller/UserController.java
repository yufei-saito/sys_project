package com.yufei.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yufei.pojo.Module;
import com.yufei.pojo.Page;
import com.yufei.pojo.Role;
import com.yufei.pojo.SonModule;
import com.yufei.pojo.User;
import com.yufei.pojo.UserVo;
import com.yufei.pojo.User_Role;
import com.yufei.service.ModuleService;
import com.yufei.service.SonModuleService;
import com.yufei.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private ModuleService ms;
	
	@Autowired
	private SonModuleService sms;
	
	
	
	
	//登录方法
	@RequestMapping("/UserLogin.action")
	public String userLogin(User u,HttpServletRequest request) {
		User user = us.login(u);
		if(null==user) {
			request.setAttribute("msg", "你输入的用户名或密码有误");
			return "index";
		}
		if(user!=null && user.getUstatus()==0) {
			request.setAttribute("msg", "你的用户已被禁用");
			return "index";
		}
		request.getSession().setAttribute("MyUser", user);
		
		List<Role> roles = user.getRoles();
		List<Module> modules = new ArrayList<Module>();
		
		for (Role role : roles) {
			List<Module> mlist = ms.findByGid(role.getRid());
			for (Module module : mlist) {
				List<SonModule> slist = sms.findByGid(module.getMid());
				module.setSonModules(slist);
			}
			modules.addAll(mlist);
		}
		
		
		request.getSession().setAttribute("modules", modules);
		
		return "redirect:main.jsp";
	}
	
	//登出方法
	@RequestMapping("/UserExit.action")
	public String userExit(HttpServletRequest request) {
		request.getSession().removeAttribute("MyUser");
		return "redirect:index.jsp";
	}
	
	//查询用户列表
	@RequestMapping("/UserList.action")
	public String userList(User u,Page p,Model m) {
		Page<User> page = us.findAll(p,u);
		m.addAttribute("page", page);
		m.addAttribute("u_cond", u);
		return "userList";
	}
	
	
	//根据UID查询单个用户
	@RequestMapping("/UserEdit.action")
	public String userEdit(Integer uid,Model m) {
		User user = us.findByUid(uid);
		m.addAttribute("editUser", user);
		return "userEdit";
	}
	
	//更新用户
	@RequestMapping("/UserUpdate.action")
	public String userUpdate(UserVo vo) {
		User user = vo.getUser();
		Integer[] roles = vo.getRoles();
		us.updateUser(user);
		us.deleteUser_Role(user.getUid());
		for (Integer integer : roles) {
			User_Role ur = new User_Role(user.getUid(),integer);
			us.addUser_Role(ur);
		}
		
		return "redirect:/UserList.action";
	}
	
	//禁用用户
	@RequestMapping("/UserOff.action")
	public String userOff(Integer uid) {
		us.offUser(uid);
		
		return "redirect:/UserList.action";
	}
	
	//启用用户
	@RequestMapping("/UserOn.action")
	public String userOn(Integer uid) {
		us.onUser(uid);
		
		return "redirect:/UserList.action";
	}
	
	//删除用户
	@RequestMapping("/UserDelete.action")
	public String userDelete(Integer uid) {
		us.deleteUser(uid);
				
		return "redirect:/UserList.action";
	}
	
	//添加用户
	@RequestMapping("/UserAdd.action")
	public String userAdd(UserVo vo) {
		User user = vo.getUser();
		Integer[] roles = vo.getRoles();
		us.addUser(user);
		
		for (Integer integer : roles) {
			User_Role ur = new User_Role(user.getUid(),integer);
			us.addUser_Role(ur);
		}
		
		return "redirect:/UserList.action";
	}
	
	//ajax密码验证
	@RequestMapping("/PwdCheck.action")
	public String pwdCheck(String pwd,HttpServletRequest request,HttpServletResponse response) throws IOException {
		User myuser = (User)request.getSession().getAttribute("MyUser");
		String upassword = myuser.getUpassword();
		response.setContentType("text/html;charset=UTF-8");
		if(pwd.equals(upassword)) {
			response.getWriter().write("1");
		}else {
			response.getWriter().write("0");
		}
		return null;
	}
	
	//修改密码
	@RequestMapping("/UserPassword.action")
	public String userPassword(String np,Model m,HttpServletRequest request) {
		User myuser = (User)request.getSession().getAttribute("MyUser");
		myuser.setUpassword(np);
		us.updatePwd(myuser);
		request.getSession().setAttribute("MyUser", myuser);
		return "redirect:main.jsp";
		
	}
}
