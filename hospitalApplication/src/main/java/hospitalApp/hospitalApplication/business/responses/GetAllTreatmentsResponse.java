package hospitalApp.hospitalApplication.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTreatmentsResponse {
	private int treatmentId;
	private String treatmentDef;
	private int patientId;
	private int doctorId;
	private int departmentId;
	private int medicineId;
}
