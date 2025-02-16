package hospitalApp.hospitalApplication.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDoctorRequest {
	private int doctorId;  //update yaparken id lazım
	private String doctorName;
	private String doctorSurname;
	private String doctorEmail;
	private int departmentId;
	private int hospitalId;
}
