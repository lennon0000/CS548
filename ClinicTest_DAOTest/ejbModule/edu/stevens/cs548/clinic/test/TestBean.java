package edu.stevens.cs548.clinic.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.stevens.cs548.clinic.domain.ClinicGateway;
import edu.stevens.cs548.clinic.domain.ClinicGatewayFactory;
import edu.stevens.cs548.clinic.domain.IPatientDAO;
import edu.stevens.cs548.clinic.domain.IPatientDAO.PatientExn;
import edu.stevens.cs548.clinic.domain.IPatientFactory;
import edu.stevens.cs548.clinic.domain.IProviderDAO;
import edu.stevens.cs548.clinic.domain.IProviderDAO.ProviderExn;
import edu.stevens.cs548.clinic.domain.IProviderFactory;
import edu.stevens.cs548.clinic.domain.ITreatmentDAO.TreatmentExn;
import edu.stevens.cs548.clinic.domain.Patient;
import edu.stevens.cs548.clinic.domain.PatientDAO;
import edu.stevens.cs548.clinic.domain.PatientFactory;
import edu.stevens.cs548.clinic.domain.Provider;
import edu.stevens.cs548.clinic.domain.ProviderDAO;
import edu.stevens.cs548.clinic.domain.ProviderFactory;
import edu.stevens.cs548.clinic.domain.Treatment;

/**
 * Session Bean implementation class TestBean
 */
@Singleton
@LocalBean
@Startup
public class TestBean {

	private static Logger logger = Logger.getLogger(TestBean.class.getCanonicalName());
    private static void info(String m){
    	logger.info(m);
    }

    
    public TestBean() {}
    
    @PersistenceContext(unitName = "ClinicDomain_assignment5_2")
    private EntityManager em;
    
    
    
//    @PostConstruct
//    public void init() {   // ---------1-------- add patient and provider-----checked
//    	
//    	info("Initializing the user database.");
//    	
//    	ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//    	IPatientFactory patientFactory = new PatientFactory();
//    	IProviderFactory providerFactory = new ProviderFactory();
//    	
//    	Calendar lastDate = Calendar.getInstance(); 
//    	lastDate.set(2000, 10, 13);
//    	Date dob = lastDate.getTime();
//    	
//    	Patient pat = patientFactory.creatPatient(111111,"Lisi", dob, 14);
//    	Patient pat2 = patientFactory.creatPatient(222222,"Zhangsan", dob, 14);
//    	Patient pat3 = patientFactory.creatPatient(333333,"Wangwu", dob, 14);
//    	
//		List<Patient> pats = new ArrayList();
//		pats.add(pat);
//		pats.add(pat2);
//		pats.add(pat3);
//
//		
//
//		Provider prov = providerFactory.creatProvider(999999, "yisheng", "Sun",
//				"radiology");
//		Provider prov2 = providerFactory.creatProvider(888888, "yisheng", "Qian",
//				"internist");
//		Provider prov3 = providerFactory.creatProvider(777777, "yisheng", "Zhao",
//				"surgery");
//		List<Provider> provs = new ArrayList();
//		provs.add(prov);
//		provs.add(prov2);
//		provs.add(prov3);
//		try {
//			for(Provider pr:provs){
//				cgf.creatClinicGateway().getProviderDAO().addProvider(pr);
//			}
//			
//			System.out.println("providers are saved!");
//		} catch (ProviderExn e) {
//			e.printStackTrace();
//		}
//    	
//    	
//    	try {
//    		for(Patient p:pats){
//    			cgf.creatClinicGateway().getPatientDAO().addPatient(p);
//    		}
//    		System.out.println("patients are saved!");
//		} catch (PatientExn e1) {
//			e1.printStackTrace();
//		}
//    }
    
    
//    @PostConstruct
//	 public void init() { // -------------9------------add treatments----checked
//	
//	 info("Initializing the user database.");
//	
//	 IPatientDAO patientDAO = new PatientDAO(em);
//	 
//	 IProviderDAO providerDAO = new ProviderDAO(em);
//	
//	 
//	 Long npi = (long) 888888;
//	 Provider pr = new Provider();
//	try {
//		pr = providerDAO.getProviderByNpi(npi);
//	} catch (ProviderExn e) {
//		e.printStackTrace();
//	}
//	 Long pid = (long)222222;
//	 Patient p = new Patient();
//	try {
//		p = patientDAO.getPatientByPatientId(pid);
//	} catch (PatientExn e) {
//		e.printStackTrace();
//	}
//	 
//	 Long treatmentId3 = pr.addDrugTreatment("cancer", "Drug of cancer", (float)13.3,p);
//	 Long treatmentId4 = pr.addDrugTreatment("SARS", "Drug of SARS", (float)23.2,p);
//	 info("Treatments are saved into the database, Treatment Id: "+ treatmentId3);
//    }
    
    
    
//    @PostConstruct
//    public void init() {   // ---------1-------- add patient-----checked
//    	
//    	info("Initializing the user database.");
//    	
//    	ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//    	IPatientFactory patientFactory = new PatientFactory();
//    	
//    	Calendar lastDate = Calendar.getInstance(); 
//    	lastDate.set(2000, 10, 13);
////    	lastDate.add(Calendar.YEAR,-26);
//    	Date dob = lastDate.getTime();
//    	
//    	Patient pat = patientFactory.creatPatient(111111,"Lisi", dob, 14);
//    	try {
//    			cgf.creatClinicGateway().getPatientDAO().addPatient(pat);
//			
//		} catch (PatientExn e1) {
//			e1.printStackTrace();
//		}
//    }
    
//    @PostConstruct
//    public void init() {   // ----------2---------- get patient by patientId----checked
//    	
//    	info("Initializing the user database.");
//    	
//    	ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//    	IPatientFactory patientFactory = new PatientFactory();
//    	
//    	long pid = 111111;
//    	
//    	Patient p;
//		try {
//			p = cgf.creatClinicGateway().getPatientDAO().getPatientByPatientId(pid);
//			System.out.println("patient's DbId:"+p.getId());
//	    	System.out.println("patient's id:"+p.getPatientId());
//	    	System.out.println("patient's name:"+p.getName());
//	    	System.out.println("patient's dob:"+p.getBirthDate());
//    	
//		} catch (PatientExn e) {
//			
//			e.printStackTrace();
//		}
//    }
    
    
//	@PostConstruct
//	public void init() {   //  ------------3----------get patient by primary key
//  	
//  	info("Initializing the user database.");
//  	
//  	ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//  	
//  	long dbId = 1;
//  	Patient p = new Patient();
//		try {
//			p = cgf.creatClinicGateway().getPatientDAO().getPatientByDbid(dbId);
//			System.out.println("patient's DbId:"+p.getId());
//	    	System.out.println("patient's id:"+p.getPatientId());
//	    	System.out.println("patient's name:"+p.getName());
//	    	System.out.println("patient's dob:"+p.getBirthDate());
////	    	List<Treatment> ts = p.getTreatments();
////	    	for(Treatment t: ts){
////	    		System.out.println("treatment id:"+t.getId());
////	    		System.out.println("treatment diagnose:"+t.getDiagnosis());
////	    	}
//  	
//		} catch (PatientExn e) {
//			
//			e.printStackTrace();
//		}
//  }
    
    
    
//    @PostConstruct
//    public void init() {   //  ------------4------------get patient by name and dob----checked
//    	
//    	info("Initializing the user database.");
//    	
//    	ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//    	
//    	String name = "Zhangsan";
//    	Calendar lastDate = Calendar.getInstance(); 
//    	lastDate.set(2000, 10, 13);
//    	Date dob = lastDate.getTime();
//    	
//    	List<Patient> patients = cgf.creatClinicGateway().getPatientDAO().getPatientByNameDob(name, dob);
//    	
//    	for (Patient p : patients) {
//    		System.out.println("patient's DbId:"+p.getId());
//			System.out.println("patient's id:"+p.getPatientId());
//			System.out.println("patient's name:"+p.getName());
//			System.out.println("patient's dob:"+p.getBirthDate());
////    	    	System.out.println(""+p.getTreatmentIds());
//		}
//    }
    
    
//	@PostConstruct
//	public void init() { // ------------5-----------add provider----checked
//
//		info("Initializing the user database.");
//		
//    	ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//		IProviderFactory providerFactory = new ProviderFactory();
//
//		Provider prov = providerFactory.creatProvider(888888, "yisheng", "Sun", "radiology");
//		try {
//			cgf.creatClinicGateway().getProviderDAO().addProvider(prov);
//			System.out.println("provider is saved!");
//		} catch (ProviderExn e) {
//			e.printStackTrace();
//		}
//
//	}
    
    
//    @PostConstruct
//	public void init() { // ---------------6-----------------get provider by NPI------checked
//
//		info("Initializing the user database.");
//		ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//
//		Long npi = (long) 7777777;
//		Provider prov2;
//		try {
//			prov2 = cgf.creatClinicGateway().getProviderDAO().getProviderByNpi(npi);
//			System.out.println("provider's NPI:"+prov2.getNpi());
//	    	System.out.println("provider's GivenName:"+prov2.getGivenName());
//	    	System.out.println("provider's FamilyName:"+prov2.getFamilyName());
//	    	System.out.println("provider's Spce:"+prov2.getSpec());
//		} catch (ProviderExn e1) {
//			e1.printStackTrace();
//		}
//	}
    
    
    
	
//    @PostConstruct
//	public void init() { // ------------7-----------get provider by GivenName-----checked
//
//		info("Initializing the user database.");
//		ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//
//		String givenName = "Yisheng";
//		List<Provider> provs;
//		try {
//			provs = cgf.creatClinicGateway().getProviderDAO().getProviderByGivenName(givenName);
//			for (Provider p : provs) {
//				info("provider's NPI:"+p.getNpi());
//		    	info("provider's GivenName:"+p.getGivenName());
//		    	info("provider's FamilyName:"+p.getFamilyName());
//		    	info("provider's Spce:"+p.getSpec());
//			}
//		} catch (ProviderExn e) {
//			e.printStackTrace();
//		}
//	}
    
//	@PostConstruct
//	public void init() { // -----------8-----------delete provider------checked
//
//		info("Initializing the user database.");
//		
////		ClinicGatewayFactory cgf = new ClinicGatewayFactory();
////		ClinicGateway cg = cgf.creatClinicGateway();
////		
////		IProviderDAO providerDAO2 = cg.getProviderDAO();
//		
//
//		IProviderDAO providerDAO = new ProviderDAO(em);
//		
//		Long npi = (long)888888;
//
//		Provider prov = new Provider();
//		try {
//			prov = providerDAO.getProviderByNpi(npi);
//		} catch (ProviderExn e) {
//			e.printStackTrace();
//		}
//
//		try {
//			providerDAO.deleteProvider(prov);
//		} catch (ProviderExn e) {
//			e.printStackTrace();
//		}
//		info("delete complete!");
//	}
    
    
    
    
//	 @PostConstruct
//	 public void init() { // -------------9------------add treatment----checked
//	
//	 info("Initializing the user database.");
//	
//	 IPatientDAO patientDAO = new PatientDAO(em);
// 	 
//	 IProviderDAO providerDAO = new ProviderDAO(em);
//	
//	 
//	 Long npi = (long) 888888;
//	 Provider pr = new Provider();
//	try {
//		pr = providerDAO.getProviderByNpi(npi);
//	} catch (ProviderExn e) {
//		e.printStackTrace();
//	}
//	 Long pid = (long)111111;
//	 Patient p = new Patient();
//	try {
//		p = patientDAO.getPatientByPatientId(pid);
//	} catch (PatientExn e) {
//		e.printStackTrace();
//	}
//
//	 Long treatmentId = pr.addDrugTreatment("cold", "Drug of cold", (float)53.3,p);
//	 info("Treatment is saved into the database, Treatment Id: "+ treatmentId);
//	 }
    
   
    
    
    
    
//    @PostConstruct
//  public void init() {   //  ---------11--------delete patient--checked
//  	
//  	info("Initializing the user database.");
//  	
//  	IPatientDAO patientDAO = new PatientDAO(em);
//  
//  	Long dbId = (long)1;
//  	try {
//		patientDAO.deletePatient(dbId);
//		info("patient is deleted! ");
//	} catch (PatientExn e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//  }
    

    
    
  @PostConstruct
	public void init() { // --------------12-------------get provider and treatment id by NPI------checked

		info("Initializing the user database.");
		ClinicGatewayFactory cgf = new ClinicGatewayFactory();

		Long npi = (long) 888888;
		Provider prov2;
		try {
			prov2 = cgf.creatClinicGateway().getProviderDAO().getProviderAndTreByNpi(npi);
			System.out.println("provider's NPI:"+prov2.getNpi());
	    	System.out.println("provider's GivenName:"+prov2.getGivenName());
	    	System.out.println("provider's FamilyName:"+prov2.getFamilyName());
	    	System.out.println("provider's Spce:"+prov2.getSpec());
	    	for(Treatment t: prov2.getTreatments()){
	    		System.out.println("The treatment id is :" + t.getId());
	    	}
		} catch (ProviderExn e1) {
			e1.printStackTrace();
		}
	}   
    
//  @PostConstruct
// 	public void init() { // -------------13--------------get treatment ids by patient
//
// 		info("Initializing the user database.");
// 		ClinicGatewayFactory cgf = new ClinicGatewayFactory();
// 		
// 		
// 		Long pid = (long) 111111;
// 		List<Long> treatmentIds =  cgf.creatClinicGateway().getPatientDAO().getTreatmentIds(pid);
// 		
// 		for(long id : treatmentIds){
// 			System.out.println("The patient's treatment id:"+id);
// 		}
// 	} 
    
//    @PostConstruct
//	public void init() { // --------------12-------------delete treatment by provider--checked
//
//		info("Initializing the user database.");
//		ClinicGatewayFactory cgf = new ClinicGatewayFactory();
//		IProviderDAO providerDAO = new ProviderDAO(em);
//		
//		Long npi = (long) 888888;
//	
//		Provider pr = new Provider();
//		try {
//			pr = providerDAO.getProviderByNpi(npi);
//		} catch (ProviderExn e) {
//			e.printStackTrace();
//		}
//		try {
//			pr.deleteTreatment(101);
//		} catch (TreatmentExn e) {
//			e.printStackTrace();
//		}
//	}  

	
}
