package fle.toolBox.filesManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import fle.toolBox.logger.Log4J2;
//TODO 1-JAVADOC
public class FilesManagement {
	
	private String path = null;
	private Log4J2<FilesManagement> logger = new Log4J2<FilesManagement>(this);
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

	public void createFile()  {
		File file = new File(getPath());
		deleteIfExist(file);
		createNewFile(file);

	}

	public void createFile(String path)  {
		File file = new File(path);
		deleteIfExist(file);
		createNewFile(file);

	}

	public void createFile(String fileName, String extension, String path)  {
		File file = new File(path + "/" + fileName + "." + extension);
		deleteIfExist(file);
		createNewFile(file);

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
	
	public void copyFile(String srcPath,String destPath) {
		Path src = Paths.get(srcPath);
		Path dest = Paths.get(destPath);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			logger.log().fatal(e);
		}
	}
	/**
	 * 
	 * @param context servlet context
	 * @param srcPath the full path containing file name(note: in case of package file change "src/" to "WEB-INF/classes")
	 * @param destPath the destination path ending by "/" w/o the file name
	 * @param fileName the full filename i.e.e with extension
	 * @apiNote allow to copy file from package(change "src/" to "WEB-INF/classes") or resources to destPath 
	 */
	public void copyFileAndCreateDir(ServletContext context,String srcPath,String destPath,String fileName) {
		Path path = Paths.get(servletPath(context, destPath));
		Path src = Paths.get(servletPath(context,srcPath));
		Path dest = Paths.get(servletPath(context, destPath).concat(fileName));
		if(!Files.exists(path)) {
			try {
				Files.createDirectory(path);
			} catch (IOException e) {
				logger.log().fatal(e);
				e.printStackTrace();
			}
		}			
		if(!Files.exists(dest)) {
			try {
				Files.copy(src, dest);
			} catch (IOException e1) {				
				logger.log().fatal(e1);
				e1.printStackTrace();
			}
		}
		
	}
	
	private String servletPath(ServletContext context,String filePath) {
		return context.getRealPath(filePath);
	}
	
	public void copyFileInputStream(String srcPath,String destPath,String fileName) {
		Path path = Paths.get(destPath);
		InputStream inputStream = null;
		File file = new File(srcPath);
		try {
			 inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!Files.exists(path)) {
			try {
				Files.createDirectory(path);
			} catch (IOException e) {
				logger.log().fatal(e);
				e.printStackTrace();
			}
		}			
		Path dest = Paths.get(destPath.concat(fileName));
		try {
			Files.copy(inputStream, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void createNewFile(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			logger.log().fatal(e);
		}
	}
	
	private void deleteIfExist(File file) {
		if (file.exists()) {
			file.delete();
		}
	}
	
	public String fileToString(String filePath) {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = bufferedReader(filePath);
		String line = null;
		try {
			while((line=bufferedReader.readLine()) != null) {
				stringBuilder.append(line+"\n");
			}
		} catch (IOException e) {
			logger.log().fatal(e);
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	
	private BufferedReader bufferedReader(String filePath) {
		BufferedReader reader = null;
		try {
			reader =  Files.newBufferedReader(path(filePath));
		} catch (IOException e) {
			logger.log().fatal(e);
			e.printStackTrace();
		}
		return reader;
	}
	
	private Path path(String filePath) {
		return Paths.get(filePath);
	}

	
}
