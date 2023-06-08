package com.mapping.one_to_one.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Student {
	@Id
	private int stdId;
	private String stdName;
	private String stdUSN;

	/*
	 * if we wish to create a foregin key column only for laptop table then specify
	 * reference variable present in laptop table (reference variable of Student class)
	 * 
	 * if we wish to rename/diff name to fk column we can do with help of @JoinColumn
	 * 
	 * when student saved then automatically laptop should also get saved so we use property
	 * called cascade
	 * 
	 * cascade -> if we perform some operation on parent then atuomatically child operations
	 * performed
	 */
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Laptop laptop;

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdUSN() {
		return stdUSN;
	}

	public void setStdUSN(String stdUSN) {
		this.stdUSN = stdUSN;
	}

}
