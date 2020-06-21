package std.fle._09_mailCreation;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import fle.toolBox.AppURI;
import fle.toolBox.FredCodeGenerator;
import fle.toolBox.Internationalization.LocalMessage;
import fle.toolBox.mail.EmailSender;
import std.fle._07_service.usersAccountInfoService.UsersAccountInfoService;

@Service

public class MailCreatorImplemented implements MailCreator {

	/*Important: no autowired on HttpServletRequest in order to use @Async*/ 

	
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
	public void sendActivationLink(String contact,HttpServletRequest request) {
		String activationCode = new FredCodeGenerator(24, false).toString();
		setActivationMailMessage(activationCode,request);
		sendMessage(contact);
		accountService.updateActivationCode(contact, activationCode.toString());
	}

	
	private void setActivationMailMessage(String code,HttpServletRequest request) {		
		sender0();		
		String link = uri.fullContextPathURINotStatic(request);
		subject = local.message("accountCreation.subject");
		body = local.message("accountCreation.message") + "\n" + link + "activation?code="
				+ code + "\n" + local.message("endMail.message");
	}

	@Async
	@Override
	public void sendLockedAccountMailMessage(String contact,HttpServletRequest request) {
		String resetCode = new FredCodeGenerator(36, false).toString();
		setLockedAccountMailMessage(resetCode,request);
		sendMessage(contact);
		accountService.addResetPassCode(contact, resetCode);
	}

	private void setLockedAccountMailMessage(String code,HttpServletRequest request) {
		sender1();
		subject = local.message("accountLocked.subject");
		body = local.message("accountLocked.message") + "\n" + AppURI.fullContextPathURI(request)
				+ "unlockMyAccount?reset=" + code + "\n" + local.message("endMail1.message");
	}

	@Async
	@Override
	public void sendforgotPassMessage(String contact, String login,HttpServletRequest request) {
		String forgotResetCode = new FredCodeGenerator(26, false).toString();
		setforgotPassMessage(forgotResetCode, login,request);
		sendMessage(contact);
		accountService.addResetPassCode(contact, forgotResetCode);
	}

	private void setforgotPassMessage(String code, String login,HttpServletRequest request) {
		sender0();
		subject = local.message("forgotPass.subject");
		body = local.message("forgotPass.login") + login + "\n" + local.message("forgotPass.message") + "\n"
				+ AppURI.fullContextPathURI(request) + "unlockMyAccount?reset=" + code + "\n"
				+ local.message("endMail2.message");
	}

	@Async
	@Override
	public void sendforgotPassMessageLoginOnly(String contact, String login,HttpServletRequest request) {
		setforgotPassMessageOnlyLogin(login,request);
		sendMessage(contact);
	}

	private void setforgotPassMessageOnlyLogin(String login,HttpServletRequest request) {
		sender0();
		subject = local.message("forgotPass.subject");
		body = local.message("forgotPass.login") + login + "\n" + local.message("forgotPassOnlyLogin.message")
				+ "\n" + AppURI.fullContextPathURI(request) + "\n" + local.message("endMail2.message");
	}
	
	@Async
	@Override	
	public void sendBorrowingDemandNotification(String contact, String pseudo,HttpServletRequest request) {
		setBorrowingDemandNotification(pseudo,request);
		sendMessage(contact);
	}
		

	private void setBorrowingDemandNotification(String login,HttpServletRequest request) {
		sender2();
		subject = local.message("borrowingDemand.subject");
		body = login + local.message("borrowingDemand.message") + "\n" + AppURI.fullContextPathURI(request) + "\n"
				+ local.message("endMail.message");
	}
	
	@Async
	@Override
	public void sendBorrowDemandAcceptedToLender(String lenderEmail,String topoTitle, String borrowerPseudo, String borrowerEmail) {
		setBorrowingDemandAcceptedToLender(topoTitle, borrowerPseudo, borrowerEmail);
		sendMessage(lenderEmail);
	}
	
	private void setBorrowingDemandAcceptedToLender(String topoTitle, String borrowerPseudo, String borrowerEmail) {
		sender2();
		subject = local.message("borrowingDemandAccepted.subject");
		body =  bodyBorrowDemanAccpeted(topoTitle, borrowerPseudo, borrowerEmail,"borrowerPseudo.message");
	}
	
	@Async
	@Override
	public void sendBorrowDemandAcceptedToBorrower(String borrowerEmail,String topoTitle, String lenderPseudo, String lenderEmail) {
		setBorrowingDemandAcceptedToBorrower(topoTitle, lenderPseudo, lenderEmail);
		sendMessage(borrowerEmail);
	}
	
	private void setBorrowingDemandAcceptedToBorrower(String topoTitle, String lenderPseudo, String lenderEmail) {
		sender2();
		subject = local.message("borrowingDemandAccepted.subject");
		body =  bodyBorrowDemanAccpeted(topoTitle, lenderPseudo, lenderEmail,"lenderPseudo.message");
	}
	
	private String bodyBorrowDemanAccpeted(String topoTitle,String addressee, String adresseeEmail, String adresseeTypeKey) {
		return local.message("acceptedTopoTitle.message").concat(topoTitle)
				+"\n"
				+local.message(adresseeTypeKey).concat(addressee)
				+"\n"
				+local.message("borrowerLenderEmail.message").concat(adresseeEmail)
				+"\n"
				+local.message("endMail3.message")
				+"\n"
				+local.message("signature.message");
	}
	
	//@Async
	@Override
	public void sendBorrowDemandRejectedToBorrower(String borrowerEmail,String topoTitle, String lenderPseudo) {
		setBorrowingDemandRejected(topoTitle, lenderPseudo);
		sendMessage(borrowerEmail);
	}
	
	
	private void setBorrowingDemandRejected(String topoTitle, String lenderPseudo) {
		sender2();
		subject = local.message("borrowingDemandRejected.subject");
		body = local.message("rejectedTopoTitle.message").concat(topoTitle)
				+"\n"
				+local.message("lenderPseudo.message").concat(lenderPseudo)
				+"\n"
				+local.message("signature.message");;
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
		mail.sendMessageToOneContact(contact, senderMail, senderName, subject, body);
	}

}
