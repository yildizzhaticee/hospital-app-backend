package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.DepartmentService;
import hospitalApp.hospitalApplication.business.requests.CreateDepartmentRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDepartmentRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDepartmentsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDepartmentResponse;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.DepartmentRepository;
import hospitalApp.hospitalApplication.entities.concretes.Department;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentManager implements DepartmentService{

	private DepartmentRepository departmentRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllDepartmentsResponse> getAll() {
		List<Department> departments=departmentRepository.findAll();
		
		List<GetAllDepartmentsResponse> departmentsResponse=departments.stream()
				.map(department->this.modelMapperService.forResponse()
						.map(department,GetAllDepartmentsResponse.class)).collect(Collectors.toList());
				//her bir hospital için bir map'leme yap anlamına geliyor
		
		
		return departmentsResponse;
	}

	@Override
	public void add(CreateDepartmentRequest createDepartmentRequest) {
	Department department=this.modelMapperService.forRequest().map(createDepartmentRequest, Department.class);
		
		this.departmentRepository.save(department);		
	}

	@Override
	public GetByIdDepartmentResponse getByDepartmentId(int departmentId) {
		Department department=this.departmentRepository.findById(departmentId).orElseThrow();  //bulamazsan hata fırlat
		//orElseThrow(()->new EntityNoFoundException("Hospital not found with id: "+hospitalId));Bu durumda daha anlamalı bir hata mesajı sağlamak isteyebilirsiniz.
		
		GetByIdDepartmentResponse response
		=this.modelMapperService.forResponse().map(department, GetByIdDepartmentResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateDepartmentRequest updateDepartmentRequest) {
		Department department=this.modelMapperService.forRequest().map(updateDepartmentRequest, Department.class);
		this.departmentRepository.save(department); //id'de olduğu için update yapar		
	}

	@Override
	public void delete(int departmentId) {
		this.departmentRepository.deleteById(departmentId);
		
	}

}
