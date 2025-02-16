package hospitalApp.hospitalApplication.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalApp.hospitalApplication.entities.concretes.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer>{
	boolean existsByMedicineName(String medicineName);  //spring jpa keywords

}
