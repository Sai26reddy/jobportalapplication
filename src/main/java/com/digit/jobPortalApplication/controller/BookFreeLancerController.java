package com.digit.jobPortalApplication.controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.model.BookMarkFreeLancer;
import com.digit.jobPortalApplication.model.JobApplication;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.service.BookMarkFreeLancerService;
import com.digit.jobPortalApplication.service.JobApplicationService;

@Controller
public class BookFreeLancerController {
	@Autowired
	BookMarkFreeLancerService service;
	@Autowired
	JobApplicationService jobApplicationService;
	@GetMapping("/bookmarkedfreelancers")
	public ModelAndView bookmfl(HttpSession session)
	{
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		List<BookMarkFreeLancer> bookMarkedFreeLancers = service.getBookMarkedFreeLancers(recruiter);
		ModelAndView mv=new ModelAndView("bookmarkedfreelancers");
		mv.addObject("bmfl", bookMarkedFreeLancers);
		return mv;
	}
	
	
	@GetMapping("/bookMarkFreeLancer/{jobAppId}")
	public String bookmark(@PathVariable Long jobAppId,HttpSession session)
	{
		System.out.println(jobAppId);
		JobApplication jobApplication = jobApplicationService.findById(jobAppId);
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		service.bookMarkFreeLancer(jobApplication,recruiter);
		return "redirect:/view-applications/" + jobApplication.getJob().getId();
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String deletebookmarkedfreelancer(@PathVariable("id") Long bmfl_id)
	{
		service.deleteBookMarkFreeLancer(bmfl_id);
		return "redirect:/bookmarkedfreelancers";
	}
}


