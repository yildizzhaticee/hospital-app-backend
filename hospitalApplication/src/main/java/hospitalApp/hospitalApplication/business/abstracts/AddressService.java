package hospitalApp.hospitalApplication.business.abstracts;

import java.util.List;

import hospitalApp.hospitalApplication.business.requests.CreateAddressRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateAddressRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllAddressesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdAddressResponse;


public interface AddressService {
	List<GetAllAddressesResponse> getAll();      	// response'dir ama veritabanı varliği döndürmek yasak
	GetByIdAddressResponse getByAddressId(int addressId);
	void add(CreateAddressRequest createAddressRequest);
	void update(UpdateAddressRequest updateAddressRequest);
	void delete(int addressId);
}
