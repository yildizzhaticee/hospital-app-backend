package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.DoctorService;
import hospitalApp.hospitalApplication.business.requests.CreateDoctorRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDoctorRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDoctorsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDoctorResponse;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.DoctorRepository;
import hospitalApp.hospitalApplication.entities.concretes.Doctor;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoctorManager implements DoctorService{
	private DoctorRepository doctorRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllDoctorsResponse> getAll() {
		
		List<Doctor> doctors=doctorRepository.findAll();
			
		List<GetAllDoctorsResponse> doctorsResponse=doctors.stream()
				.map(doctor->this.modelMapperService.forResponse()
						.map(doctor,GetAllDoctorsResponse.class)).collect(Collectors.toList());
				//her bir hospital için bir map'leme yap anlamına geliyor
		
		
		return doctorsResponse;
	}
	
	@Override
	public void add(CreateDoctorRequest createDoctorRequest) {
		//this.doctorBusinessRules.checkIfDoctorNameExists(createDoctorRequest.getDoctorName());
		
		Doctor doctor=this.modelMapperService.forRequest().map(createDoctorRequest, Doctor.class);
		
		this.doctorRepository.save(doctor);
		//veritabanı hospital'dan anlıyor
	}
	
	@Override
	public GetByIdDoctorResponse getByDoctorId(int doctorId) {
		Doctor doctor=this.doctorRepository.findById(doctorId).orElseThrow();  //bulamazsan hata fırlat
		//orElseThrow(()->new EntityNoFoundException("Hospital not found with id: "+hospitalId));Bu durumda daha anlamalı bir hata mesajı sağlamak isteyebilirsiniz.
		
		GetByIdDoctorResponse response
		=this.modelMapperService.forResponse().map(doctor, GetByIdDoctorResponse.class);
		
		return response;
	}


	@Override
	public void update(UpdateDoctorRequest updateDoctorRequest) {
		Doctor doctor=this.modelMapperService.forRequest().map(updateDoctorRequest, Doctor.class);
		this.doctorRepository.save(doctor); //id'de olduğu için update yapar
	}


	@Override
	public void delete(int doctorId) {
		this.doctorRepository.deleteById(doctorId);
	}

	
}
