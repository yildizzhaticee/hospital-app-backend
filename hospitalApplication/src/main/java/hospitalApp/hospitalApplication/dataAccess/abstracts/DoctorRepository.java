package hospitalApp.hospitalApplication.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalApp.hospitalApplication.entities.concretes.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
