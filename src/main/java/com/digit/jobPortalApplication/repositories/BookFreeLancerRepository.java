package com.digit.jobPortalApplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digit.jobPortalApplication.model.BookMarkFreeLancer;
import com.digit.jobPortalApplication.model.Recruiter;


@Repository
public interface BookFreeLancerRepository extends JpaRepository<BookMarkFreeLancer, Long>{

	List<BookMarkFreeLancer> findByRecruiter(Recruiter recruiter);
	
}
