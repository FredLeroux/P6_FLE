package fle.toolBox.springFormManager.builder.annotationsManagement;

public class InputTextAreaAnnotation {
	
	private Integer rows;
	private Integer cols;
	private Integer maxLenght;
	private boolean readOnly;
	private String limitCharName;
	
	public InputTextAreaAnnotation(int rows,int cols,int maxLenght,boolean readOnly,String limitCharName) {
		this.rows =rows;
		this.cols=cols;
		this.maxLenght = maxLenght;
		this.readOnly = readOnly;
		this.limitCharName = limitCharName;
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

	public int getMaxLenght() {
		return maxLenght;
	}

	public void setMaxLenght(int maxLenght) {
		this.maxLenght = maxLenght;
	}

	public String getLimitCharName() {
		return limitCharName;
	}

	public void setLimitCharName(String limitCharName) {
		this.limitCharName = limitCharName;
	}

	
	
	
	
	

}
