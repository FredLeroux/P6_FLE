package std.fle._11_springFormCreation;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fle.toolBox.springFormManager.SpringMVCFormGenerator;
import fle.toolBox.springFormManager.builder.configurationClass.SpringFormCssConfig;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteCommentsSFC;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteDisplaySFC;
import std.fle._03_sfc.climbingSiteSFC.ClimbingSiteSFC;
import std.fle._03_sfc.climbingSiteSFC.RoutePitchSFC;
import std.fle._03_sfc.climbingSiteSFC.SiteRoutesSFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoDisplaySFC;
import std.fle._03_sfc.topoSFC.ClimbingTopoSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoMemberStatusSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoPassResetSFC;
import std.fle._03_sfc.usersAccountInfoSFC.UsersAccountInfoPassUpdateSFC;
import std.fle._03_sfc.usersInfoSFC.UsersInfoMailSFC;
import std.fle._04_associationModel.sfc.UserSFC;
import std.fle._04_associationModel.sfc.UserUpdateSFC;

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
	private UsersAccountInfoMemberStatusSFC UsersAccountInfoMemberStatusSFC = new UsersAccountInfoMemberStatusSFC();
	private ClimbingTopoSFC climbingTopoSFC = new ClimbingTopoSFC();
	private ClimbingTopoDisplaySFC climbingTopoDisplaySFC =new ClimbingTopoDisplaySFC();
	private ClimbingSiteSFC climbingSiteSFC = new ClimbingSiteSFC();
	private ClimbingSiteDisplaySFC climbingSiteDisplaySFC = new ClimbingSiteDisplaySFC();
	private SiteRoutesSFC siteRoutesSFC = new SiteRoutesSFC();
	private RoutePitchSFC routePitchSFC	= new RoutePitchSFC();
	private ClimbingSiteCommentsSFC climbingSiteCommentsSFC = new ClimbingSiteCommentsSFC();
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		build.generateForm(context, basisConfig(), userSFC);
		build.generateForm(context, basisConfig(), userUpdateSFC);
		build.generateForm(context, mailFormConfig(), usersInfoMailSFC);
		build.generateForm(context, updatepassConfig(), usersAccountInfoPassResetfSFC);
		build.generateForm(context, updatepassConfig(), usersAccountInfoPassUpdateSFC);
		build.generateForm(context, basisConfig(), UsersAccountInfoMemberStatusSFC);
		build.generateForm(context, basisConfig(), climbingTopoSFC);
		build.generateForm(context, basisConfig(), climbingTopoDisplaySFC);
		build.generateForm(context, basisConfig(), climbingSiteSFC);
		build.generateForm(context, formDisplay(), climbingSiteDisplaySFC);
		build.generateForm(context, basisConfig(), siteRoutesSFC);
		build.generateForm(context, basisConfig(), routePitchSFC);
		build.generateForm(context, basisConfig(), climbingSiteCommentsSFC);
		
	}

	private SpringFormCssConfig basisConfig() {
		return new SpringFormCssConfig()
				.cssConfigFile("configuration/configXml.xml")
				.styleSheetPath("cssFilePath")
				.cssFileName("cssFileName")
				.tableStyle("tableStyleClass.form1")
				.trStyle("trStyleClass.form1")
				.limitCharSpanStyle("limitCharSpanStyleClass.form1")
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
	
	private SpringFormCssConfig formDisplay() {
		return basisConfig()
				.tableStyle("tableStyleClass.form2");
	}

}
