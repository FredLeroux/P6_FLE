package std.fle._0x_controller.controllerClass.AccountManagementController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import fle.toolBox.springFormManager.springMVCValidation.SpringMVCValidation;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoMemberStatusSFC;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserService;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserUpdateService;
import std.fle._07_service.usersAccountInfoService.UsersAccountInfoService;
import std.fle._0x_controller.modelManagement.accountModelManagement.AccountModelManagement;
import std.fle._0x_controller.modelManagement.deleteManager.DeleteConfirmationManager;

@Controller
public class AccountController {
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private SelectInputForController select;

	@Autowired
	private SpringMVCValidation validation;

	@Autowired
	private UserService userService;

	@Autowired
	private UserUpdateService userUpdate;
	
	@Autowired
	private UsersAccountInfoService account;

	@Autowired
	private AccountModelManagement manager;
	
	@Autowired
	private DeleteConfirmationManager deletion;
	
	private SessionVariables sessVar = new SessionVariables();

	@GetMapping(value = "/02_AccountManagement/userFormRegister")
	public ModelAndView initUserForm(ModelAndView model, @ModelAttribute(value = "userManagement") UserSFC userSFC) {
		return manager.manageUserFormRegister(model, userSFC);
	}

	@GetMapping(value = "/02_AccountManagement/userFormUpdate")
	public ModelAndView initUserUpdateForm(ModelAndView model,
			@ModelAttribute(value = "userManagement") UserUpdateSFC userUpdateSFC) {
		return manager.manageUserFormUpdate(model);
	}

	@GetMapping(value = "/04_listPage/memberDetails/{id}")
	public ModelAndView memberDetails(ModelAndView model, @PathVariable Integer id,
			@ModelAttribute(name = "memberStatus") UsersAccountInfoMemberStatusSFC clazz) {
		return manager.displayMemeberStatus(model, "memberStatus", id);
	}

	@PostMapping(value = "/02_AccountManagement/filterCountiesList")
	public ModelAndView filterDispatcher(ModelAndView model, HttpServletRequest request) {
		select.setFormularAndRequestMap("userRegisterFormular", "userFormRegisterUpdated",
				"userCreation");
		select.setFormularAndRequestMap("userUpdateFormular", "userFormUpdateUpdated",
				"userUpdate");
		return select.dispatchSelectListAndValue(model, request);
	}

	@PostMapping(value = "/02_AccountManagement/userFormRegisterUpdated")
	public ModelAndView userFormUpdated(ModelAndView model, @ModelAttribute(value = "userManagement") UserSFC userSFC,
			HttpServletRequest request) {
		model.setViewName("02_AccountManagement/userFormRegister");
		deletion.addURLAndMessage(model, "deleteAccount", "deleteConfirmationAsk.message");
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
			@ModelAttribute(value = "userManagement") @Validated UserSFC userSFC, BindingResult result,HttpServletRequest request) {
		validation.SpringMVCValidationCheck(userSFC,"userManagement", result);
		if (result.hasErrors()) {
			model.setViewName("02_AccountManagement/userFormRegister");
			select.selectListAndValueOnBindingError(userSFC, model);
			return model;
		}
		return manager.manageUserCreation(userSFC,request);
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
		model.setViewName("redirect:/02_AccountManagement/userFormUpdate");
		select.addSelectListsAndValues(userUpdateSFC, model);
		return model;
	}

	@PostMapping(value = "/04_listPage/memberDetails/updateMemberStatus")
	public ModelAndView updateMemberStatus(ModelAndView model,
			@ModelAttribute(name = "memberStatus") UsersAccountInfoMemberStatusSFC clazz) {
		return manager.doUpdateMemberStatus(model, clazz.getId(), clazz);
	}
	
	@GetMapping(value = "/02_AccountManagement/deleteAccount")
	public void deleteAccount() {
		sessVar.setRequest(request);
		account.deleteAccount(sessVar.getAccountID());
	}

}