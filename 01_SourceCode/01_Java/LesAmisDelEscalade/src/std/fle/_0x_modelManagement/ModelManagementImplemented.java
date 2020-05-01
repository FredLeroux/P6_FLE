package std.fle._0x_modelManagement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fle.toolBox.ConfigurationFileReader;
import fle.toolBox.FredParser;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.springFormManager.selectInputManagement.controllerClass.SelectInputForController;
import std.fle._03_sfc._03_01_usersInfoSFC.UsersInfoMailSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassResetSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassUpdateSFC;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._05_controller.SessionVariables;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersInfoService;
import std.fle._07_service._07_01_serviceInterface._07_01_03_associatedModelServiceInterface.UserService;
import std.fle._09_mailCreation.MailCreator;
import std.fle._0X_security.PassEncoder;

@Service
public class ModelManagementImplemented implements ModelManagement {
	
	@Autowired
	SelectInputForController select;

	@Autowired
	LocalMessage locale;

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

	private final String forgotPassConfirmationMessage = "forgotPassMailsentConfirmationBody.message";
	private ConfigurationFileReader config = new ConfigurationFileReader(
			"configuration/securitySettings/LogTentativeMax.xml");

	
	
	
	@Override
	public ModelAndView manageForgotPassModel(ModelAndView model, UsersInfoMailSFC usersInfoMailSFC,
			HttpServletRequest request) {
		String eMail = usersInfoMailSFC.getEmail();
		String login = usersAccountInfoService.getLoginByEmail(eMail);
		boolean sendLogin = request.getParameter("login") != null ? true : false;
		boolean sendPass = request.getParameter("pass") != null ? true : false;
		if (usersInfoService.isEmailExist(eMail)) {
			if ((!sendLogin || sendLogin) && sendPass) {
				usersAccountInfoService.lockAccount(FredParser.toInteger(config.getProperty("maxTentatativesAllowed")),
						login);
				mail.sendforgotPassMessage(eMail, login);
				model = confirmationModel(forgotPassConfirmationMessage);
			} else if (sendLogin && !sendPass) {
				mail.sendforgotPassMessageLoginOnly(eMail, login);
				model = confirmationModel(forgotPassConfirmationMessage);
			} else {
				model.setViewName("/03_messagesPages/forgotPassword");
				model.addObject("errorNoCheckBox", locale.message("NoCheckBox.forgotPass.error"));
			}
		} else {
			model.setViewName("03_messagesPages/unknownMail");
			model.addObject("mail", usersInfoMailSFC.getEmail());
			model.addObject("backToCallPageHref", "forgotPassword");
		}
		return model;
	}

	@Override
	public ModelAndView manageResetPasswordModel(ModelAndView model,
			UsersAccountInfoPassResetSFC usersAccountInfoPassResetSFC, HttpServletRequest request) {
		SessionVariables sessVar = new SessionVariables(request);
		if (sessVar.getAllowResetPass()) {
			Integer id = sessVar.getAccountID();
			usersAccountInfoService.updatePassword(id,
					encoder.hashedPassWord(usersAccountInfoPassResetSFC.getPassword()));
			usersAccountInfoService.unLockAccountById(id);
			sessVar.setAllowResetPass(false);
			sessVar.setAccountID(null);
			model.setViewName("03_messagesPages/passwordChangeConfirmation");
		} else {
			model.setViewName("03_messagesPages/codeExpired");
		}
		return model;
	}

	@Override
	public ModelAndView manageUpdatePasswordModel(ModelAndView model,
			UsersAccountInfoPassUpdateSFC usersAccountInfoPassUpdateSFC, HttpServletRequest request) {
		SessionVariables sessVar = new SessionVariables(request);
		Integer id = sessVar.getAccountID();
		usersAccountInfoService.updatePassword(id, encoder.hashedPassWord(usersAccountInfoPassUpdateSFC.getPassword()));
		model.setViewName("03_messagesPages/passwordChangeConfirmation");
		return model;
	}
	
	
	
	private ModelAndView confirmationModel(String confirmationMessage) {
		ModelAndView confirmation = new ModelAndView("03_messagesPages/confirmationNewCodeSent");
		confirmation.addObject("confirmationMessage", locale.message(confirmationMessage));
		return confirmation;
	}

}
