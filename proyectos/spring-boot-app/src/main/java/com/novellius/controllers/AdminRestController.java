package com.novellius.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.novellius.repo.AdminRepo;

@org.springframework.web.bind.annotation.RestController
public class AdminRestController {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@RequestMapping("/")
	public String getAllAdmin() {
		return adminRepo.findAll().toString();
	}

}
