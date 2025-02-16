package hospitalApp.hospitalApplication.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdMedicineResponse {
	private int medicineId;
	private String medicineName;
	private String medicineUse;
}
