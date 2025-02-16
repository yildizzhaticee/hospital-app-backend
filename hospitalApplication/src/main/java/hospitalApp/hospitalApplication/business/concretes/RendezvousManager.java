package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.RendezvousService;
import hospitalApp.hospitalApplication.business.requests.CreateRendezvousRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateRendezvousRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllRendezvousesResponse;
import hospitalApp.hospitalApplication.business.rules.RendezvousBusinessRules;
import hospitalApp.hospitalApplication.core.utilities.exceptions.BusinessException;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.RendezvousRepository;
import hospitalApp.hospitalApplication.entities.concretes.Rendezvous;
import hospitalApp.hospitalApplication.entities.concretes.RendezvousStatus;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RendezvousManager implements RendezvousService{
	private RendezvousRepository rendezvousRepository;
	private ModelMapperService modelMapperService;
	private RendezvousBusinessRules rendezvousBusinessRules;
	
	@Override
	public List<GetAllRendezvousesResponse> getAll() {
		
		List<Rendezvous> rendezvouses=rendezvousRepository.findAll();
			
		List<GetAllRendezvousesResponse> rendezvousesResponse=rendezvouses.stream()
				.map(rendezvous->this.modelMapperService.forResponse()
						.map(rendezvous,GetAllRendezvousesResponse.class)).collect(Collectors.toList());
				//her bir hospital için bir map'leme yap anlamına geliyor
		
		
		return rendezvousesResponse;
	}
	
	@Override
	public void add(CreateRendezvousRequest createRendezvousRequest) {
		this.rendezvousBusinessRules.checkIfRendezvousIdExists(createRendezvousRequest.getRendezvousId());
	    this.rendezvousBusinessRules.checkIfRendezvousTimeAvailable(createRendezvousRequest.getRendezvousDate(), createRendezvousRequest.getRendezvousTime());

		
		Rendezvous rendezvous=this.modelMapperService.forRequest().map(createRendezvousRequest,Rendezvous.class);
		
		this.rendezvousRepository.save(rendezvous);
	}
	
	


	@Override
	public void update(UpdateRendezvousRequest updateRendezvousRequest) {
		Rendezvous rendezvous=this.modelMapperService.forRequest().map(updateRendezvousRequest, Rendezvous.class);
		this.rendezvousRepository.save(rendezvous); //id'de olduğu için update yapar
	}


	@Override
	public void delete(int rendezvousId) {
		this.rendezvousRepository.deleteById(rendezvousId);
	}

	@Override
	public hospitalApp.hospitalApplication.business.responses.GetByIdRendezvousResponse getByRendezvousId(
			int rendezvousId) {
Rendezvous rendezvous=this.rendezvousRepository.findById(rendezvousId).orElseThrow();
		
		hospitalApp.hospitalApplication.business.responses.GetByIdRendezvousResponse response
		=this.modelMapperService.forResponse().map(rendezvous, hospitalApp.hospitalApplication.business.responses.GetByIdRendezvousResponse.class);
		
		return response;
	}

	@Override
	public void takeRendezvous(int rendezvousId) {
		Rendezvous rendezvous=rendezvousRepository.findById(rendezvousId)
				.orElseThrow(()-> new BusinessException("Rendezvous not found"));
		
		if(rendezvous.getRendezvousStatus()==hospitalApp.hospitalApplication.entities.concretes.RendezvousStatus.TAKEN) {
			throw new BusinessException("Rendezvous is already taken");
		}
		rendezvous.setRendezvousStatus(RendezvousStatus.TAKEN); //durumu taken olarak güncelle
		rendezvousRepository.save(rendezvous); // güncellemeyi kaydet
		
		//rendezvousRepository.deleteById(rendezvousId);  // Randevuyu veritabanından silme
	}
//	@Override
//	public hospitalApp.hospitalApplication.business.responses.GetByIdRendezvousResponse getByIdRendezvousId(int rendezvousId) {
//		Rendezvous rendezvous=this.rendezvousRepository.findById(rendezvousId).orElseThrow();
//		
//		hospitalApp.hospitalApplication.business.responses.GetByIdRendezvousResponse response
//		=this.modelMapperService.forResponse().map(rendezvous, hospitalApp.hospitalApplication.business.responses.GetByIdRendezvousResponse.class);
//		
//		return response;
//	}

	

	

}