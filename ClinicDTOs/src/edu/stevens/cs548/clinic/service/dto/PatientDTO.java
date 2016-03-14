package edu.stevens.cs548.clinic.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import edu.stevens.cs548.clinic.domain.Patient;
@XmlRootElement(name = "patient-dto",namespace = "http://www.example.org/schemas/clinic/patient")//TODO:这里更改为自己的
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientDTO {
	public long id;
	@XmlElement(name = "patient-id")
	public long patientId; 
	@XmlElement(required=true)
	public String name;
	
	@XmlElement(required=true)
	public int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@XmlElement(required=true,name = "dob")
	public Date birthday;
	public List<Long> treatments;
	public PatientDTO() {};
	public PatientDTO (Patient patient){
		this.id = patient.getId();
		this.patientId = patient.getPatientId();
		this.name = patient.getName();
		this.birthday = patient.getBirthDate();
		this.age = patient.getAge();
		List<Long> tids =  patient.getTreatmentIds();
		this.treatments = new ArrayList<Long>();
		for(int i = 0; i<patient.getTreatmentIds().size();i++){
			this.getTreatments().add(patient.getTreatmentIds().get(i));
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public List<Long> getTreatments() {
		return treatments;
	}
	public void setTreatments(List<Long> treatments) {
		this.treatments = treatments;
	}
	
}
