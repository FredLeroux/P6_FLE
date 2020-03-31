package std.fle._05_controller._02_AccountMAnagementController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import fle.toolBox.springFormManager.springMVCValidation.SpringMVCValidation;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._07_service.UserService;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;

@Controller
public class UserSFCController {

	@Autowired
	SelectInputForController select;
	
	@Autowired
	SpringMVCValidation validation;
	
	@Autowired
	UserService user;
	
	
	

	@GetMapping(value = "/02_AccountManagement/userFormRegister")
	public ModelAndView initUserForm(ModelAndView model, @ModelAttribute(value = "userManagement") UserSFC userSFC) {
		model.setViewName("02_AccountManagement/userFormRegister");
		select.addSelectListsAndValues(userSFC, model);
		return model;
	}
	
	@PostMapping(value = "/02_AccountManagement/filterCountiesList")
	public ModelAndView countiesList(ModelAndView model,@ModelAttribute(value = "userManagement") UserSFC userSFC) {
		if(select.formError()) {
			model.setViewName("forward:/02_AccountManagement/userCreation");
			return model;
		}
		model.setViewName("02_AccountManagement/userFormRegister");
		select.upDateSelectListAndValue(userSFC, model);
		return model;
	}
	
	@PostMapping(value ="/02_AccountManagement/userCreation")
	public ModelAndView createUser(ModelAndView model, @ModelAttribute(value = "userManagement") @Validated UserSFC userSFC,BindingResult result) {
		validation.SpringMVCValidationCheck(userSFC, result);
		if(result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			model.setViewName("02_AccountManagement/userFormRegister");
			select.selectListAndValueOnBindingError(userSFC, model);
			return model;
		}
		user.save(userSFC);
		model.setViewName("redirect:/02_AccountManagement/userFormRegister");
		return model;
	}

}
