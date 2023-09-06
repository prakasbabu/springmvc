package com.takeo.controller;

import org.springframework.cglib.core.EmitUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.takeo.entity.CustomUser;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/showForm")
	public String showRegistrationForm () {
		return "signin";
	}
	
	
	 //@PostMapping("/processForm")
	 @RequestMapping(path = "/processForm", method = RequestMethod.POST) 
	 public ModelAndView processSignInForm(@RequestParam ("email") String email, 
			 @RequestParam ("password") String password, ModelAndView modelAndView){
		 modelAndView.addObject("successMessage", "Sign in Successful");
		 modelAndView.setViewName("success");
		 System.out.println(email);
		 System.out.println(password); 
		 modelAndView.addObject("email","your email is:"+email);
		 modelAndView.addObject("password","your password is:"+password);
	 
		 CustomUser customUser = new CustomUser(); 
		 customUser.setEmailAddress(email);
		 customUser.setPassword(password); 
		System.out.println(customUser); 
		modelAndView.addObject("customUser",customUser);
	 return modelAndView;
	 }
	
//	@RequestMapping(path = "/processForm", method = RequestMethod.POST) 
//	public String handleForm (@ModelAttribute CustomUser customUser, Model model) {
//		System.out.println(customUser);
//		model.addAttribute(customUser);
//		return "success";
//		
//	}
	

}
