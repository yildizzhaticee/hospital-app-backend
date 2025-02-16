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

import hospitalApp.hospitalApplication.business.abstracts.PatientService;
import hospitalApp.hospitalApplication.business.requests.CreatePatientRequest;
import hospitalApp.hospitalApplication.business.requests.UpdatePatientRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllPatientsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdPatientResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientsController {
	private PatientService patientService;
	
	@GetMapping()
	public List<GetAllPatientsResponse> getAll(){
		return patientService.getAll();
	}
	@GetMapping("/{patientId}") //{} içinde olduğunda variable olmuş oluyor
	public GetByIdPatientResponse getByPatientId(@PathVariable("patientId") int patientId) { //id'yi path'ten alacak
		return patientService.getByPatientId(patientId);
	}
	
	@PostMapping()  //"/add"  eklemeler için kullanılır
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreatePatientRequest createPatientRequest) {
		this.patientService.add(createPatientRequest);
	}
	
	@PutMapping   //Güncelleme için kullanılıyor
	public void update(@RequestBody UpdatePatientRequest upddatePatientRequest) {
		this.patientService.update(upddatePatientRequest);
	}
	
	@DeleteMapping("/{patientId}")
	public void delete(@PathVariable("patientId") int patientId) {
		this.patientService.delete(patientId);
	}
}
//controller erişim noktası oluyor. İsteğin yapıldığı yer