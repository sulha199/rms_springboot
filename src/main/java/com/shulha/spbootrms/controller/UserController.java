package com.shulha.spbootrms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shulha.spbootrms.model.User;
import com.shulha.spbootrms.model.UserRepository;
import com.shulha.spbootrms.model.validator.UserValidator;

@RequestMapping("/users")
@Controller
public class UserController {
	@Autowired
	private UserRepository userService;
	
	@Autowired
	private UserValidator userValidator;
	 
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();;

	@RequestMapping("")
	public String userList(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("page-title", "Create User");
		return "user/list";
	}

	@GetMapping("/create")
	public String showCreateFormregistrationForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("page-title", "Create User");
		return "user/createUsersForm";
	}
	
	@GetMapping("/update")
	public String showUpdateFormregistrationForm(@RequestParam(required = true, name = "id") User user, Model model) {
		model.addAttribute("user", user);
		model.addAttribute("page-title", "Update User");
		return "user/createUsersForm";
	}

	@PostMapping("/save")
	public String saveBookshandleRegistration(@Valid User user, BindingResult result) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "user/createUsersForm";
		}
		user.setPasswordHash(passwordEncoder.encode(user.getPassword()));
		user.setPasswordPlain(user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);

		return "redirect:/users";
	}
	
	 @RequestMapping(value = "/delete")
	    public String hapusPeserta(@RequestParam(required = true, name = "id") User user,Model model){
	        userService.delete(user);
	        return "redirect:/users";
	    }

}
