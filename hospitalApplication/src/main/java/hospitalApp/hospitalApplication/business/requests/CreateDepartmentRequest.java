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
public class CreateDepartmentRequest {
	@NotNull
	@NotBlank
	@Size(min=3,max=30)
	private String departmentName;
	
	private int hospitalId;
}
