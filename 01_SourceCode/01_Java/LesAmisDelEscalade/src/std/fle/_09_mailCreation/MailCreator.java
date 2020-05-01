package std.fle._09_mailCreation;





public interface MailCreator {
	
	
	public void sendActivationLink(String contact);
	
	public void sendLockedAccountMailMessage(String contact);
	
	public void sendforgotPassMessage(String contact,String login);
	
	public void sendforgotPassMessageLoginOnly(String contact, String login);

}
