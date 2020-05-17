package std.fle._0x_controller.controllerClass.climbingSiteController.climbingFormsValidation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.FredParser;
import fle.toolBox.Internationalization.LocalMessage;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;

@Service
public class ClimbingFormsValidationImplemented implements ClimbingFormsValidation {

	@Autowired
	LocalMessage locale;
	
	private List<String> specificErrorList = new ArrayList(); 
	private String pitchError = null;
	
	
	@Override
	public String checkPitchExistence(List<RoutePitchSFC> list, RoutePitchSFC toCheck){
		pitchError = "";
		pitchExistenceError(pitchError,list, toCheck);
		return pitchError;
	}
	
	private void pitchExistenceError(String error, List<RoutePitchSFC> list, RoutePitchSFC toCheck) {		
		list.forEach(o -> {
			if(o.equals(toCheck)) {
				pitchError= "erreur existe déjà!!!";//locale.message("pitchAlreadyExist.error");
			}
		});		
	}
	
	public Boolean routePitchSFCCheck(RoutePitchSFC elemt1, RoutePitchSFC elemt2) {
		return elemt1.equals(elemt2);
	}
	
	
	private void checkNumberOfRoutes(ClimbingSiteSFC climbingSiteSFC ) {
		if(climbingSiteSFC.getNumberOfRoutes()==0) {
			specificErrorList.add( locale.message("numbersOfRoutes.error"));
		}
	}
	
	private void checkHeightMinAndMax(ClimbingSiteSFC climbingSiteSFC) {
		
	}
	
	private Boolean minAndMax(String min,String max) {
		return FredParser.toInteger(min)<FredParser.toInteger(max);
	}
	
}
