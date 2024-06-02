package com.digit.jobPortalApplication.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.digit.jobPortalApplication.model.FreeLancer;

public class FreeLancerDetails implements UserDetails{

	
	private FreeLancer freeLancer;
	
//	
	public FreeLancerDetails(FreeLancer freeLancer) {
	super();
	this.freeLancer = freeLancer;
}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return freeLancer.getPassword();
	}

	@Override
	public String getUsername() {
		return freeLancer.getEmail();
	
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
