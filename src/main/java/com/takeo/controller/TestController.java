package com.takeo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("/home")
	public String showHomePage(Model model) {
		model.addAttribute("name", "this name is coming from model obj in the controller");
		return "index";
	}
	
	@RequestMapping("/help")
	public String showHelp() {
		return "help";
	}
	
	@GetMapping("/about")
	public ModelAndView showRegister() {
		ModelAndView mv = new ModelAndView();
		List <Integer>  marks = new ArrayList<>();
		marks.add(100);
		marks.add(150);
		mv.addObject("modelAbout", "passing from controller to view");
		mv.addObject("numbers", marks);
		mv.setViewName("about");
		return mv;
	}
	
	
	@RequestMapping("/register")
	public String showRegistrationForm () {
		return "register";
	}
	@RequestMapping("/saveUser")
	public ModelAndView saveUser () {
		ModelAndView mv = new ModelAndView();
		mv.addObject("successMessage", "User sent to db successfully");
		mv.setViewName("success");
		return mv;
	}
}
