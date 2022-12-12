package com.texas.reactcollege.services;

import java.util.List;
import com.texas.reactcollege.models.College;

public interface CollegeService {
	
	public List<College> getColleges();
	
	public College getCollege(Long collegeid);
	
	public String addCollege(College college);
	
	public String deleteCollege(Long collegeid);
	
	public College updateCollege(Long collegeid, College college);
	
	

	
	
}
