package com.texas.reactcollege.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.texas.reactcollege.models.College;
import com.texas.reactcollege.response.ResponseHandler;
import com.texas.reactcollege.services.CollegeService;


@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	//Application properties wala part
	@Value("${user.texas}")
	private String userTexas;
	
	@Value("${password.texas}")
	private String passwordTexas;
	
	@GetMapping("/getProfile")
	public String getProfile(){
		return userTexas + "," + passwordTexas;
	}
	
	@GetMapping("/colleges")
	public ResponseEntity<Object> getColleges() {
		try {
			List<College> lstCollege=collegeService.getColleges();
			return ResponseHandler.generateResponse("Sucessfully Retrived", HttpStatus.OK, lstCollege);
		}catch(Exception e) {
			
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}		
	}
	
	
	@GetMapping("/colleges/{collegeid}")
	public ResponseEntity<Object> getCollege(@PathVariable("collegeid") String collegeid)
	{
		try {
			College college=collegeService.getCollege(Long.parseLong(collegeid));
			return ResponseHandler.generateResponse("Sucessfully Retrived", HttpStatus.OK, college);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
	
	@PostMapping("/colleges")
	public   ResponseEntity<Object> addCollege(@RequestBody College college) {	
		try {
			String message=collegeService.addCollege(college);
			return ResponseHandler.generateResponse("Sucessfully Added", HttpStatus.CREATED, message);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
				
	}
	
	@DeleteMapping("/colleges")  
	public ResponseEntity<Object> deleteCollege(@RequestParam("collegeid") String collegeid) {
		try {
			String message=collegeService.deleteCollege(Long.parseLong(collegeid));
			return ResponseHandler.generateResponse("Sucessfully Deleted", HttpStatus.OK, message);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
				
	}
	
	@PutMapping("/colleges/{collegeid}")
	public ResponseEntity<Object> updateCollege(@PathVariable("collegeid")String collegeid,@RequestBody College college) {
		try {
			College rescollege=collegeService.updateCollege(Long.valueOf(collegeid),college);
			return ResponseHandler.generateResponse("Sucessfully Updated", HttpStatus.CREATED, rescollege);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
				
	}
	
	
	
	
	
	
	
	
}


