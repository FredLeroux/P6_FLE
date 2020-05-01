package std.fle._0x_modelManagement.accountModelManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;
import std.fle._05_controller.SessionVariables;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersInfoService;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserService;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserUpdateService;
import std.fle._09_mailCreation.MailCreator;
import std.fle._0X_security.PassEncoder;

@Service
public class AccountModelManagementImplemented implements AccountModelManagement {

	@Autowired
	HttpServletRequest request;

	@Autowired
	SelectInputForController select;

	@Autowired
	MailCreator mail;

	@Autowired
	PassEncoder encoder;

	@Autowired
	UsersInfoService usersInfoService;

	@Autowired
	UsersAccountInfoService usersAccountInfoService;

	@Autowired
	UserService userService;

	@Autowired
	UserUpdateService userUpdate;

	private SessionVariables sessVar = new SessionVariables();

	@Override
	public ModelAndView manageUserFormUpdate(ModelAndView model, UserUpdateSFC userUpdateSFC) {
		sessVar.setRequest(request);
		model.setViewName("02_AccountManagement/userFormUpdate");
		model.addObject("userManagement", userUpdate.getById(sessVar.getAccountID()));
		select.addSelectListsAndValues(userUpdate.getById(sessVar.getAccountID()), model);
		return model;
	}

	@Override
	public ModelAndView manageUserFormRegister(ModelAndView model, UserSFC userSFC) {
		model.setViewName("02_AccountManagement/userFormRegister");
		select.addSelectListsAndValues(userSFC, model);
		return model;
	}

	@Override
	public ModelAndView manageUserCreation(UserSFC userSFC) {
		String toHash = userSFC.getUsersAccountInfoSFC().getPassword();
		userSFC.getUsersAccountInfoSFC().setPassword(encoder.hashedPassWord(toHash));
		userService.save(userSFC);
		mail.sendActivationLink(userSFC.getUsersInfoSFC().getEmail());
		return new ModelAndView("redirect:/accountCreated");
	}

}
