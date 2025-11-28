package com.alpha.Hospital.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.Hospital.ResponceStructure;
import com.alpha.Hospital.DTO.PatientDTO;
import com.alpha.Hospital.entity.Patient;
import com.alpha.Hospital.exception.PatientNotFoundException;
import com.alpha.Hospital.repository.PatientRepository;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.validation.Valid;

@Service
public class PatientService {

	@Autowired
	private PatientRepository pr;
	
//	public void savepatient(Patient p) {
//		// TODO Auto-generated method stub
//		pr.save(p);
//		
//		
//	}
	
	public void savepatientdto(PatientDTO pdto) {
		// TODO Auto-generated method stub
		Patient p =new Patient();
		p.setName(pdto.getName());
		p.setAge(pdto.getAge());
		p.setDisease(pdto.getDisease());
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

	public ResponceStructure<Patient> updatepatient(int id, String newname) {
		
//		Patient p = pr.findById(id).get();
//		p.setName(newname);
//		pr.save(p);
		
		Patient p = pr.findById(id).orElseThrow(() -> new PatientNotFoundException());
        p.setName(newname);
        pr.save(p);
       
        ResponceStructure<Patient> rs = new ResponceStructure<Patient>();
        rs.setStatuscode(HttpStatus.FOUND.value());
        rs.setMessage("Patient with id " + id + " updated successfully");
        rs.setData(p);
        
        

        return rs;
       
		
	}

	public ResponceStructure<String> deletepatient(int id) {
		
//		pr.deleteById(id);
		
		if (!pr.existsById(id)) {
            throw new PatientNotFoundException();
        }

        pr.deleteById(id);

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setStatuscode(HttpStatus.FOUND.value());
        rs.setMessage("Patient deleted successfully");
        rs.setData("Patient with id " + id + " deleted");

        return rs;
		
		
	}

	
	

	
	

}
