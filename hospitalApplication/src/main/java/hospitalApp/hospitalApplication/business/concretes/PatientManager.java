package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.PatientService;
import hospitalApp.hospitalApplication.business.requests.CreatePatientRequest;
import hospitalApp.hospitalApplication.business.requests.UpdatePatientRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllPatientsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdPatientResponse;
import hospitalApp.hospitalApplication.business.rules.PatientBusinessRules;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.PatientRepository;
import hospitalApp.hospitalApplication.entities.concretes.Patient;
import lombok.AllArgsConstructor;

@Service  //IoC'ye eklemesi için yapıyorsun
@AllArgsConstructor
public class PatientManager implements PatientService{

	//HospitalManager data accessi kullanacak onun için şu şekilde yapacağız=>
	private  PatientRepository patientRepository;
	private ModelMapperService modelMapperService;
	private PatientBusinessRules patientBusinessRules;
	
	
//	
//	@Autowired
//	public HospitalManager(HospitalRepository hospitalRepository) {
//		this.hospitalRepository = hospitalRepository;
//	}//constructor injection
//Hospital ile ilgili kuralı öğrenebilmek için bir Repository ver diyor.
	//o a interface ama bunu sonrasında değiştirebiliriz onu sağlıyor unutma.


	@Override
	public List<GetAllPatientsResponse> getAll() {
		
		List<Patient> patients=patientRepository.findAll();
			
		List<GetAllPatientsResponse> patientsResponse=patients.stream()
				.map(patient->this.modelMapperService.forResponse()
						.map(patient,GetAllPatientsResponse.class)).collect(Collectors.toList());
				//her bir hospital için bir map'leme yap anlamına geliyor
		
		
		return patientsResponse;
	}


	@Override
	public void add(CreatePatientRequest createPatientRequest) {
		this.patientBusinessRules.checkIfPatientTelExists(createPatientRequest.getPatientTel());
		
		Patient patient=this.modelMapperService.forRequest().map(createPatientRequest, Patient.class);
		
		this.patientRepository.save(patient);
		//veritabanı hospital'dan anlıyor
	}


	@Override
	public GetByIdPatientResponse getByPatientId(int patientId) {
		Patient patient=this.patientRepository.findById(patientId).orElseThrow();  //bulamazsan hata fırlat
		//orElseThrow(()->new EntityNoFoundException("Hospital not found with id: "+hospitalId));Bu durumda daha anlamalı bir hata mesajı sağlamak isteyebilirsiniz.
		
		GetByIdPatientResponse response
		=this.modelMapperService.forResponse().map(patient, GetByIdPatientResponse.class);
		
		return response;
	}


	@Override
	public void update(UpdatePatientRequest updatePatientRequest) {
		Patient patient=this.modelMapperService.forRequest().map(updatePatientRequest, Patient.class);
		this.patientRepository.save(patient); //id'de olduğu için update yapar
	}


	@Override
	public void delete(int patientId) {
		this.patientRepository.deleteById(patientId);
	}


	
}
