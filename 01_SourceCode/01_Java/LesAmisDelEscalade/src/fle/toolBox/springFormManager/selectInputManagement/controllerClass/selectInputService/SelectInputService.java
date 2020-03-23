package fle.toolBox.springFormManager.selectInputManagement.controllerClass.selectInputService;

import java.util.ArrayList;
import java.util.List;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptionsInterface;



public interface SelectInputService {

	public <T extends ENT> List<T> tableRawData(String queryName);

	public <T extends ENT, D extends DTO> List<D> selectInputDTOList(List<T> entityList, D dto);

	public <T extends ENT, D extends DTO> List<D> selectInputDTOList(String queryName, D dto);

	public <D extends DTO, S extends SFC> List<S> selectInputSFCList(List<D> dtoList, S sfc);

	public <T extends ENT, D extends DTO, S extends SFC> List<S> selectInputSFCList(String queryName, D dto, S sfc);
	
	public  ArrayList<SelectOptionsInterface> selectInputOptionsList(String queryName,
			String valueFieldName, String displayValueFieldName);
}
