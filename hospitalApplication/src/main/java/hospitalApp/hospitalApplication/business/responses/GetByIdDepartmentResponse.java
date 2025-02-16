package hospitalApp.hospitalApplication.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdDepartmentResponse {
	private int departmentId;
	private String departmentName;
	private int hospitalId;
	private String hospitalName;
}
