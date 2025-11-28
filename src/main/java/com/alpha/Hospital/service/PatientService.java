package com.alpha.Hospital.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.ResponceStructure;
import com.alpha.Hospital.entity.Patient;
import com.alpha.Hospital.exception.PatientNotFoundException;
import com.alpha.Hospital.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository pr;
	
	public void savepatient(Patient p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	public ResponceStructure<Patient> findpatient(int id) {
		// TODO Auto-generated method stub
		
		Patient p = pr.findById(id).orElseThrow(()->new PatientNotFoundException());
        ResponceStructure<Patient> rs = new ResponceStructure<Patient>();
		
		rs.setStatuscode(HttpStatus.FOUND.value());
		rs.setMessage("Patient with id  " +id + "Found");
		rs.setData(p);
		
		return rs;
	}

	public void updatepatient(int id, String newname) {
		
		Patient p = pr.findById(id).get();
		
		p.setName(newname);
		
		pr.save(p);
		
	}

	public void deletepatient(int id) {
		
		
		pr.deleteById(id);
		
	}

	
	

}
