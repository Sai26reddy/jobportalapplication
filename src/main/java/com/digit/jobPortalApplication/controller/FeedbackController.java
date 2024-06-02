package com.digit.jobPortalApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.model.Feedback;
import com.digit.jobPortalApplication.service.FeedBackService;

@Controller
public class FeedbackController {	
	@Autowired
	FeedBackService feedBackservice;
	
	@GetMapping("/viewAllPendingFeedBacks")
	public ModelAndView recruiterFeedBack() {
		List<Feedback> feedbacks = feedBackservice.getAllFeedBacks(1L);
		ModelAndView mv = new ModelAndView("viewAllFeedBacks");
		mv.addObject("feedbacks",feedbacks);
		return mv;
	}
	
	@GetMapping("/giveFeedBack/{feedbackId}")
	public ModelAndView giveFeedBack(@PathVariable Long feedbackId) {
		ModelAndView mv = new ModelAndView("feedBack");
		mv.addObject("feedbackId",feedbackId);
		return mv;
	}
	
	@GetMapping("/submitFeedBack/{feedbackId}")
	public String submitFeedBack(@RequestParam String comments,@RequestParam String star,@PathVariable Long feedbackId) {
		int rating = Integer.parseInt(star);
		feedBackservice.updateFeedBack(feedbackId,comments,rating);
		return "redirect:/viewAllPendingFeedBacks";
	}
}
