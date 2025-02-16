package hospitalApp.hospitalApplication.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMedicineRequest {
	private int medicineId;
	private String medicineName;
	private String medicineUse;
}
