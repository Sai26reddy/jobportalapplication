package com.digit.jobPortalApplication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.model.BookMarkJob;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.repositories.BookMarkJobRepository;
import com.digit.jobPortalApplication.serviceInterface.BookMarkJobServiceInterface;


@Service
public class BookMarkJobService implements BookMarkJobServiceInterface{
	@Autowired
	BookMarkJobRepository bookMarkJobRepository;
	@Autowired
	FreeLancerService freeLancerService;
	@Autowired
	JobService jobService;

	public List<Job> getllJobs(List<BookMarkJob> bookMarkJobs) {
		List<Job> jobs = new ArrayList<Job>();
		for(BookMarkJob j : bookMarkJobs) {
			jobs.add(j.getJob());
		}
		return jobs;
	}

	public Map<BookMarkJob, String> mapping(List<BookMarkJob> bookMarkJobs) {
		Map<BookMarkJob,String> mp = new HashMap<BookMarkJob,String>();
		for(BookMarkJob j : bookMarkJobs) {
			Recruiter recruiter = jobService.getRecruiterById(j.getJob().getId());
			String recruiterName = recruiter.getFirstName()+recruiter.getLastName();
			mp.put(j,recruiterName);
		}
		return mp;
	}

	public void deleteById(Long id) {
		bookMarkJobRepository.deleteById(id);
	}

	public void bookMarkJob(Job job, FreeLancer freeLancer) {
		BookMarkJob bookMarkJob = new BookMarkJob();
		bookMarkJob.setFreeLancer(freeLancer);
		bookMarkJob.setJob(job);
		bookMarkJob.setSkill(job.getSkill());
		bookMarkJobRepository.save(bookMarkJob);
	}

	public List<BookMarkJob> getAllBookMarkJobs(FreeLancer freeLancer) {
		List<BookMarkJob> bookMarkJobs = bookMarkJobRepository.findByFreeLancer(freeLancer);
		return bookMarkJobs;
	}
}
