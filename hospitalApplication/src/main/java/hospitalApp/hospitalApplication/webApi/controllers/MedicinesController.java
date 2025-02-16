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

import hospitalApp.hospitalApplication.business.abstracts.MedicineService;
import hospitalApp.hospitalApplication.business.requests.CreateMedicineRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateMedicineRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllMedicinesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdMedicineResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/medicines")
@AllArgsConstructor
public class MedicinesController {
	private MedicineService medicineService;
	
	@GetMapping() //"/getAll"   data çekmek için kullanılır
	private List<GetAllMedicinesResponse> getAll(){
		return medicineService.getAll();
	}
	
	@GetMapping("/{medicineId}") //{} içinde olduğunda variable olmuş oluyor
	public GetByIdMedicineResponse getByMedicineId(@PathVariable("medicineId") int medicineId) { //id'yi path'ten alacak
		return medicineService.getByMedicineId(medicineId);
	}
	
	@PostMapping()  //"/add"  eklemeler için kullanılır
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateMedicineRequest createMedicineRequest) {
		this.medicineService.add(createMedicineRequest);
	}
	
	@PutMapping   //Güncelleme için kullanılıyor
	public void update(@RequestBody UpdateMedicineRequest upddateMedicineRequest) {
		this.medicineService.update(upddateMedicineRequest);
	}
	
	@DeleteMapping("/{medicineId}")
	public void delete(@PathVariable("medicineId") int medicineId) {
		this.medicineService.delete(medicineId);
	}
}
