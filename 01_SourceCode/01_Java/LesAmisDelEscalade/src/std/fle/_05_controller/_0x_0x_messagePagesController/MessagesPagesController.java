package std.fle._05_controller._0x_0x_messagePagesController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import std.fle._03_sfc._03_01_usersInfoSFC.UsersInfoMailSFC;
import std.fle._05_controller.SessionVariables;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersInfoService;
import std.fle._09_mailCreation.MailCreator;

@Controller
public class MessagesPagesController {

	@Autowired
	UsersInfoService usersInfoService;

	@Autowired
	UsersAccountInfoService accountServices;

	@Autowired
	MailCreator mail;

	@GetMapping(value = "/01_home/01_01_welcomePage/welcomePage")
	public ModelAndView welcome() {
		return new ModelAndView("/01_home/01_01_welcomePage/welcomePage");

	}

	@GetMapping(value = "accountCreated")
	public ModelAndView accountCreated() {
		return new ModelAndView("03_messagesPages/accountCreated");

	}

	@GetMapping(value = "/03_messagesPages/accountActivated")
	public ModelAndView accountActivated() {
		return new ModelAndView("03_messagesPages/accountActivated");

	}

	@GetMapping(value = "/03_messagesPages/accountActivationError")
	public ModelAndView accountActivatedError(@ModelAttribute(value = "userMail") UsersInfoMailSFC usersInfoMailSfc) {
		return new ModelAndView("/03_messagesPages/accountActivationError");
	}

	@PostMapping(value = "/03_messagesPages/newActivationCode")
	public ModelAndView validatingMail(ModelAndView model,
			@ModelAttribute(value = "userMail") @Validated UsersInfoMailSFC usersInfoMailSfc, BindingResult result) {
		if (result.hasErrors()) {
			model.setViewName("/03_messagesPages/accountActivationError");
			return model;
		}
		String eMail = usersInfoMailSfc.getEmail();
		if (usersInfoService.isEmailExist(eMail)) {
			if (accountServices.isAccountActivated(eMail)) {
				return new ModelAndView("03_messagesPages/accountAlreadyActivated");
			} else {
				mail.sendActivationLink(eMail);
				return new ModelAndView("03_messagesPages/confirmationNewCodeSent");
			}
		} else {
			model.setViewName("03_messagesPages/unknownMail");
			model.addObject("mail", usersInfoMailSfc.getEmail());
			return model;
		}
	}

	@GetMapping(value = "/03_messagesPages/accountAlreadyActivated")
	public ModelAndView accountAlreadyActivated() {
		return new ModelAndView("/03_messagesPages/accountAlreadyActivated");
	}

	@GetMapping(value = "/03_messagesPages/confirmationNewCodeSent")
	public ModelAndView confirmationNewCodeSent() {
		return new ModelAndView("/03_messagesPages/confirmationNewCodeSent");
	}

	@GetMapping(value = "/03_messagesPages/unknownMail")
	public ModelAndView unknownMail() {
		return new ModelAndView("/03_messagesPages/unknownMail");
	}

	@GetMapping(value = "/03_messagesPages/accountNotYetActivated")
	public ModelAndView accountNotYetActivated() {
		return new ModelAndView("/03_messagesPages/accountNotYetActivated");
	}

	@GetMapping(value = "/03_messagesPages/accountLocked")
	public ModelAndView accountLocked(HttpServletRequest request) {
		SessionVariables sessVar = new SessionVariables(request);
		String login = sessVar.getLogin();
		mail.sendLockedAccountMailMessage(usersInfoService.getAccountEmailByLogin(login));
		sessVar.setLogin("");
		return new ModelAndView("/03_messagesPages/accountLocked");
	}

	@GetMapping(value = "/03_messagesPages/codeExpired")
	public ModelAndView codeExpired() {
		return new ModelAndView("/03_messagesPages/codeExpired");
	}
	
	
	@GetMapping(value = "/03_messagesPages/passwordChangeConfirmation")
	public ModelAndView passwordChangeConfirmation() {
		return new ModelAndView("/03_messagesPages/passwordChangeConfirmation");
	}

}
