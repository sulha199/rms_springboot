package com.shulha.spbootrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		return "layout.html";
	}
	
	@RequestMapping("/content1")
	public String content1(Model model) {
		return "Content1.html";
	}
}
