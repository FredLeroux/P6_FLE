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

	@Override
	public void sendforgotPassMessage(String contact, String login) {
		String forgotResetCode = new FredCodeGenerator(26, false).toString();
		setforgotPassMessage(forgotResetCode, login);
		sendMessage(contact);
		accountService.addResetPassCode(contact, forgotResetCode);
	}

	@Override
	public void sendforgotPassMessageLoginOnly(String contact, String login) {
		setforgotPassMessageOnlyLogin(login);
		sendMessage(contact);

	}

	private void setActivationMailMessage(String code) {
		sender0();
		subject = local.message("accountCreation.subject");
		body = local.message("accountCreation.body") + "\n" + AppURI.fullContextPathURI(request) + "activation?code="
				+ code + "\n" + local.message("endMail.message");

	}

	private void setLockedAccountMailMessage(String code) {
		sender1();
		subject = local.message("accountLocked.subject");
		body = local.message("accountLocked.body") + "\n" + AppURI.fullContextPathURI(request)
				+ "unlockMyAccount?reset=" + code + "\n" + local.message("endMail1.message");
	}

	private void setforgotPassMessage(String code, String login) {
		sender0();
		subject = local.message("forgotPass.subject");
		body = local.message("forgotPass.login") + login 
				+ "\n" + local.message("forgotPass.body") 
				+ "\n" + AppURI.fullContextPathURI(request) + "unlockMyAccount?reset=" + code 
				+ "\n" + local.message("endMail2.message");
	}

	private void setforgotPassMessageOnlyLogin(String login) {
		sender0();
		subject = local.message("forgotPass.subject");
		body = local.message("forgotPassOnlyLogin.message") + login 
				+ "\n" + local.message("forgotPassOnlyLogin.body") 
				+ "\n" + AppURI.fullContextPathURI(request)
				+ "\n" + local.message("endMail2.message");
	}

	private void sender0() {
		setSender(local.message("user.name"));
	}

	private void sender1() {
		setSender(local.message("user1.name"));
	}

	private void setSender(String senderName) {
		setSenderMail();
		this.senderName = senderName;
	}

	private void setSenderMail() {
		senderMail = local.message("from.user");
	}

	private void sendMessage(String contact) {
		mail.sendMessageToOneContact(contact, senderMail, senderName, subject, body);
	}

}
