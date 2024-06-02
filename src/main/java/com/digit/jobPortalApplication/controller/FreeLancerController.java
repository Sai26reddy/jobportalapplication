package com.digit.jobPortalApplication.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.exceptionHandling.NoFreeLancerIdExistsException;
import com.digit.jobPortalApplication.model.Feedback;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.JobApplication;
import com.digit.jobPortalApplication.model.SkillExperience;
import com.digit.jobPortalApplication.repositories.JobApplicationRepository;
import com.digit.jobPortalApplication.repositories.JobRepository;
import com.digit.jobPortalApplication.service.FreeLancerService;
import com.digit.jobPortalApplication.service.JobApplicationService;
import com.digit.jobPortalApplication.service.JobService;

@Controller
public class FreeLancerController {
	@Autowired
	FreeLancerService freeLancerservice;
	@Autowired
	JobService jobService;
	@Autowired
	JobApplicationService jobApplicationService;
	@Autowired
	JobRepository jrep;
	@Autowired
	JobApplicationRepository jar;
	@Autowired
	ObjectFactory<HttpSession> httpsessionFactory;

	
	
	@GetMapping("/profile")
	public ModelAndView updateProfile(HttpSession session) throws NoFreeLancerIdExistsException {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		List<SkillExperience> skills = freeLancerservice.profile(freeLancer);
		ModelAndView mv = new ModelAndView("profile");
		mv.addObject("skillExperience",skills);
		mv.addObject("freeLancer",freeLancer);
		return mv;
	}
	
	@GetMapping("/signUpPage")
	public String signUp() {
		return "signup";
	}
	
	
	@GetMapping("/ongoingJobs")
	public ModelAndView completeJob(HttpSession session) {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		List<JobApplication> jobApplications = freeLancerservice.getOngoingJobs(freeLancer);
		ModelAndView mv = new ModelAndView("ongoingJobs");
		mv.addObject("currentJobs",jobApplications);
		return mv;
	}
	
	@GetMapping("/oncompleteJob/{jobAppId}")
	public String oncompleteJob(@PathVariable Long jobAppId,HttpSession session) {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		freeLancerservice.OncompleteJob(jobAppId,freeLancer);
		return "homePage";
	}
	
	@GetMapping("/viewAllFeedbacks")
	public ModelAndView viewAllFeedbacks(HttpSession session) {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		List<Feedback> feedbacks = freeLancerservice.getAllfeedbacks(freeLancer);
		ModelAndView mv = new ModelAndView("viewAllCompletedFeedbacks");
		System.out.println(feedbacks);
		mv.addObject("feedbacks",feedbacks);
		return mv;
	}
	
	@GetMapping("/aboutus")
	public String aboutUs() {
		return "aboutus";
	}
	
	@GetMapping("/contactus")
	public String contactus() {
		return "contactus";
	}
	
	@GetMapping("/goToHome")
	public String home() {
		return "NewLogin";
	}
	
	@GetMapping("/updateProfile")
	public String updateProfile(@RequestParam("firstName") String firstName,@RequestParam String lastName,@RequestParam String mail,HttpSession session) {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		freeLancerservice.updateProfile(firstName,lastName,mail,freeLancer);
		return "redirect:/goToHome";
	}
	
	@GetMapping("/getCompletedJobs")
	public ModelAndView getCompletedJobs(HttpSession session) {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		List<JobApplication> jobApplications = freeLancerservice.getCompletedJobs(freeLancer);
		ModelAndView mv = new ModelAndView("completedJobs");
		mv.addObject("jobApplications",jobApplications);
		return mv;
	}
	
	
	@GetMapping("/freeLancerLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "LoginNewNew";
	}
	
	
}
