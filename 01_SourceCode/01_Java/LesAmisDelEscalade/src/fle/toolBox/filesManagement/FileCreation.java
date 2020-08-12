package fle.toolBox.filesManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;

import fle.toolBox.logger.Log4J2;

/**
 *
 * @author Frederic Leroux
 * @Note this classe allow to create different type of file at different place
 *       <br>
 *       the method createFile() has 3 polymorphism see description of each one.
 *
 */
public class FileCreation {
	private String path = null;
	private String fileName = null;
	private String fileExtension = null;
	private Log4J2<FileCreation> logger = new Log4J2<FileCreation>(this);

	public FileCreation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @note this constructor set the required path,filename,extension,context for
	 *       the method createFile() w/o parameters,<br>
	 *       <b>this constructor is to be used in a WebApp context</b>
	 * @param context
	 * @param path          is the path where to create the file<br>
	 *                      <b>Note :</b> <br>
	 *                      application path already set in this method,<br>
	 *                      add only the path after the application name w/o '/',
	 *                      example :<br>
	 *                      In an application WebApp, the target folder is: <br>
	 *                      WebApp/WEB-INF/views<br>
	 *                      set only in path : <br>
	 *                      /WEB-INF/views
	 * @param fileName
	 * @param fileExtension
	 */
	public FileCreation(ServletContext context, String path, String fileName, String fileExtension) {
		setFileName(fileName);
		setExtension(fileExtension);
		setPath(context, path);
	}

	public String getPath() {
		return path;
	}

	/**
	 *
	 * @param path is the path where to create the file
	 * @Note: application path already set in this function add only the path after
	 *        the application name w/o '/', example :<br>
	 *        In an application WebApp, the target folder is: <br>
	 *        WebApp/WebContent/WEB-INF/views<br>
	 *        set only in path : <br>
	 *        WebContent/WEB-INF/views
	 */
	public void setPath(ServletContext context, String path) {
		String appPath = context.getRealPath(path);
		this.path = appPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String name) {
		this.fileName = name;
	}

	public String getExtension() {
		return fileExtension;
	}

	public void setExtension(String extension) {
		this.fileExtension = extension;
	}

	private void createNewFile(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			logger.log().fatal(e);
		}
	}

	/**
	 * create a new file function of information setted via method
	 * setPath(),setFileName(),setFileExtension(),<br>
	 * or to be use with the constructor<br>
	 * new FileCreation(ServletContext context, String path, String fileName, String
	 * fileExtension)
	 */
	public void createFile() {
		File file = new File(this.path + "/" + this.fileName + "." + fileExtension);
		if (file.exists()) {
			file.delete();
		}
		createNewFile(file);
	}

	/**
	 * create new file function of path parameter
	 *
	 * @param path string containing all informations<br>
	 *             i.e. path/fileName.fileExtension
	 */
	public void createFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		createNewFile(file);

	}

	/**
	 * create a new file function of parameters
	 *
	 * @param fileName
	 * @param extension
	 * @param path
	 */
	public void createFile(String fileName, String extension, String path) {
		File file = new File(path + "/" + fileName + "." + extension);
		if (file.exists()) {
			file.delete();
		}
		createNewFile(file);

	}


	public void writeInFile1(String str) throws IOException {
		String filePath = this.path + "/" + this.fileName + "." + fileExtension;
		FileWriter fileWriter = new FileWriter(filePath);
		PrintWriter printwriter = new PrintWriter(fileWriter);
		printwriter.print(str);
		printwriter.close();
	}


}
