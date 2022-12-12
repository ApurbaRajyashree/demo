package com.texas.reactcollege.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatus, Object responseBody){
		
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("message",message);
		map.put("status code",httpStatus.value());
		map.put("response data",responseBody);
		
		return new ResponseEntity<Object>(map,httpStatus);
	}
}
