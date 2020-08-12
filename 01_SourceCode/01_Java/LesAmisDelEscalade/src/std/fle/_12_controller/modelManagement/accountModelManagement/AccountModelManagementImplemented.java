package std.fle._12_controller.modelManagement.accountModelManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.logger.Log4J2;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._00_general.SessionVariables;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoMemberStatusSFC;
import std.fle._04_associationModel.sfc.UserSFC;
import std.fle._07_service.userService.UserService;
import std.fle._07_service.userUpdateService.UserUpdateService;
import std.fle._07_service.usersAccountInfoService.UsersAccountInfoService;
import std.fle._09_mailCreation.MailCreator;
import std.fle._10_security.PassEncoder;
import std.fle._12_controller.modelManagement.deleteManager.DeleteConfirmationManager;

@Service
public class AccountModelManagementImplemented implements AccountModelManagement {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private SelectInputForController select;

	@Autowired
	private MailCreator mail;

	@Autowired
	private PassEncoder encoder;

	@Autowired
	private UsersAccountInfoService usersAccountInfoService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserUpdateService userUpdate;


	@Autowired
	private UsersAccountInfoService account;

	@Autowired
	private DeleteConfirmationManager deletion;


	private SessionVariables sessVar = new SessionVariables();
	private Log4J2<AccountModelManagementImplemented> logger = new Log4J2<AccountModelManagementImplemented>(this);

	@Override
	public ModelAndView manageUserFormUpdate(ModelAndView model) {
		sessVar.setRequest(request);
		model.setViewName("02_AccountManagement/userFormUpdate");
		model.addObject("userManagement", userUpdate.getById(sessVar.getAccountID()));
		deletion.addURLAndMessage(model, "deleteAccount", "deleteAccountConfirmationAsk.message");
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
	public ModelAndView manageUserCreation(UserSFC userSFC,HttpServletRequest request) {
		String toHash = userSFC.getUsersAccountInfoSFC().getPassword();
		userSFC.getUsersAccountInfoSFC().setPassword(encoder.hashedPassWord(toHash));
		userService.save(userSFC);
		mail.sendActivationLink(userSFC.getUsersInfoSFC().getEmail(),request);
		logger.log().info("New account created");
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
		logger.log().info("Member status updated");
		model.setViewName("redirect:/callListBack");
		return model;
	}
	@Override
	public void manageAccountDeletion() {
	sessVar.setRequest(request);
		account.deleteAccount(sessVar.getAccountID());
		logger.log().info("Account deleted");
		sessVar.clearSession();
	}

}
