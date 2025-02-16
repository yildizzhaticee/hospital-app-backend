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
public class CreateMedicineRequest {
	@NotNull
	@NotBlank
	@Size(min=2)
	private String medicineName;
	@NotNull
	@NotBlank
	@Size(min=2)
	private String medicineUse;
}
