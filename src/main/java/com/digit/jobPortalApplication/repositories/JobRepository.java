package com.digit.jobPortalApplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.Recruiter;

@Repository
public interface JobRepository extends JpaRepository<Job ,Long>{
	@Query(value = "SELECT j.recruiter_id from job j WHERE j.id = ?1",nativeQuery=true)
	public Long getRecruiterIdByJobId(Long id);

	public List<Job> findByRecruiter(Recruiter recruiter);

	
}
