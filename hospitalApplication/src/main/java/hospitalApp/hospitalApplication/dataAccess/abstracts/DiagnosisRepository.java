package hospitalApp.hospitalApplication.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalApp.hospitalApplication.entities.concretes.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer>{

}
