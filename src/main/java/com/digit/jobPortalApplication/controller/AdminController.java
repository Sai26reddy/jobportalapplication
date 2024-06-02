package com.digit.jobPortalApplication.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.exceptionHandling.NoRecruiterExistsException;
import com.digit.jobPortalApplication.model.Admin;
import com.digit.jobPortalApplication.model.Admin_Recruiter;
import com.digit.jobPortalApplication.model.BookMarkFreeLancer;
import com.digit.jobPortalApplication.model.Feedback;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.model.RecruiterC;
import com.digit.jobPortalApplication.repositories.Admin_RecruiterRepository;
import com.digit.jobPortalApplication.repositories.RecruiterCRepository;
import com.digit.jobPortalApplication.repositories.RecruiterRepository;
import com.digit.jobPortalApplication.service.AdminRecruiterService;
import com.digit.jobPortalApplication.service.MailService;
import com.digit.jobPortalApplication.service.RecruiterCService;
import com.digit.jobPortalApplication.service.RecruiterService;
import com.digit.jobPortalApplication.serviceInterface.AdminServiceInterface;


@Controller
public class AdminController {
	@Autowired
	AdminServiceInterface adminservice;
	@Autowired
	AdminRecruiterService adminRecruiterService;
	@Autowired
	RecruiterCService recruiterCService;
	@Autowired
    MailService mailService;
	@Autowired
	RecruiterService recruiterService ;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@GetMapping("/m")
	public String dis()
	{
		return "mainpage";
	}
	
	
	
	@PostMapping("/adminlogin")
	public ModelAndView adminlogin(@RequestParam("user_id") Long user_id,@RequestParam("password") String password,HttpServletRequest request,HttpServletResponse response)
	{
		try{
		Admin admin=adminservice.findById(user_id);
		if(admin.getPassword().trim().equals(password.trim()))
		{
			List<Admin_Recruiter> ar=adminRecruiterService.findAll();
			ModelAndView mv=new ModelAndView("admin");
			mv.addObject("password", password);
			mv.addObject("user_id", user_id);
			mv.addObject("ar", ar);
			return mv;
		}
		else
			return new ModelAndView("adminloginerror") ;
	}
		catch(Exception e)
		{
			return new ModelAndView("adminloginerror") ;
		}
	}
	
	
	@GetMapping("acceptrecruiters/{firstName}")
	public String insertrecruiter(@PathVariable("firstName") String firstName) throws UnsupportedEncodingException, MessagingException, NoRecruiterExistsException
	{
		RecruiterC recruiterC=recruiterCService.findByFirstName(firstName);
		String lastName=recruiterC.getLastName();
		String password=recruiterC.getPassword();
		String pass = this.encoder.encode(password);
		String mail=recruiterC.getMail();
		String coverLetter=recruiterC.getCoverLetter();
		long id=recruiterService.save(firstName,lastName,mail,pass,coverLetter);
		mailService.sendMessage(id, password, mail);
		return "adminlogin";
	}
	
	@GetMapping("/deleteRecruiter/{firstName}")
	public String deleteRecruiter(@PathVariable String firstName) {
		recruiterCService.delete(firstName);
		return "adminlogin";
	}
	
	
}