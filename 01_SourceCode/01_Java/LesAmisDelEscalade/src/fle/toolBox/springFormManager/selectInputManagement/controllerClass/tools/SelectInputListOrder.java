package fle.toolBox.springFormManager.selectInputManagement.controllerClass.tools;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;



public class SelectInputListOrder extends SelectInputList {
	
	@Autowired
	protected MessageSource messageSource;

	
	
	private SelectOptionsListOrder selectListOrder = new SelectOptionsListOrder();
	
	
	protected <S extends SelectOptionsInterface> ArrayList<S> listOrderedByValue(Field field){
		return new ArrayList<>( selectListOrder.byValue(getSelectOptionsList(field)));
	}
	
	protected <S extends SelectOptionsInterface> ArrayList<S> listOrderedByDisplayValue(Field field){
		return new ArrayList<>( selectListOrder.byDisplayValue(getSelectOptionsList(field)));
	}
	
	protected <S extends SelectOptionsInterface> ArrayList<S> listOrderedByDisplayValueI18N(Field field){		
		return new ArrayList<>( selectListOrder.byDisplayValueI18N(getSelectOptionsList(field), messageSource, messageSourceSuffix(field)));
	}
	

}
