 package fle.toolBox.modelConverter;

import org.modelmapper.ModelMapper;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;
import fle.toolBox.classType.SLO;



public class ModelConverter {
	
	private  ModelMapper modelMapper = new ModelMapper();
	
	public  Object convertSourceToDestinationType(Object source, Object destinationType) {
		destinationType = modelMapper.map(source,destinationType.getClass());
		return destinationType;
	}
	
	@SuppressWarnings("unchecked")
	public<D extends DTO, E extends ENT>  D convertEntityToDTO(E entityClass, D DTOClass) {
		return   (D) convertSourceToDestinationType(entityClass, DTOClass);
	}
	
	@SuppressWarnings("unchecked")
	public<D extends DTO, E extends ENT> E convertDTOToEntity(D DTOClass, E entityClass) {
		return (E) convertSourceToDestinationType(DTOClass, entityClass);
	}
	
	@SuppressWarnings("unchecked")
	public<D extends DTO,S extends SFC>  D convertSFCToDTO(S SFCClass,D DTOClass ) {
		return  (D) convertSourceToDestinationType(SFCClass, DTOClass);
	}
	
	
	@SuppressWarnings("unchecked")
	public <D extends DTO,S extends SFC> S convertDTOToSFC(D DTOClass, S SFCClass) {
		return  (S) convertSourceToDestinationType(DTOClass, SFCClass);
		
	}
	
	public<E extends ENT,D extends DTO,S extends SFC> E convertSFCToENT(E entityClass, D DTOClass, S SFCClass) {
		return convertDTOToEntity(convertSFCToDTO(SFCClass, DTOClass), entityClass);
	}
	
	@SuppressWarnings("unchecked")
	public<L extends SLO> L convertObjectToSLO(L SLOClass, Object object) {
		return (L) convertSourceToDestinationType(object, SLOClass);
	}

}
