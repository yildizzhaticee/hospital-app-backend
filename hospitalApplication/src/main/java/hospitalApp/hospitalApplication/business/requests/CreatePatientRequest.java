package hospitalApp.hospitalApplication.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRequest {
	
	
	@NotNull
	@NotBlank
	@Size(min=2,max=20)
	private String patientName;
	
	@NotNull
	@NotBlank
	@Size(min=2,max=30)
	private String patientSurname;
	
	@NotNull
	@NotBlank
	@Size(min=3,max=15)
	private String patientTel;
	
	@NotNull
	@NotBlank
	@Size(min=10,max=30)
	private String patientEmail;

	private int hospitalId;

	private int doctorId;
}
