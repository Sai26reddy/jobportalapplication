package com.digit.jobPortalApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Skill;
import com.digit.jobPortalApplication.repositories.SkillRepository;
import com.digit.jobPortalApplication.serviceInterface.SkillServiceInterface;

@Service
public class SkillService implements SkillServiceInterface{
	@Autowired
	SkillRepository skillRepository;
	public void create(Skill skill) {
		skillRepository.save(skill);
	}
	
	public Skill save(String skillDescription, String skillName) {
	
		 Skill skill=new Skill();
			skill.setDescription(skillDescription);
			skill.setName(skillName);
			skillRepository.save(skill);
			return skill;
	}
}
