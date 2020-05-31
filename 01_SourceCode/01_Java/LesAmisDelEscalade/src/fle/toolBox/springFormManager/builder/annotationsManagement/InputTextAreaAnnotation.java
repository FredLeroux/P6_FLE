package fle.toolBox.springFormManager.builder.annotationsManagement;

public class InputTextAreaAnnotation {
	
	private Integer rows;
	private Integer cols;
	private boolean readOnly;
	
	
	public InputTextAreaAnnotation(int rows,int cols,boolean readOnly) {
		this.rows =rows;
		this.cols=cols;
		this.readOnly = readOnly;
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

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	
	
	
	

}
