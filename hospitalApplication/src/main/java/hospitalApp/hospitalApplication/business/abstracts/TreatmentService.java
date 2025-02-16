package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreateTreatmentRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateTreatmentRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllTreatmentsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdTreatmentResponse;

public interface TreatmentService {
	List<GetAllTreatmentsResponse> getAll();
	GetByIdTreatmentResponse getByTreatmentId(int treatmentId);
	void add(CreateTreatmentRequest createTreatmentRequest);
	void update(UpdateTreatmentRequest updateTreatmentRequest);
	void delete(int treatmentId);
}
