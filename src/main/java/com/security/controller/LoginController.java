package com.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.security.entity.User;
import com.security.service.IUserService;

@Controller
@RequestMapping("/views/user")
public class LoginController {
	
	
	
	@Autowired
	private IUserService userService;
	

	
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("user", new User());
	System.out.println("formulario login");
		return"/views/user/login";
		
	}
	
/*	   @PostMapping("/login")
	    public String processLogin() {
		  
	        return "redirect:/";
	    }*/
	
/*    @PostMapping("/login")
    public String processLogin(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {   	
        if (bindingResult.hasErrors()) {

        	System.out.println( "1 + " + user.getUserName());
            return "/views/user/login";
        }
    
        if (user.getUserName().equals("userName") && user.getPassword().equals("password")) {
        	System.out.println( "2 + " + user.getUserName());
            return "redirect:/"; 
        } else {
        	System.out.println("Error");
            return "redirect:/login?error"; 
        }
    }*/
    
    
	    @GetMapping("/logout")
	    public String logout() {
	        // Aquí puedes realizar la lógica de logout si es necesario
	    	System.out.println( "estoy fuera");
	        return "redirect:/login?logout"; // Redirige de vuelta al formulario de inicio de sesión con un mensaje de logout exitoso
	    }
    
/*    @GetMapping("/logout")
    public String logout() {
        // Aquí puedes realizar la lógica de logout si es necesario
        return "redirect:/login?logout"; // Redirige de vuelta al formulario de inicio de sesión con un mensaje de logout exitoso
    }*/
	
	
}
