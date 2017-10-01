package com.novellius.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novellius.pojo.Usuario;
import com.novellius.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/usuario")
	public String showForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", usuarioService.findAll());
		return "usuario";
	}
	
	@RequestMapping(value = "/usuario/save", method = RequestMethod.POST)
	public String registrar(@ModelAttribute("usuario") @Valid Usuario usuario, 
			BindingResult result, Model model, RedirectAttributes ra) {
		
		if (result.hasErrors()) {
			return "usuario"; 
		}
		
		usuarioService.save(usuario);
		ra.addFlashAttribute("resultado", "Cambios realizados con éxito");
		
		return "redirect:/usuario";
	}
	
}
 