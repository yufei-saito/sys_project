package com.yufei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yufei.pojo.Group;
import com.yufei.service.GroupService;
@Controller
public class GroupController {
	
	@Autowired
	private GroupService gs;
	
	
	@RequestMapping("GroupListAjax.action")
	public @ResponseBody List<Group> groupList() {
		
		return gs.findAll();
	}
}
