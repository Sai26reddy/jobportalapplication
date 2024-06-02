package com.digit.jobPortalApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digit.jobPortalApplication.model.RecruiterC;

public interface RecruiterCRepository extends JpaRepository<RecruiterC, String> {
public RecruiterC findByfirstName(String firstName);
}
