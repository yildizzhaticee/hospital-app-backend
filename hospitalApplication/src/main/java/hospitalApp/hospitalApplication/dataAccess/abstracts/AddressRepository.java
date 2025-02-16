package hospitalApp.hospitalApplication.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalApp.hospitalApplication.entities.concretes.HospitalAddress;

public interface AddressRepository extends JpaRepository<HospitalAddress, Integer>{
	boolean existsByAddressName(String addressName);  //spring jpa keywords
	boolean existsByAddressId(int addressId);
}
