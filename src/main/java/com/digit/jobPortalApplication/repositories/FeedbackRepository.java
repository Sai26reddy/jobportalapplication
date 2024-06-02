package com.digit.jobPortalApplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digit.jobPortalApplication.model.Feedback;
import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Recruiter;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
	List<Feedback> findByRecruiter(Recruiter recruiter);

	List<Feedback> findByFreeLancer(FreeLancer freeLancer);
	
}
