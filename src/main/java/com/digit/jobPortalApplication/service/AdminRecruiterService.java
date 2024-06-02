package com.digit.jobPortalApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.exceptionHandling.NoAdminRecruiterIdExistsException;
import com.digit.jobPortalApplication.model.Admin_Recruiter;
import com.digit.jobPortalApplication.repositories.Admin_RecruiterRepository;


@Service
public class AdminRecruiterService {

	@Autowired
	Admin_RecruiterRepository adminRecruiterRepository;
	
	public List<Admin_Recruiter> findAll() throws NoAdminRecruiterIdExistsException{
		if(adminRecruiterRepository.findAll()==null)
		{
			throw new NoAdminRecruiterIdExistsException("Admin Recruiter Id does not exists");
		}
		else
		return adminRecruiterRepository.findAll();
	}
	
	public void save(String coverLetter,String firstName,String lastName) {
		Admin_Recruiter adminRecruiter = new Admin_Recruiter();
		adminRecruiter.setCoverLetter(coverLetter);
		adminRecruiter.setFirstName(firstName);
		adminRecruiter.setLastName(lastName);
		adminRecruiterRepository.save(adminRecruiter);
	}
}
