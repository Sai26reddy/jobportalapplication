package com.digit.jobPortalApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digit.jobPortalApplication.model.Recruiter;


@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

}
