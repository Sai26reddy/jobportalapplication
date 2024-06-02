package com.digit.jobPortalApplication.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.model.BookMarkFreeLancer;
import com.digit.jobPortalApplication.model.JobApplication;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.repositories.BookFreeLancerRepository;
import com.digit.jobPortalApplication.serviceInterface.BookMarkFreeLancerServiceInterface;

@Service
public class BookMarkFreeLancerService implements BookMarkFreeLancerServiceInterface{
	@Autowired
	BookFreeLancerRepository bookFreeLancerRepository;

	public void bookMarkFreeLancer(JobApplication jobApplication, Recruiter recruiter) {
		BookMarkFreeLancer bookMarkFreeLancer=new BookMarkFreeLancer();
		bookMarkFreeLancer.setFreeLancer(jobApplication.getFreeLancer());
		bookMarkFreeLancer.setSkill(jobApplication.getJob().getSkill());
		bookMarkFreeLancer.setRecruiter(recruiter);
		bookFreeLancerRepository.save(bookMarkFreeLancer);
	}

	public List<BookMarkFreeLancer> getBookMarkedFreeLancers(Recruiter recruiter) {
		List<BookMarkFreeLancer> bookMarkedFreeLancers = bookFreeLancerRepository.findByRecruiter(recruiter);
		return bookMarkedFreeLancers;
	}

	public void deleteBookMarkFreeLancer(Long bmfl_id) {
		bookFreeLancerRepository.deleteById(bmfl_id);
	}
}
