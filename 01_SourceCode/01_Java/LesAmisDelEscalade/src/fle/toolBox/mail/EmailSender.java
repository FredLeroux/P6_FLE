package fle.toolBox.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fle.toolBox.ConfigurationFileReader;



public class EmailSender {

	private ConfigurationFileReader config = null;
	private Message messageConfig = null;

	public EmailSender(String configFilePath) {
		config = new ConfigurationFileReader(configFilePath);
		message(sessionSmtp());
	}

	public void sendMessageToOneContact(String contact, String senderAdresse, String senderName, String subject,
			String mailBody) {		
		try {
			messageConfig.setFrom(new InternetAddress(senderAdresse, senderName));
			messageConfig.setSubject(subject);
			messageConfig.setText(mailBody);
			messageConfig.setRecipients(Message.RecipientType.TO, stringToAddress(contact));
			Transport.send(messageConfig);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Session sessionSmtp() {
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(config.getProperty("login"), config.getProperty("pass"));
			}
		};
		return Session.getInstance(config, authenticator);
	}

	private Message message(Session session) {
		return messageConfig = new MimeMessage(session);
	}
	
	private InternetAddress[] stringToAddress(String contact) {
		InternetAddress[] addressTo = null;
		try {
			addressTo = InternetAddress.parse(contact);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addressTo;
	}

}
