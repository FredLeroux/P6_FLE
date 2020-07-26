package std.fle._12_controller.controllerClass.listController;

import java.util.List;

public class ListComponents {
	
	private List<?> list;
	private Object clazz;
	private String editControllerURI;
	
	
	public ListComponents(List<?> list, Object clazz, String editControllerURI) {		
		this.list = list;
		this.clazz = clazz;
		this.editControllerURI = editControllerURI;
	}


	public List<?> getList() {
		return list;
	}


	public void setList(List<?> list) {
		this.list = list;
	}


	public Object getClazz() {
		return clazz;
	}


	public void setClazz(Object clazz) {
		this.clazz = clazz;
	}


	public String getEditControllerURI() {
		return editControllerURI;
	}


	public void setEditControllerURI(String editControllerURI) {
		this.editControllerURI = editControllerURI;
	}
	
	
	
	

}
