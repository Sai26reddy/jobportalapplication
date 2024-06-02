package com.digit.jobPortalApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.digit.jobPortalApplication.service.SkillService;

@Controller
public class SkillController {
	@Autowired
	SkillService service;
}
