package hospitalApp.hospitalApplication.dataAccess.abstracts;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalApp.hospitalApplication.entities.concretes.Rendezvous;

public interface RendezvousRepository extends JpaRepository<Rendezvous, Integer>{
	boolean existsByRendezvousId(int rendezvousId);
    boolean existsByRendezvousDateAndRendezvousTime(Date rendezvousDate, Time rendezvousTime);
}
