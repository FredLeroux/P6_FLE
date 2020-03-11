package fle.toolBox.springFormManager;

import java.io.IOException;

import javax.servlet.ServletContext;

import fle.toolBox.classType.SFC;
import fle.toolBox.filesManagement.FilesManagement;
import fle.toolBox.springFormManager.builder.SpringFormStringBuilder;
import fle.toolBox.springFormManager.builder.SpringRawFormular;
import fle.toolBox.springFormManager.builder.configurationClass.SpringFormCssConfig;
import fle.toolBox.springFormManager.selectInputManagement.SelectInputJSFunction;



public class SpringMVCFormGenerator {

	private SpringFormStringBuilder<SFC> springForm;
	private SpringFormCssConfig springFormCssConfig;
	private FilesManagement jspCreator;
	private SelectInputJSFunction<SFC> selectInputJSFunction = new SelectInputJSFunction<>();

	public void cssSettings(SpringFormCssConfig springFormCssConfig) {
		this.springFormCssConfig = springFormCssConfig;
	}

	public void generateForm(ServletContext context, SpringFormCssConfig cssConfig, SFC entityModel) {
		springForm = new SpringFormStringBuilder<SFC>(entityModel);
		springForm.setSpringFormCssConfig(cssConfig);
		for (SpringRawFormular form : springForm.springRawFormulars()) {
			StringBuilder builded = form.getSpringForm();
			selectInputJSFunction.addSelectInputJSFunction(entityModel, builded, form.getFormName());
			writeForm(context, builded, form.getJspPath());
		}
	}

	public void generateForm(ServletContext context, SFC entityModel) {
		springForm = new SpringFormStringBuilder<SFC>(entityModel);
		springForm.setSpringFormCssConfig(springFormCssConfig);
		for (SpringRawFormular form : springForm.springRawFormulars()) {
			StringBuilder builded = form.getSpringForm();
			selectInputJSFunction.addSelectInputJSFunction(entityModel, builded, form.getFormName());
			writeForm(context, builded, form.getJspPath());
		}
	}

	private void writeForm(ServletContext context, StringBuilder builded, String path) {
		this.jspCreator = new FilesManagement();
		jspCreator.setPath(context, path);
		try {
			jspCreator.writeInFile(builded.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
