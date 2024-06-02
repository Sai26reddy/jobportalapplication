package com.digit.jobPortalApplication.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.JobApplication;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.model.SkillExperience;
import com.digit.jobPortalApplication.exceptionHandling.NoFreeLancerIdExistsException;
import com.digit.jobPortalApplication.repositories.JobApplicationRepository;
import com.digit.jobPortalApplication.repositories.JobRepository;
import com.digit.jobPortalApplication.repositories.SkillExperienceRepository;
import com.digit.jobPortalApplication.serviceInterface.JobApplicationServiceInterface;

@Service
public class JobApplicationService implements JobApplicationServiceInterface{
	@Autowired
	JobApplicationRepository jobApplicationRepository;
	@Autowired
	JobService jobService;
	@Autowired
	FreeLancerService freeLancerService;
	@Autowired
	JobRepository jobRepository;
	@Autowired
	SkillExperienceRepository skillExperienceRepository;

	public JobApplication findById(Long id) {
		return jobApplicationRepository.findById(id).get();
	}
	
	public JobApplication create(JobApplication jobApplication) {
		return jobApplicationRepository.save(jobApplication);
	}

//	public Map<JobApplication, String> mapping(FreeLancer freeLancer) {
//		List<JobApplication> jobApplications = freeLancer.getAppliedJobs();
//		Map<JobApplication, String> mp = new HashMap<JobApplication, String>();
//		for(JobApplication j : jobApplications) {
//			Recruiter recruiter = jobService.getRecruiterById(j.getJob().getId());
//			String recruiterName = recruiter.getFirstName()+recruiter.getLastName();
//			mp.put(j, recruiterName);
//		}
//		return mp;
//	}


	public void deleteById(Long id) {
		jobApplicationRepository.deleteById(id);
	}

	public void applyJob(FreeLancer freeLancer, Job job) {
		JobApplication jobApplication = new JobApplication();
		LocalDateTime localdate = LocalDateTime.now();
		jobApplication.setFreeLancer(freeLancer);
		jobApplication.setJob(job);
		jobApplication.setCoverLetter("PENDING");
		jobApplication.setAppliedDate(localdate);
		jobApplicationRepository.save(jobApplication);
	}

	public List<JobApplication> getAppliedJobs(FreeLancer freeLancer) {
		List<JobApplication> jobApplications = jobApplicationRepository.findByFreeLancer(freeLancer);
		return jobApplications;
	}

	public Map<JobApplication, List<SkillExperience>> getAllApplications(Job job) {
		Map<JobApplication, List<SkillExperience>> mp = new HashMap<JobApplication, List<SkillExperience>>();
		List<JobApplication> jobApplications = jobApplicationRepository.findByJob(job);
		for(JobApplication jobApplication : jobApplications) {
			FreeLancer freeLancer = jobApplication.getFreeLancer();
			List<SkillExperience> skill = skillExperienceRepository.findByFreeLancer(freeLancer);
			mp.put(jobApplication, skill);
		}
		return mp;
	}

	public void accept(JobApplication jobApplication, FreeLancer freeLancer) {
		jobApplication.setCoverLetter("ACCEPTED");
		jobApplicationRepository.save(jobApplication);
		Job job = jobApplication.getJob();
		job.setAwardedTo(freeLancer);
		job.setActive(false);
		jobRepository.save(job);
	}

	public void reject(JobApplication jobApplication) {
		jobApplication.setCoverLetter("REJECTED");
		jobApplicationRepository.save(jobApplication);
	}

	
//	public List<FreeLancer> getFreeLancer(Long id) throws NoFreeLancerIdExistsException {
//		
//		List<Long> freeLancerId = new ArrayList<Long>();
//			freeLancerId=	jobApplicationRepository.getFreeLancerIdByJobId(id);
//			System.out.println(freeLancerId);
//		List<FreeLancer> freeLancer=new ArrayList<FreeLancer>();
//		for(Long i: freeLancerId)
//		{
//			freeLancer.add(freeLancerService.findById(i));
//		}
//		return freeLancer;
//		
//	}
//	
//	public Map<JobApplication, FreeLancer> getJobApplication(Long jobId) throws NoFreeLancerIdExistsException{
//	 List<FreeLancer> freeLancer=getFreeLancer(jobId);
//	List<JobApplication> ja=jobRepository.findById(jobId).get().getJobapplications();
//	Map<JobApplication, FreeLancer> map=new HashMap<JobApplication, FreeLancer>();
//	for(int i=0;i<freeLancer.size();i++)
//	{
//		map.put(ja.get(i), freeLancer.get(i));
//	}
//	return map;
//	}
//
//
//	public JobApplication findByJobId(Long jobId,Long freelancerId) {
//		return jobApplicationRepository.findByJobId(jobId,freelancerId);
//	}
}
