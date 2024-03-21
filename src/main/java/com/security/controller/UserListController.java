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

import com.security.entity.User;
import com.security.service.IUserService;

@Controller
@RequestMapping("/views/user")
public class UserListController {
	
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/userList")
	public String userList(Model model) {
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		System.out.println(userList); 		
		return "/views/user/userList";
		
	}
	


}
