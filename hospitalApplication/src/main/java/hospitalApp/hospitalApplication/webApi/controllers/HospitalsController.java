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

import hospitalApp.hospitalApplication.business.abstracts.HospitalService;
import hospitalApp.hospitalApplication.business.requests.CreateHospitalRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateHospitalRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllHospitalsResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdHospitalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/hospitals")
@AllArgsConstructor
public class HospitalsController {
	private HospitalService hospitalService;

	
//	@Autowired    
//	public HospitalsController(HospitalService hospitalService) {
//		this.hospitalService = hospitalService;
//	} bunun yerine @AllArgsConstructor'u ekleyebiliriz
	
	//bu durumda istek controller'a yapılıyor
	//controller isteği uygun bulursa business'a gidip diyor ki
	//bu hastaneleri listelemek istiyor ne diyorsun iş kurallarını geçebiliyorsan verebilir diyor
	
	@GetMapping() //"/getAll"   data çekmek için kullanılır
	private List<GetAllHospitalsResponse> getAll(){
		return hospitalService.getAll();
	}
	
	@GetMapping("/{hospitalId}") //{} içinde olduğunda variable olmuş oluyor
	public GetByIdHospitalResponse getByHospitalId(@PathVariable("hospitalId") int hospitalId) { //id'yi path'ten alacak
		return hospitalService.getByHospitalId(hospitalId);
	}
	
	@PostMapping()  //"/add"  eklemeler için kullanılır
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateHospitalRequest createHospitalRequest) {
		this.hospitalService.add(createHospitalRequest);
	}
	
	@PutMapping   //Güncelleme için kullanılıyor
	public void update(@RequestBody UpdateHospitalRequest upddateHospitalRequest) {
		this.hospitalService.update(upddateHospitalRequest);
	}
	
	@DeleteMapping("/{hospitalId}")
	public void delete(@PathVariable("hospitalId") int hospitalId) {
		this.hospitalService.delete(hospitalId);
	}
	
}

//restful yapılar için controller olduğunu buna söylememiz gerekiyor
//bunun için springframewrok devreye giriyor
//restcontroller anatasyonunu görünce bunun erişim noktası olduğunu düşünüyor

//data access ,business içerisinde kullanıldı constructor ile
//business'ı da api çağıracak

// @Autowired =>git ilgili metodun parametrelerine bak,
// uygulamayı tara kim bu parametreyi implemente ediyor,
//onun new'lenmiş halini bana ver

//swagger ve postman ikisinin de amacı api isteği yapmak ama postman daha profesyonel 

//postgre'nin default port'u 5432

//@PathVariable=> Git oradaki path'ten al demek


