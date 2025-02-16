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

import hospitalApp.hospitalApplication.business.abstracts.TreatmentService;
import hospitalApp.hospitalApplication.business.requests.CreateTreatmentRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateTreatmentRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllTreatmentsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdTreatmentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="api/treatments")
@AllArgsConstructor
public class TreatmentsController {
	private TreatmentService treatmentService;
	
	@GetMapping()
	private List<GetAllTreatmentsResponse> getAll(){
		return treatmentService.getAll();
	}
	@GetMapping("/{treatmentId}") //{} içinde olduğunda variable olmuş oluyor
	public GetByIdTreatmentResponse getByTreatmentId(@PathVariable("treatmentId") int treatmentId) { //id'yi path'ten alacak
		return treatmentService.getByTreatmentId(treatmentId);
	}
	
	@PostMapping()  //"/add"  eklemeler için kullanılır
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateTreatmentRequest createTreatmentRequest) {
		this.treatmentService.add(createTreatmentRequest);
	}
	
	@PutMapping   //Güncelleme için kullanılıyor
	public void update(@RequestBody UpdateTreatmentRequest upddateTreatmentRequest) {
		this.treatmentService.update(upddateTreatmentRequest);
	}
	
	@DeleteMapping("/{treatmentId}")
	public void delete(@PathVariable("treatmentId") int treatmentId) {
		this.treatmentService.delete(treatmentId);
	}
}
