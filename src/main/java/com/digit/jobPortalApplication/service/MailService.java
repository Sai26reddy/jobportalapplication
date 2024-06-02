package com.digit.jobPortalApplication.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
    JavaMailSender mailsender;
	
	public void sendMessage(long id,String password,String mail) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message=mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		
		String mailSubject="your account is successfully created";
		String mailContent="<p><b>your user_id is </b>"+id+"</p>";
		mailContent +="<p><b>your password is </b>"+password+"</p>";
				
		helper.setFrom("sathiviswanthreddy@gmail.com","viswanth");
		helper.setTo(mail);
		helper.setSubject(mailSubject);
		helper.setText(mailContent,true);
		mailsender.send(message);
	}
	
	
	
	public void sendMsg(String firstName,String lastName,String coverLetter) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message=mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		
		String mailSubject="There is a Recruiter sign-up request";
		String mailContent="<p><b>First Name: </b>"+firstName+"</p>";
		mailContent +="<p><b>Last Name: </b>"+lastName+"</p>";
		mailContent +="<p><b>Cover Letter: </b>"+coverLetter+"</p>";
		
		helper.setFrom("sathiviswanthreddy@gmail.com","viswanth");
		//helper.setTo(adminrepository.findById((long) 1).get().getMail());
		helper.setTo("kayraajakay007@gmail.com");
		helper.setSubject(mailSubject);
		helper.setText(mailContent,true);
		mailsender.send(message);
	}
}
