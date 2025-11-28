package com.alpha.Hospital.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;

@Entity
public class Patient {
@Id
@Positive
	private int id;
@Length(min = 5,max = 10)
    private String name;
    private String disease;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public Patient(int id, String name, String disease) {
		super();
		this.id = id;
		this.name = name;
		this.disease = disease;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", disease=" + disease + "]";
	}
    

	
}
