package fle.toolBox.springFormManager.builder.annotationsManagement;

public class InputTextAreaAnnotation {
	
	private Integer rows;
	private Integer cols;
	
	
	public InputTextAreaAnnotation(int rows,int cols) {
		this.rows =rows;
		this.cols=cols;
	}
	
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	
	

}
