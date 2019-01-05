package com.yufei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yufei.pojo.Module;
import com.yufei.pojo.Page;
import com.yufei.pojo.SonModule;
import com.yufei.service.ModuleService;

@Controller
public class ModuleController {
	
	@Autowired
	private ModuleService ms;
	
	//Ajax请求查询模块列表
	@RequestMapping("/ModuleListAjax.action")
	public @ResponseBody List<Module> moduleListAjax(){
		
		return ms.findAll();
	}
	
	//查询模块列表
	@RequestMapping("/ModuleList.action")
	public String moduleList(Module m ,Page p,Model model) {
		Page<Module> page = ms.findAllByModule(p,m);
		model.addAttribute("page", page);
		model.addAttribute("m_cond", m);
		return "moduleList";
	}
	
	//添加模块
	@RequestMapping("/ModuleAdd.action")
	public String moduleAdd(Module m) {
		ms.addModule(m);
		return "redirect:/ModuleList.action";
	}
	
	//根据MID查询单个模块
	@RequestMapping("/ModuleEdit.action")
	public String moduleEdit(Integer mid,Model model) {
		Module m =ms.findByMid(mid);
		model.addAttribute("editModule", m);
		return "moduleEdit";
	}
	
	//更新模块
	@RequestMapping("/ModuleUpdate.action")
	public String moduleUpdate(Module m) {
		ms.updateModule(m);
		return "redirect:/ModuleList.action";
	}
	
	//删除模块
	@RequestMapping("/ModuleDelete.action")
	public String moduleDelete(Integer mid) {
		ms.deleteModule(mid);
		return "redirect:/ModuleList.action";
	}
	
	
}
