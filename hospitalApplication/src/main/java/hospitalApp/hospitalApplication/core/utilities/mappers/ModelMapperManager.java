package hospitalApp.hospitalApplication.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

	private ModelMapper modelMapper;//Bi tane ModelMapper üretsin onu kullansın mantığında
	
	
	//Aşağıdaki kodlar sadece stratejiyi oluşturmak içindir.
	//Biri gevşek, diğeri standart
	
	@Override
	public ModelMapper forResponse() {  //gevşek map'leme yap. Map'lenmeyen varsa onları yapma
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {  //her şey map'lensin,her şeyin bir karşılığı olsun yoksa hata üret
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		
		return this.modelMapper;
	}

}

//strict tanımlanırsa strategi  her şeyi map'lemesi gerekiyor.
//iki nesnenin %100  aynı olması gerekiyor

