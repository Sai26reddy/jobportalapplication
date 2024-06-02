package com.digit.jobPortalApplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digit.jobPortalApplication.model.BookMarkJob;
import com.digit.jobPortalApplication.model.FreeLancer;

@Repository
public interface BookMarkJobRepository extends JpaRepository<BookMarkJob, Long>{

	List<BookMarkJob> findByFreeLancer(FreeLancer freeLancer);

}
