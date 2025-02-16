package hospitalApp.hospitalApplication.business.requests;

import java.sql.Date;
//import java.util.Date;
import java.sql.Time;

import hospitalApp.hospitalApplication.entities.concretes.RendezvousStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRendezvousRequest {
	private int rendezvousId;
	private Date rendezvousDate;
	private Time rendezvousTime;
	private RendezvousStatus randezvousStatus;
	private int hospitalId;
	private int doctorId;
	private int departmentId;
}
