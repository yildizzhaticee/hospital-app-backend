package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreateRendezvousRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateRendezvousRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllRendezvousesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdRendezvousResponse;

public interface RendezvousService {
	List<GetAllRendezvousesResponse> getAll();      	// response'dir ama veritabanı varliği döndürmek yasak
	GetByIdRendezvousResponse getByRendezvousId(int rendezvousId);
	void add(CreateRendezvousRequest createRendezvousRequest);
	void update(UpdateRendezvousRequest updateRendezvousRequest);
	void delete(int rendezvousId);
	void takeRendezvous(int rendezvousId);
}
