package edu.stevens.cs548.clinic.service.dto.patient;


import edu.stevens.cs548.clinic.domain.Patient;
import edu.stevens.cs548.clinic.service.dto.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.patient.ObjectFactory;

public class PatientDtoFactory {
	ObjectFactory factory;
	
	public PatientDtoFactory() {
		factory = new ObjectFactory();
	}
	public PatientDTO createPatientDto (Patient p) {
//		PatientDTO patientDTO = factory.createPatientDTO();
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setId(p.getId());
		patientDTO.setPatientId(p.getPatientId());
		patientDTO.setBirthday(p.getBirthDate());
		for(int i = 0; i<p.getTreatmentIds().size();i++){
			patientDTO.getTreatments().add(p.getTreatmentIds().get(i));
		}
		return patientDTO;
	}

}
