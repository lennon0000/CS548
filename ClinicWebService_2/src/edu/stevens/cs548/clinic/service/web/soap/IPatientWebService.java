package edu.stevens.cs548.clinic.service.web.soap;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.service.dto.PatientDTO;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
@WebService(
//		targetNamespace="http://www.example.org/clinic/wsdl/patient"
		name="IPatientWebPort",
		targetNamespace="http://cs548.stevens.edu/clinic/service/web/soap"
		)
public interface IPatientWebService {


	@WebMethod(operationName="create")
	public long createPatient (String name, Date dob, long patientId, int age) throws PatientServiceExn;
	@WebMethod
	public PatientDTO getPatientByDbId (long id) throws PatientServiceExn;
	@WebMethod
	public PatientDTO getPatientByPatId (long pid) throws PatientServiceExn;
	@WebMethod
	public PatientDTO[] getPatientsByNameDob (String name, Date dob);
	@WebMethod
	public void deletePatient (String name, long id) throws PatientServiceExn;
	@WebMethod
	public String siteInfo();
}
