package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/service")
public class ServiceControler {
	
	@GetMapping("/bookAppointment")
	public String bookAppointment() {
		return"/views/service/bookAppointment";
	}
	
	@GetMapping("/completePackage")
	public String completePackage() {
		return"/views/service/completePackage";
		
	}
	
	@GetMapping("/teethCleaning")
	public String teethCleanig() {
		
		return"/views/service/teethCleaning";
		
	}
	
	@GetMapping("/bathAndBrush")
	public String bathAndBrush() {
		
		return"/views/service/bathAndBrush";
		
	}
	
	
	@GetMapping("/aboutUs")
	public String aboutUs() {
		return"/views/service/aboutUs";
	}

}
