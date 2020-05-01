package std.fle.springFormCreation;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fle.toolBox.springFormManager.SpringMVCFormGenerator;
import fle.toolBox.springFormManager.builder.configurationClass.SpringFormCssConfig;
import std.fle._03_sfc._03_01_usersInfoSFC.UsersInfoMailSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassResetSFC;
import std.fle._03_sfc._03_02_usersAccountInfoSFC.UsersAccountInfoPassUpdateSFC;
import std.fle._04_associationModel._04_03_sfc.UserSFC;
import std.fle._04_associationModel._04_03_sfc.UserUpdateSFC;

@Component
public class SpringFormCreation implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	ServletContext context;
	private SpringMVCFormGenerator build = new SpringMVCFormGenerator();
	private UserSFC userSFC = new UserSFC();
	private UserUpdateSFC userUpdateSFC = new UserUpdateSFC();
	private UsersInfoMailSFC usersInfoMailSFC = new UsersInfoMailSFC();
	private UsersAccountInfoPassResetSFC usersAccountInfoPassResetfSFC = new UsersAccountInfoPassResetSFC();
	private UsersAccountInfoPassUpdateSFC usersAccountInfoPassUpdateSFC = new UsersAccountInfoPassUpdateSFC();
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		build.generateForm(context, basisConfig(), userSFC);
		build.generateForm(context, basisConfig(), userUpdateSFC);
		build.generateForm(context, mailFormConfig(), usersInfoMailSFC);
		build.generateForm(context, updatepassConfig(), usersAccountInfoPassResetfSFC);
		build.generateForm(context, updatepassConfig(), usersAccountInfoPassUpdateSFC);
	}
	
	private SpringFormCssConfig basisConfig() {
		return  new SpringFormCssConfig()
				.cssConfigFile("configuration/configXml.xml")
				.styleSheetPath("cssFilePath")
				.cssFileName("cssFileName")
				.tableStyle("tableStyleClass.form1")
				.trStyle("trStyleClass.form1")
				.tdStyle("tdStyleClass.form1")
				.labelStyle("labelStyleClass.normal")
				.inputStyle("fieldStyleClass.normal")
				.selectStyle("fieldStyleClass.normal")
				.labelErrorStyle("labelStyleClass.error")
				.inputStyleError("fieldStyleClass.error")
				.selectStyleError("fieldStyleClass.error")
				.errorStyle("labelStyleClass.error")
				.buttonStyle("buttonStyleClass");
	}
	
	private SpringFormCssConfig mailFormConfig() {
		return basisConfig()
		.tableStyle("tableStyleClass.form2")
		.tdStyle("tdStyleClass.form2")
		.labelStyle("labelStyleClass.hide")
		.labelErrorStyle("labelStyleClass.hide");		
	}
	
	private SpringFormCssConfig updatepassConfig() {
		return basisConfig()		
		.trStyle("trStyleClass.form2")
		.tdStyle("tdStyleClass.form3");		
	}


}
