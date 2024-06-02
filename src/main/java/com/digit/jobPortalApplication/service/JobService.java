package com.digit.jobPortalApplication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.model.BookMarkJob;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.JobApplication;
import com.digit.jobPortalApplication.exceptionHandling.NoSkillExistsException;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.model.Skill;
import com.digit.jobPortalApplication.repositories.BookMarkJobRepository;
import com.digit.jobPortalApplication.repositories.JobApplicationRepository;
import com.digit.jobPortalApplication.repositories.JobRepository;
import com.digit.jobPortalApplication.repositories.RecruiterRepository;
import com.digit.jobPortalApplication.serviceInterface.JobServiceInterface;

@Service
public class JobService implements JobServiceInterface{
	@Autowired
	JobRepository jobRepository;
	@Autowired
	RecruiterRepository recruiterRepository;
	@Autowired
	JobApplicationRepository jobApplicationRepository;
	@Autowired
	BookMarkJobRepository bookMarkJobRepository;

	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	public List<Job> getAllActiveJobs(List<Job> jobs) {
		List<Job> activeJobs = new ArrayList<Job>(jobs);
//		List<JobApplication> jobApplications = jobApplicationRepository.findByFreeLancer(freeLancer);
//		List<BookMarkJob> bookMarkJobs = bookMarkJobRepository.findByFreeLancer(freeLancer);
//		for(Job job:jobs) {
//			for(JobApplication jobApplication : jobApplications) {
//				if(jobApplication.getJob().equals(job)) {
//					activeJobs.remove(job);
//				}
//			}
//		}
//		List<Job> tempJobs = new ArrayList<Job>(activeJobs);
//		for(Job job:jobs) {
//			for(BookMarkJob bookMarkJob : bookMarkJobs) {
//				if(bookMarkJob.getJob().equals(job)) {
//					tempJobs.remove(job);
//				}
//			}
//		}
//		List<Job> temp1Jobs = new ArrayList<Job>(tempJobs);
		for(Job job : jobs) {
			if(job.getActive()==false) {
				activeJobs.remove(job);
			}
		}
		return activeJobs;
	}
	
	public Skill findSkillById(long id) throws NoSkillExistsException {
		
		if(jobRepository.findById(id).get().getSkill()==null)
		{
			throw new NoSkillExistsException("Skill does not exists");
		}
		else
			return jobRepository.findById(id).get().getSkill();
	}

	

	 public Job findById(Long id) {
	 Job job= jobRepository.findById(id).get();
	 return job;
	 }
	 
//	 public Job updateJob(Job job ,List<JobApplication> jobApplications,Boolean jobStatus){
//		 job.setJobapplications(jobApplications);
//		 job.setJobStatus(jobStatus);
//		 return jobRepository.save(job);
//	 }
	 
	 public Recruiter getRecruiterById(Long id) {
		 Long recruiterId = jobRepository.getRecruiterIdByJobId(id);
		 Recruiter recruiter = recruiterRepository.findById(recruiterId).get();
		 return recruiter;
	 }

	public Map<Job,String> mapping(List<Job> activeJobs) {
		Map<Job,String> mp = new HashMap<Job,String>();
		for(Job j : activeJobs) {
			Recruiter recruiter = getRecruiterById(j.getId());
			String recruiterName = recruiter.getFirstName()+recruiter.getLastName();
			mp.put(j,recruiterName);
		}
		return mp;
	}

	public void create(Job job) {
		jobRepository.save(job);
	}

	public void deleteJob(Job job) {
		
		List<JobApplication> jobApplications =  jobApplicationRepository.findByJob(job);
		for(JobApplication jobApplication : jobApplications) {
			jobApplication.setJob(null);
			jobApplicationRepository.save(jobApplication);
		}
		jobRepository.deleteById(job.getId());
	}

	public List<Job> removeAppliedJobs(List<Job> jobs, FreeLancer freeLancer) {
		List<JobApplication> jobApplications = jobApplicationRepository.findByFreeLancer(freeLancer);
		List<Job> activeJobs = new ArrayList<Job>(jobs);
		for(Job job:jobs) {
			for(JobApplication jobApplication : jobApplications) {
				if(jobApplication.getJob().equals(job)) {
					activeJobs.remove(job);
				}
			}
	}
		return activeJobs;
	}

	public List<BookMarkJob> getbookmarkedJobs(FreeLancer freeLancer) {
		List<BookMarkJob> bookMarkJobs = bookMarkJobRepository.findByFreeLancer(freeLancer);
		return bookMarkJobs;
	}
}

