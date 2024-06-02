package com.digit.jobPortalApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.exceptionHandling.NoIdExistsException;
import com.digit.jobPortalApplication.model.Admin;
import com.digit.jobPortalApplication.repositories.AdminRepository;
import com.digit.jobPortalApplication.serviceInterface.AdminServiceInterface;



@Service
public class AdminService implements AdminServiceInterface {

	
	@Autowired
	AdminRepository adminRepository;
	@Override
	public Admin findById(long user_id) throws NoIdExistsException{
		// TODO Auto-generated method stub
		if(adminRepository.findById(user_id).get()==null) {
			throw new NoIdExistsException("Admin with this id doesnot exist");
		}
		else {
			return adminRepository.findById(user_id).get();
		}
	}

}
