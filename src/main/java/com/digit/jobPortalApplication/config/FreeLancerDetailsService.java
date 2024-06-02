package com.digit.jobPortalApplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.repositories.FreeLancerRepository;

public class FreeLancerDetailsService implements UserDetailsService{
	
	@Autowired
	FreeLancerRepository freeRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		FreeLancer freeLancer = freeRepository.findByEmail(username);
		if(freeLancer==null) {
			throw new UsernameNotFoundException("no freelancer");
		}
		
		FreeLancerDetails userdetails = new FreeLancerDetails(freeLancer);
		
		return userdetails;
		
	}

}
