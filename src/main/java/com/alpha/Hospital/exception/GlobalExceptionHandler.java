package com.alpha.Hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.Hospital.ResponceStructure;

@RestControllerAdvice 
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponceStructure<String> PatientNotFoundHandler(PatientNotFoundException ex) {
		ResponceStructure<String> rs2 = new ResponceStructure<String>();
		
		rs2.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs2.setMessage("Patient not found ");
		rs2.setData("Patient not found");
		
		return rs2;
		
	}
	
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponceStructure<String> DoctorNotFoundHandler(DoctorNotFoundException ex) {
		ResponceStructure<String> rs1 = new ResponceStructure<String>();
		
		rs1.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs1.setMessage("Doctor not found ");
		rs1.setData("Doctor not found");
		
		return rs1;
		
	}
	
	
		
	
	

}
