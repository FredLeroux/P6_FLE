package fle.toolBox.springFormManager.builder;
/**
 * 
 * @author Frederic Leroux <br>
 * @version 1.0
 * @apiNote class containing raw formular data i.e.<br>
 * <li> jspPath is where to write the spring formular
 * <li> formName is the formular name 
 * <li> springForm is the created formular as StringBuilder
 */
public class SpringRawFormular {

	String jspPath;
	String formName;
	StringBuilder springForm;

	public SpringRawFormular(String jspPath, String formName, StringBuilder springForm) {
		this.jspPath = jspPath;
		this.formName = formName;
		this.springForm = springForm;
	}

	public String getJspPath() {
		return jspPath;
	}

	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public StringBuilder getSpringForm() {
		return springForm;
	}

	public void setSpringForm(StringBuilder springForm) {
		this.springForm = springForm;
	}

}
