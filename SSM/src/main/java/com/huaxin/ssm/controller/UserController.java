package com.huaxin.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.huaxin.ssm.bean.User;
import com.huaxin.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	//跳转页面
	@RequestMapping("/toList")
	public String toList(){
		return "index";
	}

	@RequestMapping("/queryAll")
	@ResponseBody
	public String queryAll(Model model){
		//1、查询条件
		//2、调用service
		List<User> list=userService.getAll(null);
		model.addAttribute("list", list);
		//3、返回json 格式的数据
		String json=JSONArray.toJSONString(list);
		return json;
	}
	
	//添加数据
		@RequestMapping("/usersave")
		@ResponseBody
		public String save(User user){
			int k=userService.add(user);
			return String.valueOf(k);
		}

	//删除
	
}
