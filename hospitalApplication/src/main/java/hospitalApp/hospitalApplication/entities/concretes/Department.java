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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //hospitalId'yi otomatik üretmesi için kullanıyoruz
	@Column(name="departmentId")
	private int departmentId;//PK
	
	@Column(name="departmentName")
	private String departmentName;
	
	@ManyToOne
	@JoinColumn(name="hospitalId")  //hospital_id
	private Hospital hospital;
	
	@OneToMany(mappedBy="department")
	private List<Doctor> doctors;  //Bir departmanda birden faxla doktor olabilir.
	
	@OneToMany(mappedBy = "department")
	private List<Rendezvous>rendezvous;
	
	@OneToMany(mappedBy = "department")
	private List<Treatment>treatments;
	
}
