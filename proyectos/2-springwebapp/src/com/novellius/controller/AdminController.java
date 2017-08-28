package com.novellius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novellius.pojo.Admin;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "admin";
	}
	
}
