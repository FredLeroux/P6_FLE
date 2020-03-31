package std.fle.springFormCreation;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fle.toolBox.springFormManager.SpringMVCFormGenerator;
import fle.toolBox.springFormManager.builder.configurationClass.SpringFormCssConfig;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
@Component
public class SpringFormCreation implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	ServletContext context;
	private SpringMVCFormGenerator build = new SpringMVCFormGenerator();
	private UserSFC userSFC = new UserSFC();
	private static final SpringFormCssConfig config = new SpringFormCssConfig()
			.cssConfigFile("configuration/configXml.xml")
			.styleSheetPath("cssFilePath")
			.cssFileName("cssFileName")
			.labelStyle("labelStyleClass.normal")
			.inputStyle("fieldStyleClass.normal")
			.selectStyle("fieldStyleClass.normal")
			.labelErrorStyle("labelStyleClass.error")
			.inputStyleError("fieldStyleClass.error")
			.selectStyleError("fieldStyleClass.error")
			.errorStyle("labelStyleClass.error")
			.buttonStyle("buttonStyleClass");

	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		build.generateForm(context, config, userSFC);
	}

}
