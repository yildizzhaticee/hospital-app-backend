package hospitalApp.hospitalApplication.entities.concretes;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="rendezvous")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rendezvous {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //hospitalId'yi otomatik üretmesi için kullanıyoruz
	@Column(name="rendezvousId")
	private int rendezvousId;
	
	@Column(name="rendezvousDate")
	private Date rendezvousDate;
	
	@Column(name="rendezvousTime")
	private Time rendezvousTime;
	
	@Column(name="rendezvousState")
	private RendezvousStatus rendezvousStatus = RendezvousStatus.AVALIABLE; //varsayılan olarak AVALIABLE  
	
	@OneToOne(mappedBy = "rendezvous")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="hospitalId")  //hospital_id
	private Hospital hospital;
	
	@ManyToOne
	@JoinColumn(name="doctorId")  
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	
	
}

