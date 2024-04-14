package com.security.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.security.entity.Pet;
import com.security.entity.User;
import com.security.service.IPetService;
import com.security.service.IUserService;

@Controller
@RequestMapping("/views/user")
public class UserListController {
	
	
	@Autowired
	private IUserService userService;
	
	
	@Autowired
	private IPetService petService;
	
	@GetMapping("/userList")
	public String userList(Model model) {
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		System.out.println(userList); 
		System.out.println(petService.toString());
		return "/views/user/userList";
		
	}
	
//AQUI HAY UN PROBLEMA ENTRE LA LAISTA DE USUARIOS Y DE MASCOTAS.......................................	
//	@GetMapping("/showPet/{id}")
//	public String showPet(@PathVariable ("id")   Long id, Model model) {
//		
//		Optional<Pet> pet = petService.findById(id);
//		model.addAttribute("pet", pet.get());
//	
//		System.out.println(pet.get());
//		//System.out.println(pet.get());
//		return "/views/user/showPet";
//		
//	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@GetMapping("/showPet/{id}")
//	public String showPet(@PathVariable("id") Long id, Model model) {
//	    Optional<Pet> optionalPet = petService.findById(id);
//	    if (optionalPet.isPresent()) {
//	        Pet pet = optionalPet.get();
//	        model.addAttribute("pet", pet);
//	        return "/views/pet/showPet";
//	    } else {
//	        // Manejar el caso en que la mascota no se encuentre
//	        return "error"; // Por ejemplo, redirigir a una página de error
//	    }
//	}

	

	


}
