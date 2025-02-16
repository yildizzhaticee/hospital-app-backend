package hospitalApp.hospitalApplication.business.requests;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiagnosisRequest {
	private Date diagnosisDate;
	@NotNull
	@NotBlank
	@Size(min=2)
	private String diagnosisDef;
	private int patientId;
	private int doctorId;
}
