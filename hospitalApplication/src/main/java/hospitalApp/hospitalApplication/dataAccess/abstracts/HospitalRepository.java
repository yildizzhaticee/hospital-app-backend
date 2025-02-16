package hospitalApp.hospitalApplication.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hospitalApp.hospitalApplication.entities.concretes.Hospital;

@Repository //zorunlu değil ama yazabilirsin
public interface HospitalRepository extends JpaRepository<Hospital,Integer>{  //Hospital'ın id'si veri tabanında integer'a karşılık geliyor
	boolean existsByHospitalName(String hospitalName);  //spring jpa keywords
	//varsa true, yoksa false döndürüyor. exists var olamayı anlatır
	//List<Hospital> findByName(String hospitalName);
}







// bir interface başka bir interface'i extend eder.
//Jpa'yı kullanarak veri işlemlerini çok efektif olarak halledebiliyoruz


//Hospital'ın id'si primary key olacak o nedenle<Hospital,Integer> şeklinde yaptık
	//Birden fazla hastane görüntüleyebileceğimiz için bunun array bazlı olması gerekiyor
	
	//List<Hospital> getAll(); //getAll()'ı çağıran biri hastaneleri listeler
	//üst satırı sildik çünkü spring jpa'dan gerekli metotları kalıtacağız