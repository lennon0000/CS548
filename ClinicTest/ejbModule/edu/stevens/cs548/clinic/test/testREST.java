package edu.stevens.cs548.clinic.test;

import java.util.Calendar;
import java.util.Date;

import edu.stevens.cs548.clinic.service.web.rest.PatientRepresentation;
import edu.stevens.cs548.clinic.service.web.rest.ProviderRepresentation;
import edu.stevens.cs548.clinic.service.web.rest.Representation;
import edu.stevens.cs548.clinic.service.web.rest.data.LinkType;
import edu.stevens.cs548.clinic.service.web.rest.resources.PatientResource;
import edu.stevens.cs548.clinic.service.web.rest.resources.ProviderResource;

public class testREST {

	public static void main(String[] args) {
		PatientResource patientResource = new PatientResource();
		ProviderResource providerResource = new ProviderResource();
		PatientRepresentation prep = new PatientRepresentation();
		LinkType linka = new LinkType();

		linka.setRelation(Representation.RELATION_PATIENT);
		linka.setMediaType(Representation.MEDIA_TYPE);
		linka.setUrl("http://clinic/resources/patient/1");
		prep.setId(1);
		prep.setPatientId(11);
		prep.setName("Zhangsan");
		
		Calendar lastDate = Calendar.getInstance(); 
    	lastDate.set(2004, 11, 7);
    	Date dob = lastDate.getTime();
		prep.setDob(dob);
		prep.setAge(10);
		
		patientResource.addPatient(prep);
//		info("Add patient succeed: id = "+patientResource.getPid().getUrl().toString());
		
		ProviderRepresentation pvrep = new ProviderRepresentation();
		pvrep.setFamilyName("Wang");
		pvrep.setGivenName("Wu");
		LinkType link = new LinkType();
		link.setRelation(Representation.RELATION_PROVIDER);
		link.setMediaType(Representation.MEDIA_TYPE);
		link.setUrl("http://clinic/resources/provider/9");
		pvrep.setId(9);
		providerResource.addProvider(pvrep);
//		info("Add provider succeed: NPI = "+providerResource.getNpi().getUrl().toString());
		
		
	}
	
}


