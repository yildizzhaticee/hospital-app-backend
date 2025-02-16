package hospitalApp.hospitalApplication.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPatientsResponse {
	private int patientId;
	private String patientName;
	private String patientSurname;
	private String patientTel;
	private String patientEmail;
	private int hospitalId;
	private int doctorId;
}
