package com.digit.jobPortalApplication.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.exceptionHandling.NoFreeLancerIdExistsException;
import com.digit.jobPortalApplication.exceptionHandling.NoRecruiterExistsException;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.model.RecruiterC;
import com.digit.jobPortalApplication.repositories.RecruiterCRepository;

@Service
public class RecruiterCService {

	@Autowired
	RecruiterCRepository recruiterCRepository;
	
	public RecruiterC findByFirstName(String firstName) throws NoRecruiterExistsException {
		
		if(recruiterCRepository.findByfirstName(firstName)==null)
		{
			throw new NoRecruiterExistsException("Recruiter does not exists");
		}
		else
			return recruiterCRepository.findByfirstName(firstName);
	}
	
	public void save(String firstName,String coverLetter,String lastName,String mail,String password) {
		RecruiterC recruiterC = new RecruiterC();
		recruiterC.setFirstName(firstName);
		recruiterC.setCoverLetter(coverLetter);
		recruiterC.setLastName(lastName);
		recruiterC.setMail(mail);
		recruiterC.setPassword(password);
		recruiterCRepository.save(recruiterC);
	}

	public void delete(String firstName) {
		
		recruiterCRepository.deleteById(firstName);
	}
}
