package hospitalApp.hospitalApplication.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalApp.hospitalApplication.entities.concretes.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	boolean existsByDepartmentName(String departmentName);  //spring jpa keywords

}
