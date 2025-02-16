 package hospitalApp.hospitalApplication;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import hospitalApp.hospitalApplication.core.utilities.exceptions.BusinessException;
import hospitalApp.hospitalApplication.core.utilities.exceptions.ProblemDetails;
import hospitalApp.hospitalApplication.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	
	//Business hatası olursa tüm hata bilgilerini dökme bir nesne oluştur onu döndür. AOP
	@ExceptionHandler //bir hata oluşursa buradan geçeceğini bilecek
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	
	@ExceptionHandler 
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();		
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return validationProblemDetails;
	}
	
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}

// uygulama açıldığında gider bu anatasyonları tarar @Bean'ı gördüğünde
//bu bir nesne zamanla biri constructorûnda ihtiyaç duyacak. Bunu IoC kutusunu ekleyelim
//@Bean gördüğünde onu IoC'ye ekler

//data access=>Veriye erişimle uğraşıyor.SQL'i yazdığımız kısım bura.

//business=> iş kuralları burada. Hangi vertabanıyla uğraşırsan uğraş iş kuralları aynıdır.
//business to business(B2B) uygulamaların birbirleriyle etkileşimleri

//UI(user interface)&Presentation=> Uygulamayı açtığımızda gördüğümüz ekran bizim arayüzümüz.

//UI ve business arasında iletişimi sağlayacak katman =>api
//api'ler farklı sistemlerin birbiriyle iletişim kurabilmesi için kullanılan yapılardır. JSON'ı api'ler ile yapacağız


//paketler
//entities=> veritabanı nesneleri
//dataAccess=>veri erişim kodlarını bu pakate yazıyoruz abstract-Repository
//business=>iş kodları buraya yazılıyor
//webApi
//concretes=>somut,gerçek işi yapacaklar bunun içerisine yazılacak
//abstract=> soyut işleri yapmak için kullanılacak

//repository diye bir şey görürsen bu genellikle veritabanı işleri yapacak sınıflara verdiğimiz isimlerdir. Bunlar dao olarak da adlandırılabilir

//son kullanıcıya olduğu gibi veritabanı entity'sini açmak doğru değil
//görmesini istememdiğimiz bilgiler olabilir

//core=> tüm projede ortak kod için kullanılıyor exception ve mappers paketleri bunun altında yazılıyor
//mapper ile ilgili kullanacağımız araçları utilities altına yazarız

//Bizim kullandığımız request ve response DTO(data transformation object) olmuş oluyorlar  business altında yazıyoruz


//hazır veri tabanı varsa application properties içerisindeki ddl-auto kısmını silmen gerekebilir
// eğer ddl-auto=update şeklinde bırakırsan veritabanını alt üst edebilirsin


//Entity oluştur => dataAccess/abstract/PatientRepository.java interface'i oluştur=>
//business/abstract/PatientService interface=>
//business/concrete/PatientManager class=>
//webApi.controllers/PatientsController

