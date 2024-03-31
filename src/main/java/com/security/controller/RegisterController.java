package com.security.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.security.entity.User;
import com.security.service.IUserService;

@Controller
@RequestMapping("/views/user")
public class RegisterController {

	@Autowired
	private IUserService userService;

	@GetMapping("/create")
	public String create(Model model) {
		User user = new User();
		model.addAttribute("title", "Registrarse");
		model.addAttribute("user", user);

		return "/views/user/create";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute User user, BindingResult result, Model model,
			RedirectAttributes attribute) {
		// , @RequestParam("file") MultipartFile imagen

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "/views/user/create";
		}
		userService.save(user);

		return "redirect:/";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, RedirectAttributes attribute, Model model) {
		Optional<User> user = null;
		if (id > 0) {
			user = userService.findById(id);
			if (user == null) {
				attribute.addFlashAttribute("error", "El id no exixte");
				System.out.println("Id no existe");
				return "redirect:/views/user/home";
			}
		} else {
			attribute.addFlashAttribute("error", "Problemas con el id");
			System.out.println("3" + user);
			return "redirect:/views/user/home";
		}
		model.addAttribute("user", user);
		System.out.println(user);
		return "/views/user/create";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attribute) {
		Optional<User> user = null;
		if (id > 0) {
			user = userService.findById(id);
			if (user == null) {
				System.out.println("null.");
				attribute.addFlashAttribute("error", "ATENCION: El id de la persona no existe.");
				return "redirect:/views/user/userList";
			}
		} else {
			System.out.println("ERROR: Error con id de la persona.");
			attribute.addFlashAttribute("error", "ATENCION: Error con el id de la persona.");
			return "redirect:/views/persona/";
		}
		userService.delete(id);
		System.out.println("Prueba " + id + " borrado exitosamente.");
		attribute.addFlashAttribute("warning", "Registro eliminado exitosamente.");

		return "redirect:/views/user/userList";

	}

}
