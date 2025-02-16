package hospitalApp.hospitalApplication.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHospitalRequest {
	private int hospitalId;  //update yaparken id lazım
	private String hospitalName;
	private String hospitalTel;
}
