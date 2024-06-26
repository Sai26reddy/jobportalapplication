package com.digit.jobPortalApplication.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends  WebSecurityConfigurerAdapter{
	
	@Bean 
	public UserDetailsService getUserDetails() {
		return new FreeLancerDetailsService();
	}
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
    
    public DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    	auth.setUserDetailsService(this.getUserDetails());
    	auth.setPasswordEncoder(passwordEncoder());
    	return auth;
    }
    
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http.csrf()
         .disable()
         .authorizeRequests()
         .antMatchers("/**")
         .permitAll();

    }
	

}
