package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.DiagnosisService;
import hospitalApp.hospitalApplication.business.requests.CreateDiagnosisRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateDiagnosisRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllDiagnosisesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdDiagnosisResponse;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.DiagnosisRepository;
import hospitalApp.hospitalApplication.entities.concretes.Diagnosis;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiagnosisManager implements DiagnosisService{
	private DiagnosisRepository diagnosisRepository;
	private ModelMapperService modelMapperService;
	
	
	
	
	@Override
	public List<GetAllDiagnosisesResponse> getAll() {
		List<Diagnosis> diagnosises=diagnosisRepository.findAll();
		
		List<GetAllDiagnosisesResponse> diagnosisesResponse=diagnosises.stream()
				.map(diagnosis->this.modelMapperService.forResponse()
						.map(diagnosis,GetAllDiagnosisesResponse.class)).collect(Collectors.toList());
		return diagnosisesResponse;
	}

//	@Override
//	public GetByIdDiagnosisResponse getByIdDiagnosisResponse(int diagnosisId) {
//		
//	}

	@Override
	public void add(CreateDiagnosisRequest createDiagnosisRequest) {
		
		Diagnosis diagnosis=this.modelMapperService.forRequest().map(createDiagnosisRequest,Diagnosis.class);
		
		this.diagnosisRepository.save(diagnosis);
		
	}

	@Override
	public void update(UpdateDiagnosisRequest updateDiagnosisRequest) {
		Diagnosis diagnosis =this.modelMapperService.forRequest().map(updateDiagnosisRequest, Diagnosis.class);
		this.diagnosisRepository.save(diagnosis);
		
	}

	@Override
	public void delete(int diagnosisId) {
		this.diagnosisRepository.deleteById(diagnosisId);
		
	}

	@Override
	public GetByIdDiagnosisResponse getByDiagnosisId(int diagnosisId) {
Diagnosis diagnosis=this.diagnosisRepository.findById(diagnosisId).orElseThrow();
		
		GetByIdDiagnosisResponse response
		=this.modelMapperService.forResponse().map(diagnosis, GetByIdDiagnosisResponse.class);
		return response;
	}


}
