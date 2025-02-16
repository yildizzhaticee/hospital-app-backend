package hospitalApp.hospitalApplication.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hospitalApp.hospitalApplication.business.abstracts.RendezvousService;
import hospitalApp.hospitalApplication.business.requests.CreateRendezvousRequest;
import hospitalApp.hospitalApplication.business.requests.UpdateRendezvousRequest;
import hospitalApp.hospitalApplication.business.responses.GetAllRendezvousesResponse;
import hospitalApp.hospitalApplication.business.responses.GetByIdRendezvousResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path="/api/rendezvouses")
@AllArgsConstructor
public class RendezvousesController {
	private RendezvousService rendezvousService;
	
	@GetMapping()
	private List<GetAllRendezvousesResponse> getAll(){
		return rendezvousService.getAll();
	}
	
	@GetMapping("/{rendezvousId}")
	public GetByIdRendezvousResponse getByRendezvousId(@PathVariable("rendezvousId") int rendezvousId) {
		return rendezvousService.getByRendezvousId(rendezvousId);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateRendezvousRequest createRendezvousRequest) {
		this.rendezvousService.add(createRendezvousRequest);
	}
	
	@PutMapping   //Güncelleme için kullanılıyor
	public void update(@RequestBody UpdateRendezvousRequest updateRendezvousRequest) {
		this.rendezvousService.update(updateRendezvousRequest);
	}
	
	@DeleteMapping("/{rendezvousId}")
	public void delete(@PathVariable("rendezvousId") int rendezvousId) {
		this.rendezvousService.delete(rendezvousId);
	}
	
	@DeleteMapping("/{rendezvousId}/takeAndDelete")
	public void takeRendezvous(@PathVariable("rendezvousId") int rendezvousId) {
		this.rendezvousService.takeRendezvous(rendezvousId);
	}
}
