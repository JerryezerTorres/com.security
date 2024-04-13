package com.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.security.entity.User;
import com.security.service.IUserService;

@Controller
@RequestMapping("/views/user")
public class LoginController {

//	@Autowired
//	private IUserService userService;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired(required = true)
	private AuthenticationManager authenticationManager;

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("title", "Login");

		return "/views/user/login";

	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
	    Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);

	    try {
	        Authentication authenticated = authenticationManager.authenticate(authentication);

	        SecurityContextHolder.getContext().setAuthentication(authenticated);

	        return "redirect:/";
	    } catch (AuthenticationException e) {
	        redirectAttributes.addFlashAttribute("error", "Nombre de usuario o contraseña incorrectos");
	        System.out.println("Estoy fuera del try");
	        return "redirect:/views/user/login";
	    }
	    
	}


	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		
		}
		
		return "redirect:/";
	}
}
