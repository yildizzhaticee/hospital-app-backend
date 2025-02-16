package hospitalApp.hospitalApplication.entities.concretes;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;  //persistance deyince veriyi bir yerlere kaydetmek anlamına geliyor
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="hospitals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hospital {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //hospitalId'yi otomatik üretmesi için kullanıyoruz
	@Column(name="hospitalId")
	private int hospitalId;//PK
	
	@Column(name="hospitalName")
	private String hospitalName;
	
	@Column(name="hospitalTel")
	private String hospitalTel;
	
	//alt satıra yazılacak ilişkilendirme ismi olduğun tablo ile referans alınan tablo arasında olur olduğun nesne ilk yazılır
	@OneToMany(mappedBy="hospital")
	private List<Department> departments;  //Bir hastanenin departmanları var.
	
	@OneToMany(mappedBy="hospital")
	private List<Doctor>doctors;
	
	@OneToMany(mappedBy="hospital")
	private List<Patient>patients;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId", referencedColumnName = "addressId")
	private HospitalAddress hospitalAddress;
	
	@OneToMany(mappedBy="hospital")
	private List<Rendezvous>rendezvous;
	
}

// @Data => getter ve setter'ları oluştur demek
//@Data=> @Getter+@Setter+@NoArgsConstructor
//@Id =>  Veritabanında PK olduğunu belirtiyor
// @GeneratedValue(strategy = GenerationType.IDENTITY)  =>  id'yi birer birer artır demek nasıl artıracağını belirtiyorsun.id otomatik diyorsun
//@Entity  =>Bir veritabanı varlığı olduğunu bildiriyor
//her entity içni bir repository yazmalısınız eğer işlem yapacaksanız fakat o entity üzerinden işlem yapmayacaksanız repository yazmaya gerek yok
