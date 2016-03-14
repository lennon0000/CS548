/**
 * PatientWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.stevens.cs548.clinic.service.web.soap;

import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.service.dto.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.TreatmentNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceRemote;

@WebService(
		endpointInterface="edu.stevens.cs548.clinic.service.web.soap.IPatientWebService",
		serviceName = "PatientWeb",
		portName="PatientPort"
		)
public class PatientWebService {
//implements IPatientWebService{
	@EJB(beanName="PatientServiceBean")
	IPatientServiceRemote patientService;
	public long createPatient(String name, Date dob, long patientId, int age)
			throws PatientServiceExn {
		return patientService.createPatient(name, dob, patientId, age);
	}
	public PatientDTO getPatientByDbId(long id) throws PatientServiceExn {
		return patientService.getPatientByDbId(id);
	}

	public PatientDTO getPatientByPatId(long pid) throws PatientServiceExn {
		return patientService.getPatientByPatId(pid);
	}

	public PatientDTO[] getPatientsByNameDob(String name, Date dob) {
		return patientService.getPatientsByNameDob(name, dob);
	}

	public void deletePatient(String name, long id) throws PatientServiceExn {
		patientService.deletePatient(name, id);
		
	}


	@Resource(name="SiteInfo")
	private String siteInformation;
	public String siteInfo() {
		return siteInformation;
	}

}
