package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreateHospitalRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateHospitalRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllHospitalsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdHospitalResponse;

public interface HospitalService {
	List<GetAllHospitalsResponse> getAll();      	// response'dir ama veritabanı varliği döndürmek yasak
	GetByIdHospitalResponse getByHospitalId(int hospitalId);
	void add(CreateHospitalRequest createHospitalRequest);
	void update(UpdateHospitalRequest updateHospitalRequest);
	void delete(int hospitalId);
}


//Response request patterni ile kendimizi garantiye almak isteriz
//veritabanı nesnelerini asla son kullanıcıya açmayacağız

//request=> istek. Yeni bir hospital eklencek, hospital'ın ismini girdiği bir alan
// request,api'ye gönderdiğiniz  data'dır'

//response bizim ona verdiğimiz yanıttır

//Service'de veritabanı nesnesi döndürmek yasak. Veri güvenliğini saolamak için 
