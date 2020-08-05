package fle.toolBox.controllerTools.listManagement.dataListDisplayerTools.annotations.operator;

public enum OperatorArrays {
	
	INFERIOR(new String[] {"<"}),
	EQUAL(new String[]{"="}),
	SUPERIOR(new String[]{">"}),
	INFERIOR_EQUAL(new String[]{"<","="}),
	EQUAL_SUPERIOR(new String[]{"=",">"}),
	INFERIOR_SUPERIOR(new String[]{"<",">"}),
	INFERIOR_EQUAL_SUPERIOR(new String[]{"<","=",">"})
	;
	
	private String[] signsArray;

	private OperatorArrays(String[] signsArray) {
		this.signsArray = signsArray;
	}
	
	public String[] getSignsArray() {
		return signsArray;
	}

	

}
