package fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.IsUniqueGenericInterface;
import fle.toolBox.springFormManager.springMVCValidation.validationManagement.unique.dao.IsUniqueDao;



/**
 * 
 * @author Frederic Leroux <br>
 * @see {@link IsUniqueGenericInterface} and
 *      {@link IsUniqueGenericInterface#columnElementsList(String, String)}
 */
@Service
public class IsUniqueServiceImplemented implements IsUniqueService {

	@Autowired
	IsUniqueDao dao;

	@Override
	public List<Object> columnElementsList(String fieldName, String entityName) {
		return dao.columnElementsList(fieldName, entityName);
	}

}
