import fle.toolBox.filesManagement.FilesManagement;

public class test {

	public static void main(String[] args) {
		FilesManagement file = new FilesManagement();
		//file.copyFile("src/fle/toolBox/MapToJson.java", "WebContent/resources/test/tesy.java");
		file.copyFileInputStream("src/fle/toolBox/MapToJson.java", "WebContent/resources/test/", "tesy.java");
		System.out.println("done");

	}

}
