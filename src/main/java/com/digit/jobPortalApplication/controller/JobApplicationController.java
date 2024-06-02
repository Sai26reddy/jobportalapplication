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
import com.digit.jobPortalApplication.exceptionHandling.NoIdExistsException;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.JobApplication;
import com.digit.jobPortalApplication.model.SkillExperience;
import com.digit.jobPortalApplication.service.FreeLancerService;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.repositories.JobApplicationRepository;
import com.digit.jobPortalApplication.repositories.JobRepository;
import com.digit.jobPortalApplication.service.JobApplicationService;
import com.digit.jobPortalApplication.service.JobService;
import com.digit.jobPortalApplication.service.RecruiterService;
import com.digit.jobPortalApplication.service.SkillExperienceService;

@Controller
public class JobApplicationController {
	@Autowired
	FreeLancerService freeLancerService;
	@Autowired
	JobApplicationRepository jobApplicationRepository;
	@Autowired
	RecruiterService recruiterService;
	@Autowired
	JobRepository jrep;
	@Autowired
	JobApplicationService jobApplicationService;
	@Autowired
	JobService jobService;
	@Autowired
	SkillExperienceService skillExperienceService;
	
	@GetMapping("/viewAppliedJobs")
	 public ModelAndView viewAllAppliedJobs(HttpSession session) throws NoFreeLancerIdExistsException, NoIdExistsException {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		List<JobApplication> jobApplications = jobApplicationService.getAppliedJobs(freeLancer);
		ModelAndView mv = new ModelAndView("viewAllAppliedJobs");
		mv.addObject("jobApplications",jobApplications);
		return mv;
	}
	
	@GetMapping("/applyJob/{jobId}")
	public String applyToJob(@PathVariable Long jobId,HttpSession session) throws NoFreeLancerIdExistsException {
		Job job = jobService.findById(jobId);
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		jobApplicationService.applyJob(freeLancer,job);
		return "redirect:/viewActiveJobs";
	}
	
	
	@GetMapping("/deleteappliedJob/{id}")
	public String deleteAppledJob(@PathVariable Long id) {
		jobApplicationService.deleteById(id);
		return "redirect:/viewAppliedJobs";
	}
	
	
	
	@GetMapping("/view-applications/{id}")
	public ModelAndView va(@PathVariable("id") Long jobId) throws NoFreeLancerIdExistsException{   
		Job job = jobService.findById(jobId);
		Map<JobApplication,List<SkillExperience>> jobApllications = jobApplicationService.getAllApplications(job);
		ModelAndView mv=new ModelAndView("jobapplications");
		mv.addObject("jobApplications",jobApllications);
		return mv;
	}
	
	
	@GetMapping("/accept/{jobAppId}/{freeLancerId}")
	public String accept(@PathVariable Long jobAppId,@PathVariable Long freeLancerId) throws NoFreeLancerIdExistsException
	{
		JobApplication jobApplication=jobApplicationRepository.findById(jobAppId).get();
		FreeLancer freeLancer = freeLancerService.findById(freeLancerId);
		jobApplicationService.accept(jobApplication,freeLancer);
		return "recruit";
	}
	
	@GetMapping("/reject/{jobApplicationId}")
	public String reject(@PathVariable Long jobApplicationId) throws NoFreeLancerIdExistsException
	{
		JobApplication jobApplication=jobApplicationRepository.findById(jobApplicationId).get();
		jobApplicationService.reject(jobApplication);
		return "redirect:/view-applications/" + jobApplication.getJob().getId();
	}
}
	
	

