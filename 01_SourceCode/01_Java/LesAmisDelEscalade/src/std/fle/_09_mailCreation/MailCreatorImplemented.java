package std.fle._09_mailCreation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import fle.toolBox.AppURI;
import fle.toolBox.FredCodeGenerator;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.mail.EmailSender;
import std.fle._07_service.usersAccountInfoService.UsersAccountInfoService;

@Service

public class MailCreatorImplemented implements MailCreator {

	/* Important: no autowired on HttpServletRequest in order to use @Async */

	@Autowired
	LocalMessage local;

	@Autowired
	UsersAccountInfoService accountService;

	AppURI uri = new AppURI();
	private EmailSender mail = new EmailSender("configuration/mailConfig/mailConfig.xml");
	private String senderMail = null;
	private String senderName = null;
	private String subject = null;
	private String body = null;

	@Async
	@Override
	public void sendActivationLink(String contact, HttpServletRequest request) {
		String activationCode = new FredCodeGenerator(24, false).toString();
		setActivationMailMessage(contact,activationCode, request);		
		accountService.updateActivationCode(contact, activationCode.toString());
	}

	private void setActivationMailMessage(String contact,String code, HttpServletRequest request) {
		sender0();		
		subject = local.message("accountCreation.subject");
		body = local.message("accountCreation.message") + "\n" +urlBuilder(request) + "activation?code=" + code + "\n"
				+ local.message("endMail.message");
		sendMessage(contact);
	}

	@Async
	@Override
	public void sendLockedAccountMailMessage(String contact, HttpServletRequest request) {
		String resetCode = new FredCodeGenerator(36, false).toString();
		setLockedAccountMailMessage(contact,resetCode, request);		
		accountService.addResetPassCode(contact, resetCode);
	}

	private void setLockedAccountMailMessage(String contact,String code, HttpServletRequest request) {
		sender1();
		subject = local.message("accountLocked.subject");
		body = local.message("accountLocked.message") + "\n" + urlBuilder(request)
				+ "unlockMyAccount?reset=" + code + "\n" + local.message("endMail1.message");
		sendMessage(contact);
	}

	@Async
	@Override
	public void sendforgotPassMessage(String contact, String login, HttpServletRequest request) {
		String forgotResetCode = new FredCodeGenerator(26, false).toString();
		setforgotPassMessage(contact,forgotResetCode, login, request);		
		accountService.addResetPassCode(contact, forgotResetCode);
	}

	private void setforgotPassMessage(String contact,String code, String login, HttpServletRequest request) {
		sender0();
		subject = local.message("forgotPass.subject");
		body = local.message("forgotPass.login") + login + "\n" + local.message("forgotPass.message") + "\n"
				+ urlBuilder(request) + "unlockMyAccount?reset=" + code + "\n"
				+ local.message("endMail2.message");
		sendMessage(contact);
	}

	@Async
	@Override
	public void sendforgotPassMessageLoginOnly(String contact, String login, HttpServletRequest request) {
		setforgotPassMessageOnlyLogin(contact,login, request);
		
	}

	private void setforgotPassMessageOnlyLogin(String contact,String login, HttpServletRequest request) {
		sender0();
		subject = local.message("forgotPass.subject");
		body = local.message("forgotPass.login") + login + "\n" + local.message("forgotPassOnlyLogin.message") + "\n"
				+ urlBuilder(request) + "\n" + local.message("endMail2.message");
		sendMessage(contact);
	}

	@Override
	@Async	
	public void sendBorrowDemandNotificationAndConfirmation(String contactNotification, String pseudo,
			HttpServletRequest request, String contactConfirmation, String lenderPseudo, String topoTitle) {		
		setBorrowingDemandNotification(contactNotification, pseudo, request);		
		setBorrowDemandConfirmation(contactConfirmation, lenderPseudo, topoTitle);
		

	}

	@Async
	@Override
	public void sendBorrowingDemandNotification(String contact, String pseudo, HttpServletRequest request) {
		setBorrowingDemandNotification(contact, pseudo, request);

	}

	private void setBorrowingDemandNotification(String contact, String login, HttpServletRequest request) {
		sender2();
		subject = local.message("borrowingDemand.subject");
		body = login + local.message("borrowingDemand.message") + "\n" + urlBuilder(request) + "\n"
				+ local.message("endMail.message");
		sendMessage(contact);
	}

	@Async
	@Override
	public void sendBorrowDemandConfirmation(String contact, String lenderPseudo, String topoTitle) {
		setBorrowDemandConfirmation(contact, lenderPseudo, topoTitle);

	}

	private void setBorrowDemandConfirmation(String contact, String lenderPseudo, String topoTitle) {
		sender2();
		subject = local.message("borrowingDemandConfirmation.subject");
		body = local.message("borrowingDemandConfirmation.message") + topoTitle + "\n"
				+ local.message("borrowingDemandConfirmation1.message") + lenderPseudo + "\n"
				+ local.message("endMail.message");
		sendMessage(contact);
	}

	@Async
	@Override
	public void sendBorrowingDemandAcceptedMails(String lenderPseudo, String lenderEmail, String borrowerPseudo,
			String borrowerEmail, String topoTitle) {		
		setBorrowingDemandAcceptedToLender(lenderEmail, topoTitle, borrowerPseudo, borrowerEmail);		
		setBorrowingDemandAcceptedToBorrower(borrowerEmail, topoTitle, lenderPseudo, lenderEmail);
	}

	@Async
	@Override
	public void sendBorrowDemandAcceptedToLender(String lenderEmail, String topoTitle, String borrowerPseudo,
			String borrowerEmail) {
		setBorrowingDemandAcceptedToLender(lenderEmail, topoTitle, borrowerPseudo, borrowerEmail);

	}

	private void setBorrowingDemandAcceptedToLender(String lenderEmail, String topoTitle, String borrowerPseudo,
			String borrowerEmail) {
		sender2();
		subject = local.message("borrowingDemandAccepted.subject");
		body = bodyBorrowDemanAccpeted(topoTitle, borrowerPseudo, borrowerEmail, "borrowerPseudo.message");
		sendMessage(lenderEmail);
	}

	@Async
	@Override
	public void sendBorrowDemandAcceptedToBorrower(String borrowerEmail, String topoTitle, String lenderPseudo,
			String lenderEmail) {
		setBorrowingDemandAcceptedToBorrower(borrowerEmail, topoTitle, lenderPseudo, lenderEmail);

	}

	private void setBorrowingDemandAcceptedToBorrower(String borrowerEmail, String topoTitle, String lenderPseudo,
			String lenderEmail) {
		sender2();
		subject = local.message("borrowingDemandAccepted.subject");
		body = bodyBorrowDemanAccpeted(topoTitle, lenderPseudo, lenderEmail, "lenderPseudo.message");
		sendMessage(borrowerEmail);
	}

	private String bodyBorrowDemanAccpeted(String topoTitle, String addressee, String adresseeEmail,
			String adresseeTypeKey) {
		return local.message("acceptedTopoTitle.message").concat(topoTitle) + "\n"
				+ local.message(adresseeTypeKey).concat(addressee) + "\n"
				+ local.message("borrowerLenderEmail.message").concat(adresseeEmail) + "\n"
				+ local.message("endMail3.message") + "\n" + local.message("signature.message");
	}

	@Async
	@Override
	public void sendBorrowDemandRejectedToBorrower(String borrowerEmail, String topoTitle, String lenderPseudo) {
		setBorrowingDemandRejected(borrowerEmail, topoTitle, lenderPseudo);
	}

	private void setBorrowingDemandRejected(String borrowerEmail, String topoTitle, String lenderPseudo) {
		sender2();
		subject = local.message("borrowingDemandRejected.subject");
		body = local.message("rejectedTopoTitle.message").concat(topoTitle) + "\n"
				+ local.message("lenderPseudo.message").concat(lenderPseudo) + "\n"
				+ local.message("signature.message");
		sendMessage(borrowerEmail);
	}

	private void sender0() {
		setSender(local.message("user.name"));
	}

	private void sender1() {
		setSender(local.message("user1.name"));
	}

	private void sender2() {
		setSender(local.message("notificationBorrow.name"));
	}

	private void setSender(String senderName) {
		setSenderMail();
		this.senderName = senderName;
	}

	private void setSenderMail() {
		senderMail = local.message("from.user");
	}

	private void sendMessage(String contact) {
		String to = null;
		to = contact;
		mail.sendMessageToOneContact(to, senderMail, senderName, subject, body);

	}	
	
	
	private String urlBuilder(HttpServletRequest request) {
		String url = uri.fullContextPathURINotStatic(request);
		while (url.contains("null") || url.contains("-1")) {
			url = uri.fullContextPathURINotStatic(request);
			//TODO logger Here
		}
		return url;
	}

}
