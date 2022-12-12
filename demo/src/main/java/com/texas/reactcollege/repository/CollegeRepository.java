package com.texas.reactcollege.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texas.reactcollege.models.College;


@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
	
	public College findByCollegeid(long collegeid);
}
