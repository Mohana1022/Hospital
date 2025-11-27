package com.alpha.hospital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.hospital.entity.Patient;
import com.alpha.hospital.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository pr;
	
	public void savepatient(Patient p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	public Optional<Patient> findpatient(int id) {
		// TODO Auto-generated method stub
		
		return pr.findById(id);
	}

}
