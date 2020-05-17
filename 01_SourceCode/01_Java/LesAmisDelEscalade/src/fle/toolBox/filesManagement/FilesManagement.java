package fle.toolBox.filesManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
//TODO 1-JAVADOC
public class FilesManagement {
	String path = null;

	public String getPath() {
		return path;
	}

	/**
	 * 
	 * @param fullPath is the path where to create the file
	 * @Note: application path already set in this function add only the path after
	 *        the application name w/o '/', example :<br>
	 *        In an application WebApp, the target folder is: <br>
	 *        WebApp/WebContent/WEB-INF/views<br>
	 *        set only in path : <br>
	 *        WebContent/WEB-INF/views
	 */
	public void setPath(ServletContext context, String fullPath) {
		String appPath = context.getRealPath(fullPath);
		this.path = appPath;
	}

	public void setPath(ServletContext context, String path, String fileName, String extension) {
		String appPath = context.getRealPath(path).concat("/").concat(fileName).concat(".").concat(extension);
		this.path = appPath;
	}

	public void createFile() throws IOException {

		File file = new File(getPath());
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();

	}

	public void createFile(String path) throws IOException {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();

	}

	public void createFile(String fileName, String extension, String path) throws IOException {

		File file = new File(path + "/" + fileName + "." + extension);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();

	}

	public void writeInFile(String str) throws IOException {
		FileWriter fileWriter = new FileWriter(getPath());
		PrintWriter printwriter = new PrintWriter(fileWriter);
		printwriter.print(str);
		printwriter.close();
	}

	public void writeInFile(String str, String path) throws IOException {
		FileWriter fileWriter = new FileWriter(path);
		PrintWriter printwriter = new PrintWriter(fileWriter);
		printwriter.print(str);
		printwriter.close();
	}

	// TODO to finish see
	// https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
/*	public String ReadFile(String str) throws IOException {
		String filePath = this.path + "/" + this.fileName + "." + fileExtension;
		FileReader fileReader = new FileReader(filePath);
		fileReader.read();
		return null;
	}*/

}
