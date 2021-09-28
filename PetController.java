package br.edu.unirv.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.unirv.petshop.service.PetService;

@Controller
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping("/Pet")
	public String getAllPets(Model  model) {
		model.addAttribute("Pet",petService.findAll());
		return "Pet";
	}
}
