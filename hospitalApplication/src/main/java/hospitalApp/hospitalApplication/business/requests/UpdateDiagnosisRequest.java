package hospitalApp.hospitalApplication.business.requests;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDiagnosisRequest {
	private int diagnosisId;
	private Date diagnosisDate;
	private String diagnosisDef;
	private int patientId;
	private int doctorId;
}
