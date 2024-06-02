package com.digit.jobPortalApplication.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.exceptionHandling.NoIdExistsException;
import com.digit.jobPortalApplication.exceptionHandling.NoPostedJobExistsException;
import com.digit.jobPortalApplication.model.Admin_Recruiter;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.model.RecruiterC;
import com.digit.jobPortalApplication.repositories.AdminRepository;
import com.digit.jobPortalApplication.repositories.Admin_RecruiterRepository;
import com.digit.jobPortalApplication.repositories.RecruiterCRepository;
import com.digit.jobPortalApplication.repositories.RecruiterRepository;
import com.digit.jobPortalApplication.service.AdminRecruiterService;
import com.digit.jobPortalApplication.service.JobService;
import com.digit.jobPortalApplication.service.MailService;
import com.digit.jobPortalApplication.service.RecruiterCService;
import com.digit.jobPortalApplication.service.RecruiterService;

@RestController
public class RecruiterController {
	@Autowired
	RecruiterCService recruiterCService;
	@Autowired
	RecruiterService recruiterService;
	@Autowired
    MailService mailService;
	@Autowired
	AdminRepository adminrepository;
	@Autowired
	AdminRecruiterService adminRecruiterService;
	@Autowired
	JobService jobservice;
	
   
	
	
	@PostMapping("/requestadmin")
	public ModelAndView requestAdmin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, MessagingException
	{
	String firstName=request.getParameter("firstName");
	String lastName=request.getParameter("lastName");
	String password=request.getParameter("password");
	String confirmPassword=request.getParameter("confirmPassword");
	String coverLetter=request.getParameter("coverLetter");
	String mail=request.getParameter("mail");
	if(password.trim().equals(confirmPassword.trim()))
	{
		
	    adminRecruiterService.save(coverLetter, firstName, lastName);
		recruiterCService.save(firstName, coverLetter, lastName, mail, confirmPassword);
		mailService.sendMsg(firstName, lastName, coverLetter);
		return new ModelAndView("wait_untill_accepted");
	}
	else
		return new ModelAndView("rsigninup");
		
	}
	
	@GetMapping("/viewpostedjobs")
	public ModelAndView viewpostedjobs(HttpSession session) throws NoIdExistsException, NoPostedJobExistsException
	{    
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		List<Job> postedJobs = recruiterService.getAllJobs(recruiter);
		ModelAndView mv= new ModelAndView("viewpostedjobs");
		mv.addObject("job",postedJobs);
		return mv;
	}
	
	@GetMapping("/logout/{user_id}")
	public void logout(@PathVariable long user_id,HttpServletResponse response) throws IOException
	{
		user_id=0;
		response.sendRedirect("/");
		
	}
	
}
