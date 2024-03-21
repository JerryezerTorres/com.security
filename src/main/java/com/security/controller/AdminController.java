package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/admin")
public class AdminController {
	
	@GetMapping("/admin")
	public String admin() {
		
		return"/views/admin/admin";
		
	}

}
