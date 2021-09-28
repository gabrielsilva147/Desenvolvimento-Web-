package br.edu.unirv.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebApplicationController {
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/index")
		public String index() {
			return"index";
		}
		
	}


