package com.digit.jobPortalApplication.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.exceptionHandling.NoIdExistsException;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.repositories.JobRepository;
import com.digit.jobPortalApplication.repositories.RecruiterCRepository;
import com.digit.jobPortalApplication.repositories.RecruiterRepository;
import com.digit.jobPortalApplication.serviceInterface.RecruiterServiceInterface;

@Service
public class RecruiterService implements RecruiterServiceInterface{
	@Autowired 
	RecruiterRepository recruiterRepository;
	@Autowired
	JobRepository jobRepository;
	@Autowired
	RecruiterCRepository recruiterCRepository;
	public Long save(String firstName,String lastName,String mail,String password,String coverLetter) {
		Recruiter recruiter = new Recruiter();
		recruiter.setFirstName(firstName);
		recruiter.setLastName(lastName);
		recruiter.setMail(mail);
		recruiter.setPassword(password);
		recruiter.setCoverLetter(coverLetter);
		recruiterRepository.save(recruiter);
		recruiterCRepository.deleteById(firstName);
		long id = recruiter.getId();
		return id;
	}
	public void saveRecruiter(Recruiter recruiter) {
		recruiterRepository.save(recruiter);
		
	}
	
	public Recruiter findById(long user_id) throws NoIdExistsException{
		if(recruiterRepository.findById(user_id).get()==null) {
			throw new NoIdExistsException("Admin with this id doesnot exist");
		}
		else {
			return recruiterRepository.findById(user_id).get();
		}
	}
	public List<Job> getAllJobs(Recruiter recruiter) {
		List<Job>  postedJobs = jobRepository.findByRecruiter(recruiter);
		return postedJobs;
	}
	
}
