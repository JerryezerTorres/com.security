package com.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.security.entity.User;
import com.security.service.IUserService;

@Controller
@RequestMapping("/views/user")
public class LoginController {

	@Autowired
	private IUserService userService;
	
//	BCryptPasswordEncoder passEncode = new BCryptPasswordEncoder();

	@Autowired(required = true)
	private AuthenticationManager authenticationManager;

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("user", new User());

		return "/views/user/login";

	}

	@PostMapping("/login")
	public String processLogin(User user) {
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
		Authentication authenticated = authenticationManager.authenticate(authentication);
	
		SecurityContextHolder.getContext().setAuthentication(authenticated);		
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		System.out.println("Esta autenticado: " + authenticated.isAuthenticated());
		System.out.println("Esta autenticado: " + user.toString());

		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	
		// Invalidar la sesión y limpiar la cookie de autenticación
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		
		}
		
		return "redirect:/"; // Redirige a la página de login con un mensaje de logout exitoso
	}
}
