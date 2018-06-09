package com.novellius.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.novellius.domain.Admin;
import com.novellius.repo.AdminRepo;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1/")
public class AdminRestController {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@RequestMapping("/")
	public String getAdminList() {
		return adminRepo.findAll().toString();
	}
	
	@RequestMapping(value = "/admins", method = RequestMethod.GET)
	public ResponseEntity<Collection<Admin>> getAllAdmins() {
		
		List<Admin> admins = (List<Admin>) adminRepo.findAll();
		
		if (admins == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if (admins.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
			
		return new ResponseEntity<Collection<Admin>>(admins, HttpStatus.OK);
		
	}
	
	

}
