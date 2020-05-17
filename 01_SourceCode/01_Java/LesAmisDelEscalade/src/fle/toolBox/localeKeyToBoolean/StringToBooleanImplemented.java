package fle.toolBox.localeKeyToBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.Internationalization.LocalMessage;

@Service
public class StringToBooleanImplemented implements StringToBoolean {

	@Autowired
	LocalMessage localMessage;
	
	
	@Override
	public Boolean localKey(String toConvert, String trueKey, String falseKey) {		
			return converter(toConvert, localMessage.message(trueKey), localMessage.message(falseKey));
	}


	@Override
	public Boolean String(String toConvert, String trueString,String falseString) {		
		return converter(toConvert, trueString, falseString);
	}
	
	
	 private Boolean converter(String toConvert, String trueString,String falseString) {
		 Boolean converted = null;
			if(toConvert.equals(trueString)) {
				converted =  true;
			}else if(toConvert.equals(falseString)) {
				converted = false;
			}
			return converted;
	 }
	
	
	
}
