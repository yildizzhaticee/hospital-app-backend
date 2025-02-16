package hospitalApp.hospitalApplication.business.rules;

import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Service;

import hospitalApp.hospitalApplication.core.utilities.exceptions.BusinessException;
import hospitalApp.hospitalApplication.dataAccess.abstracts.RendezvousRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RendezvousBusinessRules {
	private RendezvousRepository rendezvousRepository;
	
	public void checkIfRendezvousIdExists(int rendezvousId) {
		if(this.rendezvousRepository.existsByRendezvousId(rendezvousId)) {
			throw new BusinessException("Rendezvous already exists");
		}
	}
	public void checkIfRendezvousTimeAvailable(Date rendezvousDate, Time rendezvousTime) {
        if(this.rendezvousRepository.existsByRendezvousDateAndRendezvousTime(rendezvousDate, rendezvousTime)) {
            throw new BusinessException("Rendezvous at this date and time is already booked");
        }
    }
}
