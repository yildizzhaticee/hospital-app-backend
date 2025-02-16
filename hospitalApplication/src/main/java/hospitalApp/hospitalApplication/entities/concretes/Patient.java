package hospitalApp.hospitalApplication.entities.concretes;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="patients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //hospitalId'yi otomatik üretmesi için kullanıyoruz
	@Column(name="patientId")
	private int patientId;
	
	@Column(name="patientName")
	private String patientName;
	
	
	@Column(name="patientSurname")
	private String patientSurname;
	
	@Column(name="patientTel")
	private String patientTel;
	
	@Column(name="patientEmail")
	private String patientEmail;
	
	@ManyToOne
	@JoinColumn(name="hospitalId")  //hospital_id
	private Hospital hospital;
	
	@ManyToOne
	@JoinColumn(name="doctorId")
	private Doctor doctor;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rendezvousId", referencedColumnName = "rendezvousId")
	private Rendezvous rendezvous;
	
	
	@OneToMany(mappedBy = "patient")
	private List<Diagnosis> diagnosis;
	
	@OneToMany(mappedBy = "patient")
	private List<Treatment> treatments;
	
	
	
	
	
}
