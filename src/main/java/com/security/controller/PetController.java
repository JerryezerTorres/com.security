package com.security.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.security.entity.Pet;
import com.security.entity.User;
import com.security.service.IPetService;
import com.security.service.IUserService;

@Controller
@RequestMapping("/views/pet/")
public class PetController {
	
	@Autowired
	private IPetService petService;
	
	@Autowired
	private IUserService userService;

	@GetMapping("/create")
	public String create(Model model) {
		Pet pet = new Pet();
		
		model.addAttribute("title", "Registro de Mascota");
		model.addAttribute("pet", pet);
		
		return"/views/pet/create";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Pet pet, BindingResult result, Model model, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			model.addAttribute("pet", pet);
			
			return"/views/pet/create";
		}
		petService.save(pet);
		
		return "redirect:/";
	}
	
	@GetMapping("/showPet/{id}")
	public String showPet(@PathVariable("id") Long id, Model model) {
	    Optional<User> userList = userService.findById(id);
//	    Optional<Pet> pet = petService.findById(id);
	   
	    if (userList.isPresent()) {
	    	
	        List<Pet> petList = petService.findActivePetsByUser(userList.get());
	        model.addAttribute("pet", petList);
	        model.addAttribute("user", userList);	        
	        System.out.println(userService.findById(id));
	        System.out.println(petService.findById(id));
	        return "/views/pet/showPet";
	    }else {
	    	return "/"; 
	    }
		
	}
}
