package hospitalApp.hospitalApplication.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDoctorsResponse {
	private int doctorId;  
	private String doctorName;
	private String doctorSurname;
	private String doctorEmail;
	private int departmentId;
	private int hospitalId;
}
