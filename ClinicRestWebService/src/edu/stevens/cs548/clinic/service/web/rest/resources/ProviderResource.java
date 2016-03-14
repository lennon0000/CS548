package edu.stevens.cs548.clinic.service.web.rest.resources;

import java.net.URI;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import edu.stevens.cs548.clinic.domain.Patient;
import edu.stevens.cs548.clinic.service.dto.provider.ProviderDto;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderServiceLocal;
import edu.stevens.cs548.clinic.service.web.rest.ProviderRepresentation;
import edu.stevens.cs548.clinic.service.web.rest.TreatmentRepresentation;

@RequestScoped
@Path("provider")
public class ProviderResource {
	
//	final static Logger logger = Logger.getLogger(ProviderResource.class.getCanonicalName());
	@SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public ProviderResource() {
    }
    
    @EJB(beanName="ProviderServiceBean")
    private IProviderServiceLocal providerService;
//    private IProviderServiceRemote providerService;
    @GET
    @Path("/site")
    @Produces("application/xml")
    public String getSiteInfo() {
    	return providerService.siteInfo();
    }

    /**
     * Query methods for provider resources.
     */
    @GET
    @Path("/byNPI/")
    @Produces("application/xml")
          
    public ProviderRepresentation getProvider(@QueryParam("npi") String id) {
    	try {
    		long key = Long.parseLong(id);
    		ProviderDto providerDto = providerService.getProviderByNpi(key);
    		
    		ProviderRepresentation providerRep = new ProviderRepresentation(providerDto,context);
    		return providerRep;
    	} catch (ProviderServiceExn e) {
    		throw new WebApplicationException();
    	}
    }
    
    
    
    @POST
    @Consumes("application/xml")
    public Response addProvider(ProviderRepresentation providerRep) {
    	
		try {
			long id = providerService.createProvider(providerRep.getId(), providerRep.getGivenName(), providerRep.getFamilyName(), providerRep.getSpecialization());
			UriBuilder ub = context.getAbsolutePathBuilder().path("{id}");
			URI url = ub.build(Long.toString(id));
			return Response.created(url).build();
		} catch (ProviderServiceExn e) {
			throw new WebApplicationException(e.toString());
		}
    }
    
//    @GET
//    @Path("/{id}/treatments")
//    @Produces("application/xml")
//    public TreatmentRepresentation[] getTreatRepURIs(@HeaderParam("X-Patient") String url,@PathParam("id") String id) {
//    	String[] url2 = url.split("patient/");
//		String patientId = url2[1];
//    	long pid = Long.parseLong(patientId);
//		long npi = Long.parseLong(id);
//		TreatmentDto[] treatmentDtos = providerService.getTreatmentsByPat(pid,npi);
//		
//		TreatmentRepresentation[] treatmentReps = new TreatmentRepresentation[treatmentDtos.length];
//		for(int i = 0; i < treatmentDtos.length; i++){
//			treatmentReps[i] = new TreatmentRepresentation(treatmentDtos[i],context);
//		}
//		return treatmentReps;
//    }


    @GET
    @Path("/{id}/treatments")
    @Produces("application/xml")
    public TreatmentRepresentation[] getTreatRepURIs(@HeaderParam("X-Patient") String url,@PathParam("id") String id) {
    	String[] url2 = url.split("patient/");
		String patientId = url2[1];
    	long pid = Long.parseLong(patientId);
		long npi = Long.parseLong(id);
		TreatmentDto[] treatmentDtos = providerService.getTreatmentsByPat(pid,npi);
		
		TreatmentRepresentation[] treatmentReps = new TreatmentRepresentation[treatmentDtos.length];
		for(int i = 0; i < treatmentDtos.length; i++){
			treatmentReps[i] = new TreatmentRepresentation(treatmentDtos[i],context);
		}
		return treatmentReps;
    }
}







