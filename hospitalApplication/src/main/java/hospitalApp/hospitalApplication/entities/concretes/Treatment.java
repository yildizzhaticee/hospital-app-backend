package hospitalApp.hospitalApplication.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Tedavi

@Table(name="treatments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Treatment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //hospitalId'yi otomatik üretmesi için kullanıyoruz
	@Column(name="treatmentId")
	private int treatmentId;//PK
	
	@Column(name="treatmentDef")
	private String treatmentDef;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctorId")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="medicineId")
	private Medicine medicine;
}
