package hospitalApp.hospitalApplication.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressRequest {
	private int addressId;  //update yaparken id lazım
	private String addressName;
	private String hospitalName;
	private int hospitalId;
}
