package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.HospitalService;
import hospitalApp.hospitalApplication.business.requests.CreateHospitalRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateHospitalRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllHospitalsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdHospitalResponse;
import hospitalApp.hospitalApplication.business.rules.HospitalBusinessRules;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.HospitalRepository;
import hospitalApp.hospitalApplication.entities.concretes.Hospital;
import lombok.AllArgsConstructor;



@Service  // Bu sınıf bir business nesnesidir anlamına geliyor
@AllArgsConstructor
public class HospitalManager implements HospitalService{

	//HospitalManager data accessi kullanacak onun için şu şekilde yapacağız=>
	private  HospitalRepository hospitalRepository;
	private ModelMapperService modelMapperService;
	private HospitalBusinessRules hospitalBusinessRules;
	
	
//	
//	@Autowired
//	public HospitalManager(HospitalRepository hospitalRepository) {
//		this.hospitalRepository = hospitalRepository;
//	}//constructor injection
//Hospital ile ilgili kuralı öğrenebilmek için bir Repository ver diyor.
	//o a interface ama bunu sonrasında değiştirebiliriz onu sağlıyor unutma.


	@Override
	public List<GetAllHospitalsResponse> getAll() {
		
		List<Hospital> hospitals=hospitalRepository.findAll();
			
		List<GetAllHospitalsResponse> hospitalsResponse=hospitals.stream()
				.map(hospital->this.modelMapperService.forResponse()
						.map(hospital,GetAllHospitalsResponse.class)).collect(Collectors.toList());
				//her bir hospital için bir map'leme yap anlamına geliyor
		
		
		return hospitalsResponse;
	}


	@Override
	public void add(CreateHospitalRequest createHospitalRequest) {
		this.hospitalBusinessRules.checkIfHospitalNameExists(createHospitalRequest.getHospitalName());
		
		Hospital hospital=this.modelMapperService.forRequest().map(createHospitalRequest, Hospital.class);
		
		this.hospitalRepository.save(hospital);
		//veritabanı hospital'dan anlıyor
	}


	@Override
	public GetByIdHospitalResponse getByHospitalId(int hospitalId) {
		Hospital hospital=this.hospitalRepository.findById(hospitalId).orElseThrow();  //bulamazsan hata fırlat
		//orElseThrow(()->new EntityNoFoundException("Hospital not found with id: "+hospitalId));Bu durumda daha anlamalı bir hata mesajı sağlamak isteyebilirsiniz.
		
		GetByIdHospitalResponse response
		=this.modelMapperService.forResponse().map(hospital, GetByIdHospitalResponse.class);
		
		return response;
	}


	@Override
	public void update(UpdateHospitalRequest updateHospitalRequest) {
		Hospital hospital=this.modelMapperService.forRequest().map(updateHospitalRequest, Hospital.class);
		this.hospitalRepository.save(hospital); //id'de olduğu için update yapar
	}


	@Override
	public void delete(int hospitalId) {
		this.hospitalRepository.deleteById(hospitalId);
	}

}
//spring'in yeni versiyonlarında autowired vermesen de default olarak öyle çalışıyor
//HospitalManager business interface dışında asla haberi yok data access'ten. Bağimsızlaştırıyoruz yani

//Servis katmanı olduğunu belirtmek için @Service anatasyonu ekleniyor
//bellekte new'leniyor ve onu veriyor bize IoC o olmuş oluyor

//IoC=> nesnenin new'lenmiş halini veriyor.nesneleri IoC'ye eklemsi için diyoruz ki sen bir @Service'sin

//Hospital --> id,name,tel
//GetAllHospitalResponse -->name,tel
//değerleri atamamız gerekiyor bunun için mapping yapmamız gerekiyor.

//Brand'i GetAllHospitalsResponse buna çevirmek için mapper'lardan yararlanırız.


