package com.digit.jobPortalApplication.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.exceptionHandling.NoFreeLancerIdExistsException;
import com.digit.jobPortalApplication.model.BookMarkJob;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.service.BookMarkJobService;
import com.digit.jobPortalApplication.service.FreeLancerService;
import com.digit.jobPortalApplication.service.JobService;


@Controller
public class BookMarkJobController {
	@Autowired
	BookMarkJobService service;
	@Autowired
	FreeLancerService freeLancerservice;
	@Autowired
	JobService jobService;
	
	
	@GetMapping("/viewBookMarkedJobs")
	public ModelAndView viewBookMarkedJobs(HttpSession session) throws NoFreeLancerIdExistsException {
		FreeLancer freeLancer = (FreeLancer)session.getAttribute("freeLancer");
		List<BookMarkJob> bookMarkJobs = service.getAllBookMarkJobs(freeLancer);
		System.out.println(bookMarkJobs);
		ModelAndView mv = new ModelAndView("viewAllBookMarkJobs");
		mv.addObject("bookMarkJobApplications",bookMarkJobs);
		return mv;
	}
	
	@GetMapping("/bookMarkJob/{jobId}")
	public String onCompleteJob(@PathVariable Long jobId,HttpSession session) throws NoFreeLancerIdExistsException {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		Job job = jobService.findById(jobId);
		service.bookMarkJob(job,freeLancer);
		return "redirect:/viewActiveJobs";
	}
	
	@GetMapping("/deleteBookMarkJob/{id}")
	public String deleteBookMarkedJob(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/viewBookMarkedJobs";
	}
}
