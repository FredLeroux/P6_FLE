package std.fle._09_mailCreation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fle.toolBox.AppURI;
import fle.toolBox.FredCodeGenerator;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.mail.EmailSender;
import std.fle._07_service._07_01_serviceInterface._07_01_02_modelServiceInterface.UsersAccountInfoService;

@Service
public class MailCreatorImplemented implements MailCreator {

	@Autowired
	HttpServletRequest request;

	@Autowired
	LocalMessage local;

	@Autowired
	UsersAccountInfoService accountService;

	private EmailSender mail = new EmailSender("configuration/mailConfig/mailConfig.xml");
	private String senderMail = null;
	private String senderName = null;
	private String subject = null;
	private String body = null;

	@Override
	public void sendActivationLink(String contact) {
		String activationCode = new FredCodeGenerator(24, false).toString();
		setActivationMailMessage(activationCode);
		sendMessage(contact);
		accountService.updateActivationCode(contact, activationCode.toString());
	}

	@Override
	public void sendLockedAccountMailMessage(String contact) {
		String resetCode = new FredCodeGenerator(36, false).toString();
		setLockedAccountMailMessage(resetCode);
		sendMessage(contact);
		accountService.addResetPassCode(contact, resetCode);
	}

	private void setActivationMailMessage(String code) {
		senderMail = local.message("from.user");
		senderName = local.message("user.name");
		subject = local.message("accountCreation.subject");
		body = local.message("accountCreation.body") + '\n' + AppURI.fullContextPathURI(request)
				+ "activation?code=" + code + "\n" + local.message("endMail.message");

	}

	private void setLockedAccountMailMessage(String code) {
		senderMail = local.message("from.user");
		senderName = local.message("user1.name");
		subject = local.message("accountLocked.subject");
		body = local.message("accountLocked.body") + '\n' + AppURI.fullContextPathURI(request)
				+ "unlockMyAccount?reset=" + code + "\n" + local.message("endMail1.message");
	}

	private void sendMessage(String contact) {
		mail.sendMessageToOneContact(contact, senderMail, senderName, subject, body);
	}

}
