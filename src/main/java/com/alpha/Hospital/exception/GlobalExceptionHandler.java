package com.alpha.Hospital.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.Hospital.ResponceStructure;

@RestControllerAdvice 
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponceStructure<String> PatientNotFoundHandler(PatientNotFoundException ex) {
		ResponceStructure<String> rs1 = new ResponceStructure<String>();
		
		rs1.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs1.setMessage("Patient not found ");
		rs1.setData("Patient not found");
		
		return rs1;
		
	}
	
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponceStructure<String> DoctorNotFoundHandler(DoctorNotFoundException ex) {
		ResponceStructure<String> rs2 = new ResponceStructure<String>();
		
		rs2.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs2.setMessage("Doctor not found ");
		rs2.setData("Doctor not found");
	
		return rs2;
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponceStructure <Map<String,String> >MethodArgumentNotValid(MethodArgumentNotValidException ex) {
		
		
		Map<String,String> errormap = new HashMap<String, String>();
		List<ObjectError> objerror =  ex.getAllErrors();
		
		for (ObjectError objectError : objerror) {
			System.out.println(objectError.getDefaultMessage());
			
			FieldError fr = (FieldError)objectError;
			System.out.println(fr.getField());
			
			errormap.put(fr.getField(), objectError.getDefaultMessage());
		}
		ResponceStructure<Map<String, String>> rs3 = new ResponceStructure<Map<String, String>>();
		rs3.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());
		rs3.setMessage("Validation Failed ");
		rs3.setData(errormap);
	
		return rs3;
		
	}
		
	
	

}
