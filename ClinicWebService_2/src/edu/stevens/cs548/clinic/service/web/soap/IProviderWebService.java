package edu.stevens.cs548.clinic.service.web.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.service.dto.provider.ProviderDto;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.TreatmentNotFoundExn;

@WebService(
//		targetNamespace="http://www.example.org/clinic/wsdl/patient"
		name="IProviderWebPort",
		targetNamespace="http://cs548.stevens.edu/clinic/service/web/soap"
		)
public interface IProviderWebService {
	
	@WebMethod
	public ProviderDto getProviderByNpi (long npi) throws ProviderServiceExn;//用NPI查询provider
	@WebMethod
	public ProviderDto[] getProviderByGivenName(String givenName)throws ProviderServiceExn;
	
	@WebMethod
	public void createProvider(long npi,String givenName, String familyName,String spec) throws ProviderServiceExn;
	@WebMethod
	public void deleteProviderByNpi(String givenName,String familyName,Long npi) throws ProviderServiceExn;//TODO:这里可以进一步明确
	@WebMethod
	public ProviderDto getProviderAndTreByNpi(long npi) throws ProviderServiceExn;
	@WebMethod
	public TreatmentDto[] getTreatments(long npi,long[] tids) throws ProviderNotFoundExn, TreatmentNotFoundExn, ProviderServiceExn;
	
	@WebMethod
	public void addDrugTreatment(long npi, String diagnosis, String drug, float dosage,long pid) throws ProviderNotFoundExn,PatientNotFoundExn;
	@WebMethod
	public void deleteTreatment(long npi, long tid) throws ProviderNotFoundExn, TreatmentNotFoundExn, ProviderServiceExn;
}

