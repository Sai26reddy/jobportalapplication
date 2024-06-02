package com.digit.jobPortalApplication.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Skill;
import com.digit.jobPortalApplication.model.SkillExperience;
import com.digit.jobPortalApplication.repositories.SkillExperienceRepository;
import com.digit.jobPortalApplication.serviceInterface.SkillExperienceServiceInteface;

@Service
public class SkillExperienceService implements SkillExperienceServiceInteface{
	@Autowired
	SkillExperienceRepository skillExperienceRepository;
	
//	public void addSkillExperience(FreeLancer freeLancer, SkillExperience skillExperience) {
//		SkillExperience skill = skillExperience;
//		skill.setFreeLancer(freeLancer);
//		skill.setSkill(skillExperience.getSkill());
//		skill.setYears(skillExperience.getYears());
//		skillsExperienceRepository.save(skill);
//	}

	public void deleteSkillExperience(Long id) {
		skillExperienceRepository.deleteById(id);
	}

	public void addSkillExperience(FreeLancer freeLancer, String skillName, String description, int experience) {
		SkillExperience skillExperience = new SkillExperience();
		Skill skill = new Skill();
		skill.setDescription(description);
		skill.setName(skillName);
		skillExperience.setSkill(skill);
		skillExperience.setYears(experience);
		skillExperience.setFreeLancer(freeLancer);
		skillExperienceRepository.save(skillExperience);
		
	}
	
	
}
