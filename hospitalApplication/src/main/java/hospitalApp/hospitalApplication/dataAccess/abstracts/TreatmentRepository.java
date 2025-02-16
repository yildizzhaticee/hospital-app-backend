package hospitalApp.hospitalApplication.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalApp.hospitalApplication.entities.concretes.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer>{

}
