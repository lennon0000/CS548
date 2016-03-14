package edu.stevens.cs548.clinic.service.web.rest.resources;

import java.net.URI;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
import javax.xml.bind.DatatypeConverter;

import edu.stevens.cs548.clinic.service.dto.PatientDTO;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceLocal;
import edu.stevens.cs548.clinic.service.web.rest.PatientRepresentation;

@RequestScoped
@Path("patient")
public class PatientResource {
	
//	final static Logger logger = Logger.getLogger(PatientResource.class.getCanonicalName());
	@SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public PatientResource() {
    }
    
    @EJB(beanName="PatientServiceBean")
    private IPatientServiceLocal patientService;
//    private IPatientServiceRemote patientService;
    @GET
    @Path("/site")
    @Produces("application/xml")
    public String getSiteInfo() {
    	return patientService.siteInfo();
    }

    /**
     * Query methods for patient resources.
     */
    @GET
    @Path("{id}")
    @Produces("application/xml")
    public PatientRepresentation getPatient(@PathParam("id") String id) {
    	try {
    		long key = Long.parseLong(id);
    		PatientDTO patientDTO = patientService.getPatientByDbId(key);    		
    		//return patient representation;
    		
    		PatientRepresentation patientRep = new PatientRepresentation(patientDTO,context);
    		return patientRep;
    	} catch (PatientServiceExn e) {
    		throw new WebApplicationException();
    	}
    }
    
    
    
    @GET
    @Produces("application/xml")
    public PatientRepresentation[] getPatientByNameDob(@QueryParam("name") String name,@QueryParam("dob") String dob){//this 'id' is in query
    	Date birthDate = DatatypeConverter.parseDate(dob).getTime();
		PatientDTO[] patientDTOs = patientService.getPatientsByNameDob(name, birthDate);    		
		//return patient representation;
		PatientRepresentation[] patientReps = new PatientRepresentation[patientDTOs.length];
		for(int i = 0; i<patientDTOs.length;i++){
			patientReps[i] = new PatientRepresentation(patientDTOs[i],context);
		}
		return patientReps;
    }
    
    
    @POST
    @Consumes("application/xml")
    public Response addPatient(PatientRepresentation patientRep) {
    	try {
    		long id = patientService.createPatient(patientRep.getName(), patientRep.getDob(), patientRep.getPatientId(), patientRep.getAge());
    		
    		UriBuilder ub = context.getAbsolutePathBuilder().path("{id}");
    		URI url = ub.build(Long.toString(id));
    		return Response.created(url).build();
    	} catch (PatientServiceExn e) {
    		throw new WebApplicationException();
    	}
    }
    
    
    @GET
    @Path("/patientId")
    @Produces("application/xml")
    public PatientRepresentation getPatientByPatientId(@QueryParam("id") String patientId){//this 'id' is in query
    	try {
    		long pid = Long.parseLong(patientId);
    		PatientDTO patientDTO = patientService.getPatientByPatId(pid);    		
    		//return patient representation;
    		PatientRepresentation patientRep = new PatientRepresentation(patientDTO,context);
    		return patientRep;
    	} catch (PatientServiceExn e) {
    		throw new WebApplicationException();
    	}
    }
}







