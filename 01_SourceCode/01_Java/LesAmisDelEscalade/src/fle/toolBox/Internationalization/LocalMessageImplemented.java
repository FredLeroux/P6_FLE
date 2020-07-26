package fle.toolBox.Internationalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class LocalMessageImplemented implements LocalMessage {
	
	@Autowired
	MessageSource messageSource;

	private Internationalization inter = new Internationalization();
	
	@Override
	public String message(String key) {	
		String localMessage =null;
		try {
		localMessage = inter.messI18n(key, messageSource);
		} catch (Exception e) {
			return key;
		}
		return localMessage;
	}

}
