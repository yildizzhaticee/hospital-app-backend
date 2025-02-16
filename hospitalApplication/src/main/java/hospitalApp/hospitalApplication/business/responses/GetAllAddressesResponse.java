package hospitalApp.hospitalApplication.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAddressesResponse {
	private int addressId; 
	private String addressName;
	private String hospitalName;
	private int hospitalId;
}
