package hospitalApp.hospitalApplication.business.rules;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.core.utilities.exceptions.BusinessException;
import hospitalApp.hospitalApplication.dataAccess.abstracts.PatientRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PatientBusinessRules {
	private PatientRepository patientRepository;
	
	public void checkIfPatientTelExists(String patientTel) {
		if(this.patientRepository.existsByPatientTel(patientTel)) {
			throw new BusinessException("Patient tel already exists");
		}
	}
}
