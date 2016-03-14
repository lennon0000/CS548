package edu.stevens.cs548.clinic.service.web.soap;

import javax.ejb.EJB;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.service.dto.provider.ProviderDto;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.ProviderServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderService.TreatmentNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IProviderServiceRemote;

@WebService(
		endpointInterface="edu.stevens.cs548.clinic.service.web.soap.IProviderWebService",
		serviceName = "ProviderWeb",
		portName="ProviderPort"
		)
public class ProviderWebService {
//implements IProviderWebService {
	@EJB(beanName="ProviderServiceBean")
	IProviderServiceRemote providerService;
	
	public ProviderDto getProviderByNpi(long npi) throws ProviderServiceExn {
		return providerService.getProviderAndTreByNpi(npi);
	}

	public ProviderDto[] getProviderByGivenName(String givenName)
			throws ProviderServiceExn {
		return providerService.getProviderByGivenName(givenName);
	}

	public void createProvider(long npi, String givenName, String familyName,
			String spec) throws ProviderServiceExn {
		providerService.createProvider(npi, givenName, familyName, spec);
	}

	public void deleteProviderByNpi(String givenName, String familyName,
			Long npi) throws ProviderServiceExn {
		providerService.deleteProviderByNpi(givenName, familyName, npi);
	}

	public ProviderDto getProviderAndTreByNpi(long npi)
			throws ProviderServiceExn {
		return providerService.getProviderAndTreByNpi(npi);
	}

	public TreatmentDto[] getTreatments(long npi, long[] tids)
			throws ProviderNotFoundExn, TreatmentNotFoundExn,
			ProviderServiceExn {
		return providerService.getTreatments(npi, tids);
	}

	public void addDrugTreatment(long npi, String diagnosis, String drug,
			float dosage, long pid) throws ProviderNotFoundExn,
			PatientNotFoundExn {
		providerService.addDrugTreatment(npi, diagnosis, drug, dosage, pid);
	}

	public void deleteTreatment(long npi, long tid) throws ProviderNotFoundExn,
			TreatmentNotFoundExn, ProviderServiceExn {
		providerService.deleteTreatment(npi, tid);
	}

}
