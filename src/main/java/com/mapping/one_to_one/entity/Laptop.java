package com.mapping.one_to_one.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int lapId;
	private String modelNumber;
	private String lapBrand;
	@OneToOne(mappedBy = "laptop" , cascade = CascadeType.ALL)
	@JoinColumn(name="std_id")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getLapId() {
		return lapId;
	}

	public void setLapId(int lapId) {
		this.lapId = lapId;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getLapBrand() {
		return lapBrand;
	}

	public void setLapBrand(String lapBrand) {
		this.lapBrand = lapBrand;
	}

	

}
