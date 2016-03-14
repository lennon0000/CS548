package edu.stevens.cs548.clinic.service.web.rest;

import java.util.List;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlRootElement;

import edu.stevens.cs548.clinic.service.dto.provider.ProviderDto;
import edu.stevens.cs548.clinic.service.web.rest.data.LinkType;
import edu.stevens.cs548.clinic.service.web.rest.data.ProviderType;

@XmlRootElement
public class ProviderRepresentation extends ProviderType {

	public List<LinkType> getLinksTreatments() {
		return this.getTreatments();
	}
	
	public ProviderRepresentation () {
		super();
	}
	
	public static LinkType getProviderLink(long id, UriInfo uriInfo) {
		UriBuilder ub = uriInfo.getBaseUriBuilder();
		ub.path("provider").path("{id}");
		String providerURI = ub.build(Long.toString(id)).toString();

		LinkType link = new LinkType();
		link.setUrl(providerURI);
		link.setRelation(Representation.RELATION_PROVIDER);//TODO: THIS SHOULD BE PROVIDER NOT PATIENT
		link.setMediaType(Representation.MEDIA_TYPE);
		return link;
	}
	
	public ProviderRepresentation(ProviderDto dto, UriInfo uriInfo) {
		// Tinitialize representation from DTO
		this.id = dto.getProviderId();
		this.familyName = dto.getFamilyName();
		this.givenName = dto.getGivenName();
		this.specialization = dto.getSpecialization();

		List<Long> treatments = dto.getTreatments();
		UriBuilder ub = uriInfo.getBaseUriBuilder();
		ub.path("treatment");
		/*
		 * Call getTreatments to initialize empty list.
		 */
		List<LinkType> links = this.getTreatments();
		for (long t : treatments) {
			LinkType link = new LinkType();
			UriBuilder ubTreatment = ub.clone().path("{tid}");
			String treatmentURI = ubTreatment.build(Long.toString(t))
					.toString();

			link.setUrl(treatmentURI);
			link.setRelation(Representation.RELATION_TREATMENT);
			link.setMediaType(Representation.MEDIA_TYPE);
			links.add(link);
		}
	}

}
