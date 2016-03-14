package edu.stevens.cs548.clinic.service.dto.provider;


import edu.stevens.cs548.clinic.domain.Patient;
import edu.stevens.cs548.clinic.domain.Provider;
import edu.stevens.cs548.clinic.service.dto.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.patient.ObjectFactory;

public class ProviderDtoFactory {
	ObjectFactory factory;
	
	public ProviderDtoFactory() {
		factory = new ObjectFactory();
	}
	public ProviderDto createProviderDto (Provider p) {
//		PatientDTO patientDTO = factory.createPatientDTO();
		ProviderDto providerDto = new ProviderDto();
		providerDto.setProviderId(p.npi);
		providerDto.setFamilyName(p.getFamilyName());
		providerDto.setGivenName(p.getGivenName());
		providerDto.setSpecialization(p.getSpec());
		for(int i = 0; i<p.getTreatments().size();i++){
			providerDto.getTreatments().add(p.getTreatments().get(i).getId());
		}
		return providerDto;
	}

}
