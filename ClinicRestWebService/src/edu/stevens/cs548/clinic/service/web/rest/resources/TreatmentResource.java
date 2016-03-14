package edu.stevens.cs548.clinic.service.web.rest.resources;

import java.net.URI;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import edu.stevens.cs548.clinic.domain.Treatment;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceLocal;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceRemote;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;
import edu.stevens.cs548.clinic.service.web.rest.ProviderRepresentation;
import edu.stevens.cs548.clinic.service.web.rest.TreatmentRepresentation;

@RequestScoped
@Path("treatment")
public class TreatmentResource {
	
//	final static Logger logger = Logger.getLogger(TreatmentResource.class.getCanonicalName());
	@SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public TreatmentResource() {
    }
    
    @EJB(beanName="PatientServiceBean")
    private IPatientServiceLocal patientService;//TODO:PatientService or TreatmentService?
//    private IPatientServiceRemote patientService;
    @GET
    @Path("/site")
    @Produces("application/xml")
    public String getSiteInfo() {
    	return patientService.siteInfo();
    }

    /**
     * Query methods for treatment resources.
     */
    @GET
    @Path("{id}")
    @Produces("application/xml")
    public TreatmentRepresentation getTreatment(@PathParam("id") String id) {
    	long tid = Long.parseLong(id);
		
    	TreatmentDto treatmentDto = patientService.getTreatmentByTid(tid);
		TreatmentRepresentation treatmentRep = new TreatmentRepresentation(treatmentDto,context);
		
		return treatmentRep;
    }
    
    
    @POST
    @Consumes("application/xml")
    public Response addTreatment(TreatmentRepresentation treatmentRep) {
    	
		long id = patientService.createTreatment(treatmentRep.getPatient(),treatmentRep.getProvider(),treatmentRep.getDiagnosis(),treatmentRep.getDrugTreatment(),treatmentRep.getRadiology(),treatmentRep.getSurgery());
		UriBuilder ub = context.getAbsolutePathBuilder().path("{id}");
		URI url = ub.build(Long.toString(id));
		return Response.created(url).build();
    }
}







