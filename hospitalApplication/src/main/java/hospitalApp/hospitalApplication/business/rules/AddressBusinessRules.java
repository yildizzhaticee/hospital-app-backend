package hospitalApp.hospitalApplication.business.rules;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.core.utilities.exceptions.BusinessException;
import hospitalApp.hospitalApplication.dataAccess.abstracts.AddressRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressBusinessRules {
private AddressRepository addressRepository;
	
	public void checkIfAddressNameExists(String addressName) {
		if(this.addressRepository.existsByAddressName(addressName)) {
			throw new BusinessException("Address name already exists");
		}
	}
	
	public void checkIfAddressExists(int addressId) {
		if(!addressRepository.existsByAddressId(addressId)) {
			throw new BusinessException("Address not found");
		}
	}
}
