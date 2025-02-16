package hospitalApp.hospitalApplication.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //hospitalId'yi otomatik üretmesi için kullanıyoruz
	@Column(name="doctorId")
	private int doctorId;//PK
	
	@Column(name="doctorName")
	@NotBlank
	@NotNull
	private String doctorName;
	
	@Column(name="doctorSurname")
	@NotBlank
	@NotNull
	private String doctorSurname;
	
	@Column(name="doctorEmail")
	@Email
	@NotBlank
	@NotNull
	private String doctorEmail;
	
	@ManyToOne
	@JoinColumn(name="departmentId") 
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="hospitalId")
	private Hospital hospital;
	
	@OneToMany(mappedBy = "doctor")
	private List<Patient>patients;
	
	@OneToMany(mappedBy = "doctor")
	private List<Rendezvous>rendezvous;
	
	@OneToMany(mappedBy = "doctor")
	private List<Diagnosis> diagnosis;
	
	@OneToMany(mappedBy = "doctor")
	private List<Treatment> treatments;
	
}
