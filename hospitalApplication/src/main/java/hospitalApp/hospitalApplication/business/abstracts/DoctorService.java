package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreateDoctorRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDoctorRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDoctorsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDoctorResponse;



public interface DoctorService {
	List<GetAllDoctorsResponse> getAll();      	// response'dir ama veritabanı varliği döndürmek yasak
	GetByIdDoctorResponse getByDoctorId(int doctorId);
	void add(CreateDoctorRequest createDoctorRequest);
	void update(UpdateDoctorRequest updateDoctorRequest);
	void delete(int doctorId);
}
