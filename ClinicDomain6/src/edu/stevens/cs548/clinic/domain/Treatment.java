package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Treatment
 *
 */
@Entity
@Table(name="TREATMENT")

public class Treatment implements Serializable {

	//用的什么连接方式？如果是单表连接，则是不是只是这样设置就ok？？单表连接是否需要设置oneToMany
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	private String diagnosis;
	@ManyToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "provider_npi", referencedColumnName = "npi")
	private Provider provider;
	@Column(name="TTYPE",length=2)
	private String treatmentType;
	public String getTreatmentType() {
		return treatmentType;
	}

	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Patient getPatient() {
		/*
		 * TODO: return backward reference to patient.???
		 */
		return patient;
	}

	public void setPatient(Patient patient) {
		/*
		 * TODO: patch forward and backward references, where necessary???
		 */
		this.patient = patient;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Treatment() {
		super();
	}
   
}
