package hospitalApp.hospitalApplication.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hospitalApp.hospitalApplication.business.abstracts.AddressService;
import hospitalApp.hospitalApplication.business.requests.CreateAddressRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateAddressRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllAddressesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path="/api/addresses")
@AllArgsConstructor
public class AddressesController {
	
private AddressService addressService;

	
//	@Autowired    
//	public HospitalsController(HospitalService hospitalService) {
//		this.hospitalService = hospitalService;
//	} bunun yerine @AllArgsConstructor'u ekleyebiliriz
	
	//bu durumda istek controller'a yapılıyor
	//controller isteği uygun bulursa business'a gidip diyor ki
	//bu hastaneleri listelemek istiyor ne diyorsun iş kurallarını geçebiliyorsan verebilir diyor
	
	@GetMapping() //"/getAll"   data çekmek için kullanılır
	private List<GetAllAddressesResponse> getAll(){
		return addressService.getAll();
	}
	
	@GetMapping("/{addressId}") //{} içinde olduğunda variable olmuş oluyor
	public GetByIdAddressResponse getByAddressId(@PathVariable("addressId") int addressId) { //id'yi path'ten alacak
		return addressService.getByAddressId(addressId);
	}
	
	@PostMapping()  //"/add"  eklemeler için kullanılır
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateAddressRequest createAddressRequest) {
		this.addressService.add(createAddressRequest);
	}
	
	@PutMapping   //Güncelleme için kullanılıyor
	public void update(@RequestBody UpdateAddressRequest updateAddressRequest) {
		this.addressService.update(updateAddressRequest);
	}
	
	@DeleteMapping("/{addressId}")
	public void delete(@PathVariable("addressId") int addressId) {
		this.addressService.delete(addressId);
	}
}
