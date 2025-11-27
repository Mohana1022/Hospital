package com.alpha.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.entity.Doctor;
import com.alpha.Hospital.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository dr;
	
	public void savedoctor(Doctor d) {
		// TODO Auto-generated method stub
		dr.save(d);
	}

	public Doctor finddoctor(int id) {
		// TODO Auto-generated method stub
		return dr.findById(id).get();
	}

}
