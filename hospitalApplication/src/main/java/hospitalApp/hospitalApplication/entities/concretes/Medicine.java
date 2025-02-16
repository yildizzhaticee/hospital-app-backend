package hospitalApp.hospitalApplication.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="medicines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="medicineId")
	private int medicineId;//PK
	
	@Column(name="medicineName")
	private String medicineName;
	
	@Column(name="medicineUse")
	private String medicineUse;
	
	@OneToMany(mappedBy = "medicine")
	private List<Treatment>treatments;
}
