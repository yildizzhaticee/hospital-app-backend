package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreateMedicineRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateMedicineRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllMedicinesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdMedicineResponse;

public interface MedicineService {
	List<GetAllMedicinesResponse> getAll();
	GetByIdMedicineResponse getByMedicineId(int medicineId);
	void add(CreateMedicineRequest createMedicineRequest);
	void update(UpdateMedicineRequest updateMedicineRequest);
	void delete(int medicineId);
}
