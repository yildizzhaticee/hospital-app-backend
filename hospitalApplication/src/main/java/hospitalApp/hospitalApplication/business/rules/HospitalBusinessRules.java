package hospitalApp.hospitalApplication.business.rules;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.core.utilities.exceptions.BusinessException;
import hospitalApp.hospitalApplication.dataAccess.abstracts.HospitalRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HospitalBusinessRules {
	private HospitalRepository hospitalRepository;
	
	public void checkIfHospitalNameExists(String hospitalName) {
		if(this.hospitalRepository.existsByHospitalName(hospitalName)) {
			throw new BusinessException("Hospital name already exists");
		}
	}
}

//Bir hastane eklediğimde bu hastaneden veri tabanında olmayacak

