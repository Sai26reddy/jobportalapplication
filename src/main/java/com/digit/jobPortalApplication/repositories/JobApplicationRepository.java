package com.digit.jobPortalApplication.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digit.jobPortalApplication.model.FreeLancer;
import com.digit.jobPortalApplication.model.Job;
import com.digit.jobPortalApplication.model.JobApplication;


@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{
	@Query(value = "SELECT j.job_id from job_application j WHERE freelancer_id = ?1",nativeQuery=true)
	public List<Long> getJobIdByFreeLancerId(Long id);

	@Query(value="SELECT j.freelancer_id from job_application j where job_id=?1",nativeQuery=true)
	public List<Long> getFreeLancerIdByJobId(Long id);
	
	@Query(value="SELECT * from job_application where job_id=?1 and freelancer_id=?2",nativeQuery=true)
	public JobApplication findByJobId(Long jobId,Long freelancer_id); 
	
	@Query(value="SELECT j.freelancer_id from job_application j WHERE j.id =?1",nativeQuery=true)
	public List<Long> getFreeLancerIdByJobApplicationId(Long id);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="update job_application set freelancer_id=42 where id=?1",nativeQuery=true)
	public void setflid(Long id);

	public List<JobApplication> findByFreeLancer(FreeLancer freeLancer);

	public List<JobApplication> findByJob(Job job);

}
