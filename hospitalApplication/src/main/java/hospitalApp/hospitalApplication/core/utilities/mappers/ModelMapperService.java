package hospitalApp.hospitalApplication.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponse();
	ModelMapper forRequest();
}
//veritabanından gelen her şeyin map edilmesi gerekmiyor.
//ama request'ten gelen her şeyin map edilmesini isteyebiliriz.
//Böyle durumlarda mapperlar için durumlar yazılabiliyor