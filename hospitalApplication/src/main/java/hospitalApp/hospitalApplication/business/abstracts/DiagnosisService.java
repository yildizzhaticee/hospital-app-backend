package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreateDiagnosisRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDiagnosisRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDiagnosisesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDiagnosisResponse;

public interface DiagnosisService {
	List<GetAllDiagnosisesResponse> getAll();
	GetByIdDiagnosisResponse getByDiagnosisId(int diagnosisId);
	void add(CreateDiagnosisRequest createDiagnosisRequest);
	void update(UpdateDiagnosisRequest updateDiagnosisRequest);
	void delete(int diagnosisId);
}
