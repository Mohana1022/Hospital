package com.alpha.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.Hospital.ResponceStructure;
import com.alpha.Hospital.entity.Doctor;
import com.alpha.Hospital.entity.Patient;
import com.alpha.Hospital.service.DoctorService;

import jakarta.validation.Valid;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService ds;
	
	@PostMapping("/savedoctor")
	public void savedoctor(@Valid @RequestBody Doctor d)
	{
		ds.savedoctor(d);
	}
	
	@GetMapping("/finddoctor")
//	public Doctor finddoctor(@RequestParam int id) {
//		return ds.finddoctor(id);
//	}
	
	public ResponceStructure<Doctor> findDoctor(@Valid @RequestParam int id){
		return ds.finddoctor(id);
	}
	
	@PutMapping("/updatedoctor")
	public void updatedoctor(@Valid @RequestParam int id,@Valid @RequestParam String newdname) {
		ds.updatedoctor(id,newdname);
	}
	
	@DeleteMapping("/deletedoctor")
	public void deletedoctor(@Valid @RequestParam int id) {
		
		ds.deletedoctor(id);
		
	}
}
