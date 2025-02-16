package hospitalApp.hospitalApplication.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateHospitalRequest {
	@NotNull
	@NotBlank
	@Size(min=3,max=30)
	private String hospitalName;
	@NotNull
	@NotBlank
	@Size(min=3,max=30) //bunların devreye girmesi için add()'e @Valid() anatasyonunu eklemen gerekiyor
	private String hospitalTel;
}

//Şöyle bir hastane daha var onu da ekler misin anlamındaki istek
//Sizin girdiğiniz data'lar olduğu için request

//api'yi kullanan son kullanıcıdan data alıyorsan o request ; ona bir şey veriyorsan o response


//son kullanıcıdan hospitalId'yi istemeye gerek yok o otomatik olarak artıyor zaten
//son kullanıcı id'yi bilmiyor