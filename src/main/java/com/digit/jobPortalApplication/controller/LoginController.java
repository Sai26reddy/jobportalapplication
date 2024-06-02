package com.digit.jobPortalApplication.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.repositories.FreeLancerRepository;
import com.digit.jobPortalApplication.service.FreeLancerService;
import com.digit.jobPortalApplication.service.RecruiterService;

@Controller
public class LoginController {
	
	@Autowired
	RecruiterService recruiterService;
	
	@Autowired
	FreeLancerRepository freeLancerService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	ObjectFactory<HttpSession> httpsessionFactory;
	@Autowired
	FreeLancerService freeLancerservice;
	
	@GetMapping("/")
	public String firstpage()
	{
		return "firstpage";
	}
	
	@PostMapping("/recruitersignin")
	public ModelAndView adminlogin(@RequestParam("user_id") Long user_id,@RequestParam("password") String password,HttpSession session) {
		try {
		Recruiter recruiter=recruiterService.findById(user_id);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(password, recruiter.getPassword()))
		{
			session = httpsessionFactory.getObject();
			session.setAttribute("recruiter", recruiter);
			ModelAndView mv=new ModelAndView("recruit");
			mv.addObject("password", password);
			mv.addObject("user_id", user_id);
			return mv;
		}
		else
			return new ModelAndView("/");
		}
		catch(Exception e) {
			return new ModelAndView("/");
		}
	}
	
	@GetMapping("/login")
	public ModelAndView login(@RequestParam String userName,@RequestParam String password,HttpSession session) {
		FreeLancer freeLancer = freeLancerService.findByEmail(userName);
		session = httpsessionFactory.getObject();
		session.setAttribute("freeLancer", freeLancer);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(password, freeLancer.getPassword())) {
			ModelAndView mv = new ModelAndView("NewLogin");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("signup");
			return mv;
		}
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "LoginNewNew";
	}
	
	@GetMapping("/freeLancerSignUp")
	public ModelAndView create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,@RequestParam String pswd,@RequestParam String cpswd) {
		ModelAndView mv = new ModelAndView("LoginNewNew");
		if(pswd.equals(cpswd)) {
			mv.addObject("error",false);
			mv.addObject("success",true);
			String password = this.encoder.encode(pswd);
			freeLancerservice.create(firstName,lastName,email,password);
		return mv;
		}else {
			mv.addObject("error",true);
			return mv;
		}
	}
	
	@GetMapping("/recruiterLoginPage")
	public String recruiterLoginPage() {
		return "recruitersignin";
	}
	
	@GetMapping("/recruiterSignUpPage")
	public String recruiterSignUp() {
		return "RecruiterSignUp";
	}
	
	@GetMapping("/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}
	
}
