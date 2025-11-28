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
import com.alpha.Hospital.entity.Patient;
import com.alpha.Hospital.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService ps;
	
	@PostMapping("/savepatient")
	public void savepatient(@RequestBody Patient p) {
		ps.savepatient(p);
	}
	
//	@GetMapping("/findpatient")
//	public void findpatient(@RequestParam int id) {
//		ps.findpatient(id);
//	}
	
	@GetMapping("/findpatient")
	public ResponceStructure<Patient> findpatient(@RequestParam int id){
		return ps.findpatient(id);
	}
 
	@PutMapping("/updatepatient")
	public void updatepatient(@RequestParam int id, @RequestParam String newname) {
		ps.updatepatient(id,newname);
	}
	
	@DeleteMapping("/deletepatient")
	public void deletepatient(@RequestParam int id) {
		
		ps.deletepatient(id);
		
	}
	
}
