package hospitalApp.hospitalApplication.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hospitalApp.hospitalApplication.business.abstracts.DepartmentService;
import hospitalApp.hospitalApplication.business.requests.CreateDepartmentRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDepartmentRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDepartmentsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDepartmentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/departments")
@AllArgsConstructor
public class DepartmentsController {
	private DepartmentService departmentService;
	
	@GetMapping() //"/getAll"   data çekmek için kullanılır
	private List<GetAllDepartmentsResponse> getAll(){
		return departmentService.getAll();
	}
	
	@GetMapping("/{departmentId}") //{} içinde olduğunda variable olmuş oluyor
	public GetByIdDepartmentResponse getByDepartmentId(@PathVariable("departmentId") int departmentId) { //id'yi path'ten alacak
		return departmentService.getByDepartmentId(departmentId);
	}
	
	@PostMapping()  //"/add"  eklemeler için kullanılır
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid CreateDepartmentRequest createDepartmentRequest) {
		this.departmentService.add(createDepartmentRequest);
	}
	@PutMapping   //Güncelleme için kullanılıyor
	public void update(@RequestBody UpdateDepartmentRequest upddateDepartmentRequest) {
		this.departmentService.update(upddateDepartmentRequest);
	}
	
	@DeleteMapping("/{departmentId}")
	public void delete(@PathVariable("departmentId") int departmentId) {
		this.departmentService.delete(departmentId);
	}
	
}
