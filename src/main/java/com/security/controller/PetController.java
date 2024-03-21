package com.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.security.entity.Pet;
import com.security.service.IPetService;

@Controller
@RequestMapping("/views/pet/")
public class PetController {
	
	@Autowired
	private IPetService petService;

	@GetMapping("/create")
	public String create(Model model) {
		Pet pet = new Pet();
		
		model.addAttribute("title", "Registro de Mascota");
		model.addAttribute("pet", pet);
		
		return"/views/pet/create";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Pet pet, BindingResult result, Model model,
			RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			model.addAttribute("pet", pet);
			return"/views/pet/create";
		}
		petService.save(pet);
		
		return "redirect:/";
	}
	
}
