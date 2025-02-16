package hospitalApp.hospitalApplication.entities.concretes;
//Teşhis

import java.sql.Date;

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

@Table(name="diagnosis")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Diagnosis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //hospitalId'yi otomatik üretmesi için kullanıyoruz
	@Column(name="diagnosisId")
	private int diagnosisId;//PK
	
	@Column(name="diagnosisDate")
	private Date diagnosisDate;
	
	@Column(name="diagnosisDef")
	private String diagnosisDef;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctorId")
	private Doctor doctor;
}

//@Column(name="plate", unique=true)
