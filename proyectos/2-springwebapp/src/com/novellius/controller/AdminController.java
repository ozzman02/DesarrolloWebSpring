package com.novellius.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Admin;
import com.novellius.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado) {
		
		List<Admin> admins = adminService.findAll();	
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		model.addAttribute("resultado", resultado);
		model.addAttribute("admins", admins);
		
		return "admin";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, Model model, RedirectAttributes ra) {
		
		if (adminService.saveOrUpdate(adminForm)) {
			/*
			 *	El atributo persiste a la hora de redireccionar 
			 */
			ra.addFlashAttribute("resultado", "Cambios realizados con �xito !!!");
		} else {
			ra.addFlashAttribute("resultado", "Error al realizar los cambios");
		}
		
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/{idAd}/update")
	public String showUpdate(Model model, @PathVariable("idAd") int id) {
		Admin admin = adminService.findById(id);
		model.addAttribute("admin", admin);
		return "admin";
	}
	
	@RequestMapping("/admin/{idAd}/delete")
	public String delete(@PathVariable("idAd") int idAd, RedirectAttributes ra) {
		if (adminService.delete(idAd)) {
			ra.addFlashAttribute("resultado", "Cambios realizados con �xito !!!");
		} else {
			ra.addFlashAttribute("resultado", "Error al realizar los cambios");
		}
		return "redirect:/admin";
	}
	
}
