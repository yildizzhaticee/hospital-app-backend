package hospitalApp.hospitalApplication.business.rules;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.core.utilities.exceptions.BusinessException;
import hospitalApp.hospitalApplication.dataAccess.abstracts.DepartmentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DepartmentBusinessRules {
private DepartmentRepository departmentRepository;
	
	public void checkIfHospitalNameExists(String departmentName) {
		if(this.departmentRepository.existsByDepartmentName(departmentName)) {
			throw new BusinessException("Department name already exists");
		}
	}
}
