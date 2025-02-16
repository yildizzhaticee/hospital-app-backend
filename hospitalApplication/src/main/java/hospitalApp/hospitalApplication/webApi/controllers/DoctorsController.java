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

import hospitalApp.hospitalApplication.business.abstracts.DoctorService;
import hospitalApp.hospitalApplication.business.requests.CreateDoctorRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDoctorRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDoctorsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDoctorResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/doctors")
@AllArgsConstructor
public class DoctorsController {
	private DoctorService doctorService;
	
	@GetMapping() //"/getAll"   data çekmek için kullanılır
	private List<GetAllDoctorsResponse> getAll(){
		return doctorService.getAll();
	}
	
	@GetMapping("/{doctorId}") //{} içinde olduğunda variable olmuş oluyor
	public GetByIdDoctorResponse getByDoctorId(@PathVariable("doctorId") int doctorId) { //id'yi path'ten alacak
		return doctorService.getByDoctorId(doctorId);
	}
	
	@PostMapping()  //"/add"  eklemeler için kullanılır
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateDoctorRequest createDoctorRequest) {
		this.doctorService.add(createDoctorRequest);
	}
	
	@PutMapping   //Güncelleme için kullanılıyor
	public void update(@RequestBody UpdateDoctorRequest upddateDoctorRequest) {
		this.doctorService.update(upddateDoctorRequest);
	}
	
	@DeleteMapping("/{doctorId}")
	public void delete(@PathVariable("doctorId") int doctorId) {
		this.doctorService.delete(doctorId);
	}
}
