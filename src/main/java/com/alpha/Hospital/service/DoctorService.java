package com.alpha.Hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.ResponceStructure;
import com.alpha.Hospital.entity.Doctor;
import com.alpha.Hospital.entity.Patient;
import com.alpha.Hospital.exception.DoctorNotFoundException;
import com.alpha.Hospital.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository dr;
	
	public void savedoctor(Doctor d) {
		// TODO Auto-generated method stub
		dr.save(d);
	}

	public ResponceStructure<Doctor> finddoctor(int id) {
		// TODO Auto-generated method stub
		Doctor d = dr.findById(id).orElseThrow(()->new DoctorNotFoundException());
		 ResponceStructure<Doctor> rs = new ResponceStructure<Doctor>();
			
			rs.setStatuscode(HttpStatus.FOUND.value());
			rs.setMessage("Doctor with id  " +id + "Found");
			rs.setData(d);
			
			return rs;
	}

	public void updatedoctor(int id, String newdname) {
		
		Doctor  d= dr.findById(id).get();
		
		d.setName(newdname);
		
		dr.save(d);
		
	}

	public void deletedoctor(int id) {
		
		dr.deleteById(id);
		
	}

}
