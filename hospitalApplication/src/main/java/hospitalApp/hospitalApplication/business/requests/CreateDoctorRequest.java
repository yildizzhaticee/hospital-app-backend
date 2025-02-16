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
public class CreateDoctorRequest {
	@NotNull
	@NotBlank
	@Size(min=3,max=30)
	private String doctorName;
	@NotNull
	@NotBlank
	@Size(min=3,max=30) //bunların devreye girmesi için add()'e @Valid() anatasyonunu eklemen gerekiyor
	private String doctorSurname;
	@NotNull
	@NotBlank
	@Size(min=3,max=30) //bunların devreye girmesi için add()'e @Valid() anatasyonunu eklemen gerekiyor
	private String doctorEmail;
	
	private int departmentId;
	private int hospitalId;
	
}
