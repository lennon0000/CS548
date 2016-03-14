package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DrugTreatment
 *
 */
@Entity
@DiscriminatorValue("D")
//是否需要再指定table名
public class DrugTreatment extends Treatment implements Serializable {


	private static final long serialVersionUID = 1L;
	private String name;
	private float dosage;
	
	/*
	 * TODO: Finish with discriminator.???
	 */
	public DrugTreatment() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getDosage() {
		return dosage;
	}
	public void setDosage(float dosage) {
		this.dosage = dosage;
	}
   
}
