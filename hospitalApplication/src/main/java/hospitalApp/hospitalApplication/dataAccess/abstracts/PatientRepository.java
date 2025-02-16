package hospitalApp.hospitalApplication.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalApp.hospitalApplication.entities.concretes.Patient;


public interface PatientRepository extends JpaRepository<Patient, Integer>{
	boolean existsByPatientTel(String patientTel);
}
//repository=>genellikle veritabanı işleri yapacak sınıflara verilen isim
//repository=> bu sınıf bir data access nesnesidir