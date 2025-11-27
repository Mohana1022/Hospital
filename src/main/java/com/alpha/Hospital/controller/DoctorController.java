package com.alpha.Hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.Hospital.entity.Doctor;
import com.alpha.Hospital.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService ds;
	
	@PostMapping("/savedoctor")
	public void savedoctor(@RequestBody Doctor d)
	{
		ds.savedoctor(d);
	}
	
	@GetMapping("/finddoctor")
	public Doctor finddoctor(@RequestParam int id) {
		return ds.finddoctor(id);
	}
}
