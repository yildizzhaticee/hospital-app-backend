package hospitalApp.hospitalApplication.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.business.abstracts.AddressService;
import hospitalApp.hospitalApplication.business.requests.CreateAddressRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateAddressRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllAddressesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdAddressResponse;
import hospitalApp.hospitalApplication.business.rules.AddressBusinessRules;
import hospitalApp.hospitalApplication.core.utilities.mappers.ModelMapperService;
import hospitalApp.hospitalApplication.dataAccess.abstracts.AddressRepository;
import hospitalApp.hospitalApplication.entities.concretes.HospitalAddress;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService{
	private  AddressRepository addressRepository;
	private ModelMapperService modelMapperService;
	private AddressBusinessRules addressBusinessRules;
	
	@Override
	public List<GetAllAddressesResponse> getAll() {
		
		List<HospitalAddress> addresses=addressRepository.findAll();
			
		List<GetAllAddressesResponse> addressesResponse=addresses.stream()
				.map(address->this.modelMapperService.forResponse()
						.map(address,GetAllAddressesResponse.class)).collect(Collectors.toList());	
		
		return addressesResponse;
	}


	@Override
	public void add(CreateAddressRequest createAddressRequest) {
		this.addressBusinessRules.checkIfAddressNameExists(createAddressRequest.getAddressName());
		
		HospitalAddress address=this.modelMapperService.forRequest().map(createAddressRequest, HospitalAddress.class);
		
		this.addressRepository.save(address);
		//veritabanı hospital'dan anlıyor
	}


	@Override
	public GetByIdAddressResponse getByAddressId(int addressId) {
		HospitalAddress address=this.addressRepository.findById(addressId).orElseThrow();  //bulamazsan hata fırlat
		
		GetByIdAddressResponse response
		=this.modelMapperService.forResponse().map(address, GetByIdAddressResponse.class);
		
		return response;
	}


	@Override
	public void update(UpdateAddressRequest updateAddressRequest) {
		addressBusinessRules.checkIfAddressExists(updateAddressRequest.getAddressId());
		HospitalAddress address=this.modelMapperService.forRequest().map(updateAddressRequest, HospitalAddress.class);
		this.addressRepository.save(address); //id'de olduğu için update yapar
	}


	@Override
	public void delete(int addressId) {
		this.addressRepository.deleteById(addressId);
	}

}
