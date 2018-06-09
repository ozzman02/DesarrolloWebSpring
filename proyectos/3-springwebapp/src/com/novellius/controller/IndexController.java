package com.novellius.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/*
 * Para poner una lista de atributos en la Session :
 * @SessionAttributes({"resultado", "mensaje"})
 */
@Controller
//@SessionAttributes("resultado")
public class IndexController {

	@RequestMapping("/")
	public String showIndex(Model model) {
		//model.addAttribute("resultado", "Resultado desde Session");
		return "index";
	}
	
	/*
	 * SessionStatus se usa para limpiar un attributo que se haya puesto en la Session.
	 * Se debe usar el metodo setComplete()
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus) throws Exception {
		if (true) {
			throw new Exception();
		}
		sessionStatus.setComplete();
		return "about";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/";
	}
	
}
