package com.digit.jobPortalApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digit.jobPortalApplication.model.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
