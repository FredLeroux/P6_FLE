package std.fle._05_controller._02_AccountMAnagementController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import fle.toolBox.springFormManager.springMVCValidation.SpringMVCValidation;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassModifSFC;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;
import std.fle._05_controller.SessionVariables;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserService;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserUpdateService;
import std.fle._09_mailCreation.MailCreator;
import std.fle._0X_security.PassEncoder;

@Controller
public class UserSFCController {

	@Autowired
	LocalMessage local;

	@Autowired
	SelectInputForController select;

	@Autowired
	SpringMVCValidation validation;

	@Autowired
	UserService userService;

	@Autowired
	UserUpdateService userUpdate;

	@Autowired
	UsersAccountInfoService usersAccountInfoservice;

	@Autowired
	MailCreator mail;
	
	@Autowired
	PassEncoder encoder;

	@GetMapping(value = "/02_AccountManagement/userFormRegister")
	public ModelAndView initUserForm(ModelAndView model, @ModelAttribute(value = "userManagement") UserSFC userSFC,
			HttpServletRequest request) {
		model.setViewName("02_AccountManagement/userFormRegister");
		select.addSelectListsAndValues(userSFC, model);
		return model;
	}

	@GetMapping(value = "/02_AccountManagement/userFormUpdate")
	public ModelAndView initUserUpdateForm(ModelAndView model,
			@ModelAttribute(value = "userManagement") UserUpdateSFC userUpdateSFC, HttpServletRequest request) {
		SessionVariables sessVar = new SessionVariables(request);
		model.setViewName("02_AccountManagement/userFormUpdate");
		model.addObject("userManagement", userUpdate.getById(sessVar.getAccountID()));
		select.addSelectListsAndValues(userUpdate.getById(sessVar.getAccountID()), model);
		return model;
	}

	@GetMapping(value = "/02_AccountManagement/resetCompromisedPassword")
	public ModelAndView resetPassword(ModelAndView model,
			@ModelAttribute(value = "resetPass") UsersAccountInfoPassModifSFC usersAccountInfoPassModifSFC) {
		model.setViewName("02_AccountManagement/updatePassword");
		return model;

	}
	
	@GetMapping(value = "/02_AccountManagement/passwordModification")
	public ModelAndView passwordModification(ModelAndView model,
			@ModelAttribute(value = "resetPass") UsersAccountInfoPassModifSFC usersAccountInfoPassModifSFC) {
		model.setViewName("02_AccountManagement/updatePassword");
		return model;

	}

	@PostMapping(value = "/02_AccountManagement/filterCountiesList")
	public ModelAndView filterDispatcher(ModelAndView model, HttpServletRequest request) {
		select.setFormularAndRequestMap("userRegisterFormular", "/02_AccountManagement/userFormRegisterUpdated",
				"/02_AccountManagement/userCreation");
		select.setFormularAndRequestMap("userUpdateFormular", "/02_AccountManagement/userFormUpdateUpdated",
				"/02_AccountManagement/userUpdate");
		return select.dispatchSelectListAndValue(model, request);
	}

	@PostMapping(value = "/02_AccountManagement/userFormRegisterUpdated")
	public ModelAndView userFormUpdated(ModelAndView model, @ModelAttribute(value = "userManagement") UserSFC userSFC,
			HttpServletRequest request) {
		model.setViewName("02_AccountManagement/userFormRegister");
		return select.formSelectInputFieldUpdate(userSFC, model, request);
	}

	@PostMapping(value = "/02_AccountManagement/userFormUpdateUpdated")
	public ModelAndView userUpdateFormUpdated(ModelAndView model,
			@ModelAttribute(value = "userManagement") UserUpdateSFC userUpdateSFC, HttpServletRequest request) {
		model.setViewName("02_AccountManagement/userFormUpdate");
		return select.formSelectInputFieldUpdate(userUpdateSFC, model, request);
	}

	@PostMapping(value = "/02_AccountManagement/userCreation")
	public ModelAndView createUser(ModelAndView model,
			@ModelAttribute(value = "userManagement") @Validated UserSFC userSFC, BindingResult result) {		
		validation.SpringMVCValidationCheck(userSFC, result);
		if (result.hasErrors()) {
			model.setViewName("02_AccountManagement/userFormRegister");
			select.selectListAndValueOnBindingError(userSFC, model);
			return model;
		}
		String toHash = userSFC.getUsersAccountInfoSFC().getPassword();
		userSFC.getUsersAccountInfoSFC().setPassword(encoder.hashedPassWord(toHash));
		userService.save(userSFC);
		mail.sendActivationLink(userSFC.getUsersInfoSFC().getEmail());
		return new ModelAndView("redirect:/accountCreated");
	}

	@PostMapping(value = "/02_AccountManagement/userUpdate")
	public ModelAndView updateUser(ModelAndView model,
			@ModelAttribute(value = "userManagement") @Validated UserUpdateSFC userUpdateSFC, BindingResult result) {
		if (result.hasErrors()) {
			model.setViewName("02_AccountManagement/userFormUpdate");
			select.selectListAndValueOnBindingError(userUpdateSFC, model);
			return model;
		}
		userUpdate.update(userUpdateSFC);
		model.setViewName("02_AccountManagement/userFormUpdate");
		select.addSelectListsAndValues(userUpdateSFC, model);
		return model;
	}

	@PostMapping(value = "/02_AccountManagement/resetPassword")
	public ModelAndView resetPassword(ModelAndView model,
			@ModelAttribute(value = "resetPass") @Validated UsersAccountInfoPassModifSFC usersAccountInfoPassModifSFC,
			BindingResult result, HttpServletRequest request) {		
		SessionVariables sessVar = new SessionVariables(request);
		if (result.hasErrors()) {
			model.setViewName("02_AccountManagement/updatePassword");
			return model;
		}
		if(sessVar.getAllowResetPass()) {	
		Integer id = sessVar.getAccountID();		
		usersAccountInfoservice.updatePassword(id,encoder.hashedPassWord(usersAccountInfoPassModifSFC.getPassword()) );
		usersAccountInfoservice.unLockAccountById(id);
		sessVar.setAllowResetPass(false);
		sessVar.setAccountID(null);
		model.setViewName("03_messagesPages/passwordChangeConfirmation");
		}else {
		model.setViewName("03_messagesPages/codeExpired");
		}
		return model;		
	}
	
	@PostMapping(value = "/02_AccountManagement/updatePassword")
	public ModelAndView updatePassword(ModelAndView model,
			@ModelAttribute(value = "resetPass") @Validated UsersAccountInfoPassModifSFC usersAccountInfoPassModifSFC,
			BindingResult result, HttpServletRequest request) {		
		SessionVariables sessVar = new SessionVariables(request);
		if (result.hasErrors()) {
			model.setViewName("02_AccountManagement/updatePassword");
			return model;
		}			
		Integer id = sessVar.getAccountID();		
		usersAccountInfoservice.updatePassword(id,encoder.hashedPassWord(usersAccountInfoPassModifSFC.getPassword()));		
		model.setViewName("03_messagesPages/passwordChangeConfirmation");		
		return model;		
	}

}
