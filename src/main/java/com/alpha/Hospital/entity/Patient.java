package com.alpha.Hospital.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;

@Entity
public class Patient {
@Id
//@Positive
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//@Length(min = 5,max = 10)
    private String name;
    private int age;
    private String disease;
    private String bgroup;
    private int bp;
    private int sugarLevel;
    
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getBgroup() {
		return bgroup;
	}
	public void setBgroup(String bgroup) {
		this.bgroup = bgroup;
	}
	public int getBp() {
		return bp;
	}
	public void setBp(int bp) {
		this.bp = bp;
	}
	public int getSugarLevel() {
		return sugarLevel;
	}
	public void setSugarLevel(int sugarLevel) {
		this.sugarLevel = sugarLevel;
	}
	public Patient(String name, int age, String disease, String bgroup, int bp, int sugarLevel) {
		super();
		this.name = name;
		this.age = age;
		this.disease = disease;
		this.bgroup = bgroup;
		this.bp = bp;
		this.sugarLevel = sugarLevel;
	}
	public Patient() {
		super();
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", disease=" + disease + ", bgroup=" + bgroup
				+ ", bp=" + bp + ", sugarLevel=" + sugarLevel + "]";
	}
    
    
	
}
