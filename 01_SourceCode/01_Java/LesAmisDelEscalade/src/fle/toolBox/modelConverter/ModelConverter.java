 package fle.toolBox.modelConverter;

import org.modelmapper.ModelMapper;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;



public class ModelConverter {
	
	private  ModelMapper modelMapper = new ModelMapper();
	
	public  Object convertSourceToDestinationType(Object source, Object destinationType) {
		destinationType = modelMapper.map(source,destinationType.getClass());
		return destinationType;
	}
	
	public  DTO convertEntityToDTO(ENT entityClass, DTO DTOClass) {
		return   (DTO) convertSourceToDestinationType(entityClass, DTOClass);
	}
	
	public  ENT convertDTOToEntity(DTO DTOClass, ENT entityClass) {
		return (ENT) convertSourceToDestinationType(DTOClass, entityClass);
	}
	
	public  DTO converSFCToDTO(SFC SFCClass,DTO DTOClass ) {
		return (DTO) convertSourceToDestinationType(SFCClass, DTOClass);
	}
	
	
	public  SFC converDTOToSFC(DTO DTOClass, SFC SFCClass) {
		return  (SFC) convertSourceToDestinationType(DTOClass, SFCClass);
		
	}

}
