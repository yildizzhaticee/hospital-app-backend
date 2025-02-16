package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreatePatientRequest;
import hospitalApp.hospitalApplication.business.requests.UpdatePatientRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllPatientsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdPatientResponse;

public interface PatientService {
	List<GetAllPatientsResponse> getAll();      	// response'dir ama veritabanı varliği döndürmek yasak
	GetByIdPatientResponse getByPatientId(int patientId);
	void add(CreatePatientRequest createPatientRequest);
	void update(UpdatePatientRequest updatePatientRequest);
	void delete(int patientId);
}
