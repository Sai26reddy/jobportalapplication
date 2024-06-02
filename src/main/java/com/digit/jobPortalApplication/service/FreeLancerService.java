package com.digit.jobPortalApplication.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.model.BookMarkJob;
import com.digit.jobPortalApplication.exceptionHandling.NoFreeLancerIdExistsException;
import com.digit.jobPortalApplication.model.Feedback;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.JobApplication;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.model.Skill;
import com.digit.jobPortalApplication.model.SkillExperience;
import com.digit.jobPortalApplication.repositories.FeedbackRepository;
import com.digit.jobPortalApplication.repositories.FreeLancerRepository;
import com.digit.jobPortalApplication.repositories.JobApplicationRepository;
import com.digit.jobPortalApplication.repositories.JobRepository;
import com.digit.jobPortalApplication.repositories.RecruiterRepository;
import com.digit.jobPortalApplication.repositories.SkillExperienceRepository;
import com.digit.jobPortalApplication.serviceInterface.FreeLancerServiceInterface;

@Service
public class FreeLancerService implements FreeLancerServiceInterface{
	
	@Autowired
	FreeLancerRepository freeLancerRepository;
	@Autowired
	JobService service;
	@Autowired
	JobRepository jobRepository;
	@Autowired
	RecruiterRepository recruiterRepository;
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	JobApplicationRepository jobApplicationRepository;
	@Autowired
	SkillExperienceRepository skillExperienceRepository;
	
	
	public FreeLancer findById(Long id) throws NoFreeLancerIdExistsException {
		
		if(freeLancerRepository.findById(id).get()==null)
		{
			throw new NoFreeLancerIdExistsException("FreeLancer Id does not exists");
		}
		else
			return freeLancerRepository.findById(id).get();
	}

	public FreeLancer create(String fname,String lname,String email,String pswd) {
		FreeLancer freeLancer = new FreeLancer();
		freeLancer.setFirstName(fname);
		freeLancer.setLastName(lname);
		freeLancer.setEmail(email);
		freeLancer.setPassword(pswd);
		return freeLancerRepository.save(freeLancer);
	}
	

	public FreeLancer getById(long id) {
		return freeLancerRepository.findById(id).get();
	}

	public FreeLancer findByEmail(String userName) {
		return freeLancerRepository.findByEmail(userName);
	}

	public void OncompleteJob(Long jobAppId, FreeLancer freeLancer) {
		JobApplication jobApplication = jobApplicationRepository.findById(jobAppId).get();
		Feedback feedback = new Feedback();
		feedback.setRecruiter(jobApplication.getJob().getRecruiter());
		feedback.setFreeLancer(freeLancer);
		feedbackRepository.save(feedback);
		jobApplication.setCoverLetter("COMPLETED");
		jobApplicationRepository.save(jobApplication);
	}

	public List<JobApplication> getOngoingJobs(FreeLancer freeLancer) {
		List<JobApplication> jobApplications = jobApplicationRepository.findByFreeLancer(freeLancer);
		List<JobApplication> acceptedJobApplications = new ArrayList<JobApplication>();
		for(JobApplication jobApplication : jobApplications) {
			if(jobApplication.getCoverLetter().equals("ACCEPTED")) {
				acceptedJobApplications.add(jobApplication);
			}
		}
		return acceptedJobApplications;
	}

	public List<SkillExperience> profile(FreeLancer freeLancer) {
		List<SkillExperience> skills = skillExperienceRepository.findByFreeLancer(freeLancer);
		return skills;
	}

	public List<Feedback> getAllfeedbacks(FreeLancer freeLancer) {
		List<Feedback> feedbacks = feedbackRepository.findByFreeLancer(freeLancer);
		List<Feedback> allratedfeedbacks = new ArrayList<Feedback>(feedbacks);
		for(Feedback feedback : allratedfeedbacks) {
			if(feedback.getRating()==0) {
				feedbacks.remove(feedback);
			}
		}
		return feedbacks;
	}

	public void updateProfile(String firstName, String lastName, String mail, FreeLancer freeLancer) {
		freeLancer.setEmail(mail);
		freeLancer.setFirstName(firstName);
		freeLancer.setLastName(lastName);
		freeLancerRepository.save(freeLancer);
		
	}

	public List<JobApplication> getCompletedJobs(FreeLancer freeLancer) {
		List<JobApplication> jobApplications = jobApplicationRepository.findByFreeLancer(freeLancer);
		List<JobApplication> completedJobApplications = new ArrayList<JobApplication>();
		for(JobApplication jobApplication : jobApplications) {
			if(jobApplication.getCoverLetter().equals("COMPLETED")) {
				completedJobApplications.add(jobApplication);
			}
		}
		return completedJobApplications;
		
	}

	public List<JobApplication> getClosedJobs(FreeLancer freeLancer) {
		List<JobApplication> jobApplications = jobApplicationRepository.findByFreeLancer(freeLancer);
		List<JobApplication> closedJobApplications = new ArrayList<JobApplication>();
		for(JobApplication jobApplication : jobApplications) {
			if(jobApplication.getJob()==null) {
				closedJobApplications.add(jobApplication);
			}
		}
		return closedJobApplications;
	}



}
