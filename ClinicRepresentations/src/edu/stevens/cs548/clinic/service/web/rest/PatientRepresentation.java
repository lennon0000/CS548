package edu.stevens.cs548.clinic.service.web.rest;

import java.util.List;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlRootElement;

import edu.stevens.cs548.clinic.domain.PatientFactory;
import edu.stevens.cs548.clinic.service.dto.PatientDTO;
import edu.stevens.cs548.clinic.service.web.rest.data.LinkType;
import edu.stevens.cs548.clinic.service.web.rest.data.PatientType;

@XmlRootElement
public class PatientRepresentation extends PatientType {

	public List<LinkType> getLinksTreatments() {
		return this.getTreatments();
	}
	
	public PatientRepresentation () {
		super();
	}
	
	public static LinkType getPatientLink(long id, UriInfo uriInfo) {
		UriBuilder ub = uriInfo.getBaseUriBuilder();
		ub.path("patient").path("{id}");
		String patientURI = ub.build(Long.toString(id)).toString();

		LinkType link = new LinkType();
		link.setUrl(patientURI);
		link.setRelation(Representation.RELATION_PATIENT);
		link.setMediaType(Representation.MEDIA_TYPE);
		return link;
	}
	
	public PatientRepresentation (PatientDTO dto, UriInfo uriInfo) {
		
		// Tinitialize representation from DTO
		this.id = dto.getId();
		this.patientId = dto.getPatientId();
		this.name = dto.getName();
		this.dob = dto.getBirthday();
		this.age = dto.getAge();
		List<Long> treatments = dto.getTreatments();
		UriBuilder ub = uriInfo.getBaseUriBuilder();
		ub.path("treatment");
		/*
		 * Call getTreatments to initialize empty list.
		 */
		List<LinkType> links = this.getTreatments();
		for(long t: treatments){
			LinkType link = new LinkType();
			UriBuilder ubTreatment = ub.clone().path("{tid}");
			String treatmentURI = ubTreatment.build(Long.toString(t)).toString();
			
			link.setUrl(treatmentURI);
			link.setRelation(Representation.RELATION_TREATMENT);
			link.setMediaType(Representation.MEDIA_TYPE);
			links.add(link);
		}
	}

}
