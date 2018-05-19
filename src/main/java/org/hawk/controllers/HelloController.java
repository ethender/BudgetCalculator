package org.hawk.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	

	@RequestMapping("/showMessage.html")
	public String getMessage(Model model) {
		model.addAttribute("message", "Hello,world");
		return "showMessage";
	}
}
