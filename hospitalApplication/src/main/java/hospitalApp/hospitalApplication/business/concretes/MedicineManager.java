package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.MedicineService;
import hospitalApp.hospitalApplication.business.requests.CreateMedicineRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateMedicineRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllMedicinesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdMedicineResponse;
import hospitalApp.hospitalApplication.business.rules.MedicineBusinessRules;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.MedicineRepository;
import hospitalApp.hospitalApplication.entities.concretes.Medicine;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedicineManager  implements MedicineService{
	
	private MedicineRepository medicineRepository;
	private ModelMapperService modelMapperService;
	private MedicineBusinessRules medicineBusinessRules;
	
	@Override
	public List<GetAllMedicinesResponse> getAll() {
		List<Medicine> medicines=medicineRepository.findAll();
		
		List<GetAllMedicinesResponse> medicinesResponse=medicines.stream()
				.map(medicine->this.modelMapperService.forResponse()
						.map(medicine,GetAllMedicinesResponse.class)).collect(Collectors.toList());
		
		return medicinesResponse;
		
	}

	@Override
	public GetByIdMedicineResponse getByMedicineId(int medicineId) {
		Medicine medicine=this.medicineRepository.findById(medicineId).orElseThrow();  //bulamazsan hata fırlat
		
		GetByIdMedicineResponse response
		=this.modelMapperService.forResponse().map(medicine, GetByIdMedicineResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateMedicineRequest createMedicineRequest) {
       this.medicineBusinessRules.checkIfMedicineNameExists(createMedicineRequest.getMedicineName());
		
		Medicine medicine=this.modelMapperService.forRequest().map(createMedicineRequest, Medicine.class);
		
		this.medicineRepository.save(medicine);		
	}

	@Override
	public void update(UpdateMedicineRequest updateMedicineRequest) {
		Medicine medicine=this.modelMapperService.forRequest().map(updateMedicineRequest, Medicine.class);
		this.medicineRepository.save(medicine);
		
	}

	@Override
	public void delete(int medicineId) {
		this.medicineRepository.deleteById(medicineId);
		
	}

}
