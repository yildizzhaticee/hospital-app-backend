package hospitalApp.hospitalApplication.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hospitalApp.hospitalApplication.business.abstracts.DiagnosisService;
import hospitalApp.hospitalApplication.business.requests.CreateDiagnosisRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDiagnosisRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDiagnosisesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDiagnosisResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/diagnosises")
@AllArgsConstructor
public class DiagnosisesController {
	private DiagnosisService diagnosisService;
	
	@GetMapping()
	private List<GetAllDiagnosisesResponse> getAll(){
		return diagnosisService.getAll();
	}
	
	@GetMapping("/{diagnosisId}")
	public GetByIdDiagnosisResponse getByDiagnosisId(@PathVariable("diagnosisId") int diagnosisId) {
		return diagnosisService.getByDiagnosisId(diagnosisId);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateDiagnosisRequest createDiagnosisRequest) {
		this.diagnosisService.add(createDiagnosisRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateDiagnosisRequest updateDiagnosisRequest) {
		this.diagnosisService.update(updateDiagnosisRequest);
	}
	
	@DeleteMapping("/{diagnosisId}")
	public void delete(@PathVariable("diagnosisId") int diagnosisId) {
		this.diagnosisService.delete(diagnosisId);
	}
}
