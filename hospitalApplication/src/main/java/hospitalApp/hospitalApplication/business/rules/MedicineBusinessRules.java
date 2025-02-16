package hospitalApp.hospitalApplication.business.rules;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.core.utilities.exceptions.BusinessException;
import hospitalApp.hospitalApplication.dataAccess.abstracts.MedicineRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MedicineBusinessRules {
private MedicineRepository medicineRepository;
	
	public void checkIfMedicineNameExists(String medicineName) {
		if(this.medicineRepository.existsByMedicineName(medicineName)) {
			throw new BusinessException("Medicine name already exists");
		}
	}
}
