package com.digit.jobPortalApplication.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.exceptionHandling.NoFreeLancerIdExistsException;
import com.digit.jobPortalApplication.exceptionHandling.NoIdExistsException;
import com.digit.jobPortalApplication.exceptionHandling.NoSkillExistsException;
import com.digit.jobPortalApplication.model.BookMarkJob;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.repositories.FreeLancerRepository;
import com.digit.jobPortalApplication.repositories.JobApplicationRepository;
import com.digit.jobPortalApplication.model.JobApplication;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.model.Skill;
import com.digit.jobPortalApplication.repositories.JobRepository;
import com.digit.jobPortalApplication.repositories.RecruiterRepository;
import com.digit.jobPortalApplication.repositories.SkillRepository;
import com.digit.jobPortalApplication.service.JobApplicationService;
import com.digit.jobPortalApplication.service.JobService;
import com.digit.jobPortalApplication.service.RecruiterService;
import com.digit.jobPortalApplication.service.SkillService;
import com.digit.jobPortalApplication.serviceInterface.JobApplicationServiceInterface;

@Controller
public class JobController {
	@Autowired
	JobService service;
	@Autowired
	FreeLancerRepository freeRepository;
	@Autowired
	JobApplicationService jobApplicationService;
	@Autowired
	SkillService skillService;
	@Autowired
	RecruiterService recruiterService;
	@Autowired
	JobService jobService;
	@Autowired
	JobRepository jobRepository;
	@Autowired
	JobApplicationRepository jar;
	@GetMapping("/viewActiveJobs")
	public  ModelAndView getAllJobs(HttpSession session){
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		List<Job> jobs = service.getAllJobs();
		ModelAndView mv = new ModelAndView("viewAllJobs");
		System.out.println(freeLancer);
		if(freeLancer==null) {
			System.out.println(jobs);
			mv.addObject("bookmarkjobs",null);
			mv.addObject("listOfAllJobs",jobs);
			mv.addObject("isLogin",false);
		}else {
			List<Job> activeJobs = service.getAllActiveJobs(jobs);
			List<Job> unappliedJobs = service.removeAppliedJobs(activeJobs,freeLancer);
			List<BookMarkJob> bookmarkJobs = service.getbookmarkedJobs(freeLancer);
			mv.addObject("bookmarkjobs",bookmarkJobs);
			mv.addObject("listOfAllJobs",unappliedJobs);
			mv.addObject("isLogin",true);
		}
		return mv;
	}
	
	@GetMapping("/postthejob")
	public ModelAndView postthejob() {
		ModelAndView mv= new ModelAndView("postjob");
		return mv;
	}
	
	@PostMapping("/postajob")
	public String postajob( @RequestParam("jobTitle") String jobTitle,@RequestParam("skill") String skillName,@RequestParam("experience") String experience ,@RequestParam("skilldescription") String skilldescription,HttpSession session) throws NoIdExistsException {
		Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
		Skill skill = new Skill();
		skill.setDescription(skilldescription);
		skill.setName(skillName);
		Job job=new Job();
	    job.setActive(true);
	    job.setJobRole(jobTitle);
	    job.setJobStatus(true);
	    job.setSkill(skill);
	    job.setRecruiter(recruiter);
	    jobService.create(job);
		return "recruit";
	}
	
	@GetMapping("/deletepostedjob/{jobId}")
	public String deleteJob(@PathVariable Long jobId) {
		Job job = jobRepository.findById(jobId).get();
		jobService.deleteJob(job);
		return "redirect:/viewpostedjobs";
	}
	
}
