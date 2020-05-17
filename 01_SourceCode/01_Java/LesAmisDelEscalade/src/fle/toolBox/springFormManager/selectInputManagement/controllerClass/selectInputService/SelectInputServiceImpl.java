package fle.toolBox.springFormManager.selectInputManagement.controllerClass.selectInputService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.classType.DTO;
import fle.toolBox.classType.ENT;
import fle.toolBox.classType.SFC;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.selectInputDAO.SelectInputDAO;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools.SelectOptionsInterface;

@Service
public class SelectInputServiceImpl implements SelectInputService {

	@Autowired
	SelectInputDAO dao;

	@Override
	public <T extends ENT> List<T> tableRawData(String queryName) {
		return dao.tableRawData(queryName);
	}

	@Override
	public <T extends ENT, D extends DTO> List<D> selectInputDTOList(List<T> entityList, D dto) {
		return dao.selectInputDTOList(entityList, dto);
	}

	@Override
	public <T extends ENT, D extends DTO> List<D> selectInputDTOList(String queryName, D dto) {
		return dao.selectInputDTOList(queryName, dto);
	}

	@Override
	public <D extends DTO, S extends SFC> List<S> selectInputSFCList(List<D> dtoList, S sfc) {
		return dao.selectInputSFCList(dtoList, sfc);
	}

	@Override
	public <T extends ENT, D extends DTO, S extends SFC> List<S> selectInputSFCList(String queryName, D dto, S sfc) {
		return dao.selectInputSFCList(queryName, dto, sfc);
	}

	@Override
	public ArrayList<SelectOptionsInterface> selectInputOptionsList(String queryName, String valueFieldName,
			String displayValueFieldName) {
		return dao.selectInputOptionsList(queryName, valueFieldName, displayValueFieldName);
	}

}
