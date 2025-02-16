package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreateDepartmentRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDepartmentRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDepartmentsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDepartmentResponse;

public interface DepartmentService {
	List<GetAllDepartmentsResponse> getAll(); 
	GetByIdDepartmentResponse getByDepartmentId(int departmentId);
	void add(CreateDepartmentRequest createDepartmentRequest);
	void update(UpdateDepartmentRequest updateDepartmentRequest);
	void delete(int departmentId);

}
