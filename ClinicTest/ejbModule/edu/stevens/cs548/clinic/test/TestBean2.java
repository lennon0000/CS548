package edu.stevens.cs548.clinic.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceLocal;
import edu.stevens.cs548.clinic.service.ejb.IProviderServiceLocal;


/**
 * Session Bean implementation class TestBean
 */
@Singleton
@LocalBean
@Startup
public class TestBean2 {

	private static Logger logger = Logger.getLogger(TestBean2.class.getCanonicalName());
    private static void info(String m){
    	logger.info(m);
    }

    private String InputFileName = "<stdin>";
    
    private BufferedReader InputFile = new BufferedReader(new InputStreamReader(System.in));
    
    private String OutputFileName;
    
    private PrintWriter OutputFile = new PrintWriter(new OutputStreamWriter(System.out));
    
    private URL endpiintUrl = null;
    
    
    
    public TestBean2() {}
    
	@EJB(beanName = "PatientServiceBean")
	// 这里是在patientService中对应的‘@Stateless(name="PatientServiceBean")’
	private IPatientServiceLocal patService;
	@EJB(beanName = "ProviderServiceBean")
	// 这里是在patientService中对应的‘@Stateless(name="PatientServiceBean")’
	private IProviderServiceLocal proService;
	
    
    @PostConstruct
    public void init() {   // ---------1--------service test  add patient ---checked
    	
    	info("Initializing the service.");
    	
    	
    	Calendar lastDate = Calendar.getInstance(); 
    	lastDate.set(1993, 10, 25);
    	Date dob = lastDate.getTime();
    	
    	try {
			long id = patService.createPatient("Zhusan", dob, 444444, 21);
			System.out.println("Patient is created, and patient id is:"+id);
		} catch (PatientServiceExn e) {
			e.printStackTrace();
		}
    }
    
	
//  @PostConstruct
//  public void init() {   //  ------------2------------ service test get patient by name and dob----checked
//  	
//  	info("Initializing the service.");
//  	
//  	
//  	String name = "Zhaoliu";
//  	Calendar lastDate = Calendar.getInstance(); 
//  	lastDate.set(1993, 10, 25);
//  	Date dob = lastDate.getTime();
//  	
//  	PatientDTO[] ps = patService.getPatientsByNameDob(name, dob);
//  	for (PatientDTO p : ps) {
//  		System.out.println("patient's DbId:"+p.id);
//			System.out.println("patient's id:"+p.patientId);
//			System.out.println("patient's name:"+p.name);
//			System.out.println("patient's dob:"+p.birthday);
//		}
//  }
	
	
  
//  @PostConstruct
//  public void init() {   // ----------3----------  service test get patient by patientId----checked
//  	
//  	info("Initializing the service.");
//  	long pid = 333333;
//  	
//  	PatientDTO p = new PatientDTO();
//		try {
//			p = patService.getPatientByPatId(pid);
//		} catch (PatientServiceExn e) {
//			e.printStackTrace();
//		}
//		System.out.println("patient's DbId:"+p.id);
//		System.out.println("patient's id:"+p.patientId);
//		System.out.println("patient's name:"+p.name);
//		System.out.println("patient's dob:"+p.birthday);
//  }
  
  
//	@PostConstruct
//	public void init() {   //  ------------4----------get patient by primary key  checked
//	
//	info("Initializing the service.");
//	
//	
//	long dbId = 51;
//	PatientDTO p = new PatientDTO();
//		try {
//			p = patService.getPatientByDbId(dbId);
//			System.out.println("patient's DbId:"+p.getId());
//	    	System.out.println("patient's id:"+p.getPatientId());
//	    	System.out.println("patient's name:"+p.getName());
//	    	System.out.println("patient's dob:"+p.getBirthday());
//		} catch (PatientServiceExn e) {
//			e.printStackTrace();
//		}
//	}
  
//	@PostConstruct
//	public void init() {   //  ---------5--------delete patient--checked
//		
//		info("Initializing the service.");
//		
//		try {
//			patService.deletePatient("Zhaoliu", 201);
//			info("patient is deleted! ");
//		} catch (PatientServiceExn e) {
//			e.printStackTrace();
//		}
//	}
  
//	@PostConstruct
//	public void init() {   //  ---------6--------obtaining TreatmentDtos
//		
//		info("Initializing the service.");
//		long patientKey = 51;
//		try {
//			List<TreatmentDto> tds = patService.getTreatments(patientKey);
//			for(TreatmentDto t : tds){
//				System.out.println("Treatment Id: "+t.getId());
//				System.out.println("Diagnosis : "+t.getDiagnosis());
//				System.out.println("Provider NPI: "+t.getProviderId());
//			}
//		} catch (PatientServiceExn e) {
//			e.printStackTrace();
//		}
//		
//	}
  
  
//	@PostConstruct
//	public void init() { // ------------1-----------service test add provider----checked
//
//		info("Initializing the service.");
//		
//		try {
//			proService.createProvider(777777, "yisheng", "Qian", "surgeon");
//			System.out.println("provider is saved!");
//		} catch (ProviderServiceExn e) {
//			e.printStackTrace();
//		}
//	}
  
	
//  @PostConstruct
//	public void init() { // ------------2-----------service test get provider by GivenName-----checked
//
//		info("Initializing the service.");
//
//		String givenName = "yisheng";
//		ProviderDto[] provs;
//		try {
//			provs = proService.getProviderByGivenName(givenName);
//			for (ProviderDto p : provs) {
//				info("provider's NPI:"+p.getProviderId());
//		    	info("provider's GivenName:"+p.getGivenName());
//		    	info("provider's FamilyName:"+p.getFamilyName());
//		    	info("provider's Spce:"+p.getSpecialization());
//			}
//		} catch (ProviderServiceExn e) {
//			e.printStackTrace();
//		}
//	}
	
  
//  @PostConstruct
//	public void init() { // ---------------3-----------------service test get provider by NPI------checked
//
//		info("Initializing the service.");
//		ProviderDto pd;
//		try {
//			pd = proService.getProviderByNpi(888888);
//			System.out.println("provider's NPI:"+pd.getProviderId());
//	    	System.out.println("provider's GivenName:"+pd.getGivenName());
//	    	System.out.println("provider's FamilyName:"+pd.getFamilyName());
//	    	System.out.println("provider's Spce:"+pd.getSpecialization());
//		} catch (ProviderServiceExn e) {
//			e.printStackTrace();
//		}
//	}
  
//	 @PostConstruct
//	 public void init() { // -------------4------------add treatment----checked
//	
//	 info("Initializing the service.");
//	
//		 try {
////			 DrugTreatmentType d = new DrugTreatmentType();
////			 d.setDosage((float) 11.22);
////			 d.setName("drug of cold");
////			 TreatmentDto td = new TreatmentDto();
////			 td.setDiagnosis("cold");
////			 td.setDrugTreatment(d);
////			 td.setProviderId(888888);
////			 long pid = 222222;
////			 proService.addTreatmemt(td,pid);
//			 proService.addDrugTreatment(888888, "fever", "drug of fever", (float)23.3, 222222);
//			 info("Treatment is saved into the database ");
//		 } catch (ProviderNotFoundExn e) {
//			e.printStackTrace();
//		 } catch (PatientNotFoundExn e) {
//			 e.printStackTrace();
//		 }
//	 }  
  
	
//  @PostConstruct
//	public void init() { // --------------5-------------delete treatment by provider--checked
//
//		info("Initializing the service.");
//		
//		Long npi = (long) 888888;
//		Long tid = (long) 151;
//		try {
//			proService.deleteTreatment(npi, tid);
//		} catch (ProviderNotFoundExn e) {
//			e.printStackTrace();
//		} catch (TreatmentNotFoundExn e) {
//			e.printStackTrace();
//		} catch (ProviderServiceExn e) {
//			e.printStackTrace();
//		}
//	}  
  	
//	
//	@PostConstruct
//	public void init() { // -------------6--------------get treatmentDto  by patient--checked
//
//		info("Initializing the service.");
//		Long patientId = (long) 222222;
//		Long providerId = (long) 888888;
//		List<TreatmentDto> tds = proService.getTreatmentsByPatientId(providerId,patientId);
//		
//		for(TreatmentDto t : tds){
//			System.out.println("Treatment Id: "+t.getId());
//			System.out.println("Diagnosis : "+t.getDiagnosis());
//			System.out.println("Provider NPI: "+t.getProviderId());
//		}
//	}	
	
	
//	@PostConstruct
//	public void init() { // -------------7--------------get treatmentDto  by provider--checked
//
//		info("Initializing the service.");
//		Long providerId = (long) 888888;
//		List<TreatmentDto> tds = proService.getTreatmentsByProviderId(providerId);
//		
//		for(TreatmentDto t : tds){
//			System.out.println("Treatment Id: "+t.getId());
//			System.out.println("Diagnosis : "+t.getDiagnosis());
//			System.out.println("Provider NPI: "+t.getProviderId());
//		}
//	}	
	

    
    
    
	
//	@PostConstruct
//	public void init() { // -----------8-----------service test delete provider------
//
//		info("Initializing the service.");
//		Long npi = (long)888888;
//		try {
//			proService.deleteProviderByNpi("givenName", "familyName", npi);
//			info("delete complete!");
//		} catch (ProviderServiceExn e) {
//			e.printStackTrace();
//		}
//		
//	}
  
  
  
}