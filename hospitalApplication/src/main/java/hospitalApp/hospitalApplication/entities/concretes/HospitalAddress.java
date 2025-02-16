package hospitalApp.hospitalApplication.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HospitalAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //hospitalId'yi otomatik üretmesi için kullanıyoruz
	@Column(name="addressId")
	private int addressId;//PK
	
	@Column(name="addressName")
	private String addressName;
	
	@OneToOne(mappedBy = "hospitalAddress")
	private Hospital hospital;
	
}
