package com.digit.jobPortalApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.model.Feedback;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Recruiter;
import com.digit.jobPortalApplication.repositories.FeedbackRepository;
import com.digit.jobPortalApplication.repositories.RecruiterRepository;
import com.digit.jobPortalApplication.serviceInterface.FreeLancerServiceInterface;

@Service
public class FeedBackService implements FreeLancerServiceInterface{
	@Autowired
	FeedbackRepository feedbackRepository;
	@Autowired
	RecruiterRepository recruiterRepository;

	public List<Feedback> getAllFeedBacks(long id) {
		Recruiter recruiter = recruiterRepository.findById(id).get();
		List<Feedback> feedbacks = feedbackRepository.findByRecruiter(recruiter);
		List<Feedback> pendingFeedBacks = new ArrayList<Feedback>(feedbacks);
		for(Feedback feedback : pendingFeedBacks) {
			if(feedback.getRating()!=0) {
			feedbacks.remove(feedback);
			}
		}
		return feedbacks;
	}

	public void updateFeedBack(Long feedbackId, String comment, int rating) {
		Feedback feedback = feedbackRepository.findById(feedbackId).get();
		feedback.setRating(rating);
		feedback.setComment(comment);
		feedbackRepository.save(feedback);
	}

	
}
