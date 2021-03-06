package std.fle._09_mailCreation;

import javax.servlet.http.HttpServletRequest;

public interface MailCreator {

	public void sendActivationLink(String contact, HttpServletRequest request);

	public void sendLockedAccountMailMessage(String contact, HttpServletRequest request);

	public void sendforgotPassMessage(String contact, String login, HttpServletRequest request);

	public void sendforgotPassMessageLoginOnly(String contact, String login, HttpServletRequest request);

	public void sendBorrowDemandNotificationAndConfirmation(String contactNotification, String pseudo,
			HttpServletRequest request, String contactConfirmation, String lenderPseudo, String topoTitle);

	public void sendBorrowingDemandNotification(String contact, String pseudo, HttpServletRequest request);

	public void sendBorrowDemandConfirmation(String contact, String lenderPseudo, String topoTitle);

	public void sendBorrowingDemandAcceptedMails(String lenderPseudo, String lenderEmail, String borrowerPseudo,
			String borrowerEmail, String topoTitle);

	public void sendBorrowDemandAcceptedToLender(String lenderEmail, String topoTitle, String borrowerPseudo,
			String borrowerEmail);

	public void sendBorrowDemandAcceptedToBorrower(String borrowerEmail, String topoTitle, String lenderPseudo,
			String lenderEmail);

	public void sendBorrowDemandRejectedToBorrower(String borrowerEmail, String topoTitle, String lenderPseudo);

}
