package com.digit.jobPortalApplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.SkillExperience;



@Repository
public interface SkillExperienceRepository extends JpaRepository<SkillExperience, Long>{

	List<SkillExperience> findByFreeLancer(FreeLancer freeLancer);
	
}
