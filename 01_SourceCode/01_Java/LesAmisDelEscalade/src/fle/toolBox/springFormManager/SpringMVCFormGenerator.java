package fle.toolBox.springFormManager;

import java.io.IOException;

import javax.servlet.ServletContext;

import fle.toolBox.classType.SFC;
import fle.toolBox.filesManagement.FilesManagement;
import fle.toolBox.springFormManager.builder.SpringFormStringBuilder;
import fle.toolBox.springFormManager.builder.SpringRawFormular;
import fle.toolBox.springFormManager.builder.configurationClass.SpringFormCssConfig;
import fle.toolBox.springFormManager.limitCharCountDowJS.LimitCharCountBuilder;
import fle.toolBox.springFormManager.selectInputManagement.javascriptFunctions.SelectInputJSFunction;
import fle.toolBox.springFormManager.test.TestNumericAnnotationFill;
import fle.toolBox.springFormManager.test.TestSelectInputTypeAnnotationFill;

public class SpringMVCFormGenerator {

	private SpringFormStringBuilder<SFC> springForm;
	private FilesManagement jspCreator;
	private SelectInputJSFunction<SFC> selectInputJSFunction = new SelectInputJSFunction<>();
	private LimitCharCountBuilder limitCharCountBuilder = new LimitCharCountBuilder();
	private TestNumericAnnotationFill testNumericField = new TestNumericAnnotationFill();
	private TestSelectInputTypeAnnotationFill testSelectField = new TestSelectInputTypeAnnotationFill();

	public void generateForm(ServletContext context, SpringFormCssConfig cssConfig, SFC entityModel) {
		testNumericField.testNumericAnnotationValidity(entityModel);
		testSelectField.testSelectInputAnnotationValidity(entityModel);
		springForm = new SpringFormStringBuilder<SFC>(entityModel);
		springForm.setSpringFormCssConfig(cssConfig);
		for (SpringRawFormular form : springForm.springRawFormulars()) {
			StringBuilder builded = form.getSpringForm();
			selectInputJSFunction.addSelectInputJSFunction(entityModel, builded, form.getFormName());
			limitCharCountBuilder.addLimitCharCountDown(context, builded, entityModel);
			writeForm(context, builded, form.getJspPath());
		}
	}

	private void writeForm(ServletContext context, StringBuilder builded, String path) {
		this.jspCreator = new FilesManagement();
		jspCreator.setPath(context, path);
		jspCreator.copyFileAndCreateDir(context,"WEB-INF/classes/fle/toolBox/springFormManager/limitCharCountDowJS/LimitCharCount.js",
				"resources/test/", "pleinlecul.js");
		try {
			jspCreator.writeInFile(builded.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
