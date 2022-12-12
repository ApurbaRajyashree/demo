package com.texas.reactcollege.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.reactcollege.models.College;
import com.texas.reactcollege.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	
	@Override
	public List<College> getColleges(){
		return collegeRepository.findAll();
	}


	@Override
	public College getCollege(Long collegeid) {
		
		
		return collegeRepository.findByCollegeid(collegeid);	
	}


	@Override
	public String addCollege(College college) {
		collegeRepository.save(college);
		return "data addedd successfully";
	}


	@Override
	public String deleteCollege(Long collegeid) {
		collegeRepository.deleteById(collegeid);
		return "data deleted successfully";
	}

	@Override
	public College updateCollege(Long collegeid, College college) {
			
		return collegeRepository.saveAndFlush(college);
		
	}


	
	
}
