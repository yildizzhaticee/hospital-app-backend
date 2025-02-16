package hospitalApp.hospitalApplication.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllHospitalsResponse {
	private int hospitalId;
	private String hospitalName;
	private String hospitalTel;

}
