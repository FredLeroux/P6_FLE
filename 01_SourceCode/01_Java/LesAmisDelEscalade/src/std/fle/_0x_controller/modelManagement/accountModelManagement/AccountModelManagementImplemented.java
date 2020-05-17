package std.fle._0x_controller.modelManagement.accountModelManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.fieldTranslator.FieldsTranslator;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoMemberStatusSFC;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersInfoService;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserService;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserUpdateService;
import std.fle._07_service.usersAccountInfoService.UsersAccountInfoService;
import std.fle._09_mailCreation.MailCreator;
import std.fle._0X_security.PassEncoder;
import std.fle._0x_controller.modelManagement.listManagement.ListGenerator;

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
	
	@Autowired
	ListGenerator listGenerator;
	
	@Autowired
	FieldsTranslator fieldsTranslator;

	private SessionVariables sessVar = new SessionVariables();

	@Override
	public ModelAndView manageUserFormUpdate(ModelAndView model) {
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
	
	@Override
	public ModelAndView displayMemeberStatus(ModelAndView model,String modelAttributeName,Integer id) {
		model.setViewName("02_AccountManagement/UserFormUpdateMemberStatus");		
		model.addObject(modelAttributeName,usersAccountInfoService.getUserAccountInfoMemberStatusById(id));
		select.addSelectListsAndValues(usersAccountInfoService.getUserAccountInfoMemberStatusById(id), model);
		return model;
	}
	@Override
	public ModelAndView doUpdateMemberStatus(ModelAndView model,Integer id, UsersAccountInfoMemberStatusSFC memberStatusSFC) {
		usersAccountInfoService.updateMemberStatus(id, memberStatusSFC);
		model.setViewName("redirect:/04_listPage/listPage");
		return model;
	}

}
