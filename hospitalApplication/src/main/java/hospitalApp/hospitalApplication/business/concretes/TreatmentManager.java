package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.TreatmentService;
import hospitalApp.hospitalApplication.business.requests.CreateTreatmentRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateTreatmentRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllTreatmentsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdTreatmentResponse;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.TreatmentRepository;
import hospitalApp.hospitalApplication.entities.concretes.Treatment;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TreatmentManager  implements TreatmentService{

	private TreatmentRepository treatmentRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllTreatmentsResponse> getAll() {
		List<Treatment> treatments=treatmentRepository.findAll();
		
		List<GetAllTreatmentsResponse> treatmentsResponses=treatments.stream()
				.map(treatment->this.modelMapperService.forResponse()
				.map(treatment,GetAllTreatmentsResponse.class)).collect(Collectors.toList());
		return treatmentsResponses;
	}

	@Override
	public GetByIdTreatmentResponse getByTreatmentId(int treatmentId) {
		Treatment treatment=this.treatmentRepository.findById(treatmentId).orElseThrow();
		
		GetByIdTreatmentResponse response
		=this.modelMapperService.forResponse().map(treatment, GetByIdTreatmentResponse.class);
		return response;
	}

	@Override
	public void add(CreateTreatmentRequest createTreatmentRequest) {
		
		Treatment treatment=this.modelMapperService.forRequest().map(createTreatmentRequest, Treatment.class);
		
		this.treatmentRepository.save(treatment);
		
	}

	@Override
	public void update(UpdateTreatmentRequest updateTreatmentRequest) {
		Treatment treatment=this.modelMapperService.forRequest().map(updateTreatmentRequest,Treatment.class);
		this.treatmentRepository.save(treatment);
	}

	@Override
	public void delete(int treatmentId) {
		this.treatmentRepository.deleteById(treatmentId);
	}

}
