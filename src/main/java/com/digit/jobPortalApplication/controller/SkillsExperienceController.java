package com.digit.jobPortalApplication.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digit.jobPortalApplication.exceptionHandling.NoFreeLancerIdExistsException;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.SkillExperience;
import com.digit.jobPortalApplication.service.FreeLancerService;
import com.digit.jobPortalApplication.service.SkillExperienceService;
import com.digit.jobPortalApplication.service.SkillService;

@Controller
public class SkillsExperienceController {
	@Autowired
	SkillExperienceService service;
	@Autowired
	FreeLancerService freeLancerService;
	
	@GetMapping("/addSkillExperience")
	public ModelAndView addSkillExperience() {
		ModelAndView mv = new ModelAndView("addSkillPage");
		mv.addObject("addSkill",new SkillExperience());
		return mv;
	}
	
	
	@GetMapping("/deleteSkillExperience/{id}")
	public String deleteSkillExperience(@PathVariable Long id) throws NoFreeLancerIdExistsException {
		service.deleteSkillExperience(id);
		return "redirect:/profile";
	}
	
	@PostMapping("/updateSkillExperience")
	public String updateSkillExperience(@RequestParam String skillName,@RequestParam String description,@RequestParam int experience, HttpSession session) throws NoFreeLancerIdExistsException {
		FreeLancer freeLancer = (FreeLancer) session.getAttribute("freeLancer");
		service.addSkillExperience(freeLancer,skillName,description,experience);
		return "redirect:/profile";
	}
}
