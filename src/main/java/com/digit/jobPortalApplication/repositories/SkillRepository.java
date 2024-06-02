package com.digit.jobPortalApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digit.jobPortalApplication.model.Skill;


@Repository
public interface SkillRepository extends JpaRepository<Skill, Long>{

}
