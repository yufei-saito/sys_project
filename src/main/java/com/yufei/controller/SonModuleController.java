package com.yufei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yufei.pojo.Page;
import com.yufei.pojo.SonModule;
import com.yufei.service.SonModuleService;

@Controller
public class SonModuleController {
	@Autowired
	private SonModuleService ss;
	
	//查看子模块
	@RequestMapping("/SonModuleList.action")
	public String moduleSonList(Page p,Integer mid,Model m) {
		Page<SonModule> page =ss.findSonModule(p,mid);
		m.addAttribute("page", page);
		m.addAttribute("ModuleId", mid);
		return "sonList";
	}
	
	//添加子模块的跳转方法
	@RequestMapping("/SonModuleAddUI.action")
	public String moduleSonAddUI(Integer mid,Model m) {
		m.addAttribute("ModuleId", mid);
		return "sonAdd";
	}
		
	//添加子模块
	@RequestMapping("/SonModuleAdd.action")
	public String moduleSonAdd(SonModule sm) {
		ss.addSonModule(sm);
		return "redirect:/SonModuleList.action?mid="+sm.getModule().getMid();
	}
	
	//根据SID查询单个子模块
	@RequestMapping("/SonModuleEdit.action")
	public String sonModuleEdit(Integer sid,Model m) {
		SonModule sm =ss.findBySid(sid);
		m.addAttribute("editSonModule", sm);
		return "sonEdit";
	}
	
	//更新子模块
	@RequestMapping("/SonModuleUpdate.action")
	public String sonModuleUpdate(SonModule sm) {
		ss.updateSonModule(sm);
		return "redirect:/SonModuleList.action?mid="+sm.getModule().getMid();
	}
		
}	
