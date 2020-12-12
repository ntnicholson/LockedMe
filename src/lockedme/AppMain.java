package lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
		
	public static final Path DEFAULTDIRECTORY = Paths.get(System.getProperty("user.dir") + "./FileDirectory");

	public static void main(String[] args) {

		Drivers.run();//Start application
	}
	public static void printFilePath(String pathname) {
	    File f = new File(pathname);
	    System.out.println("File  Name: " + f.getName());
	    
	    if (f.exists()) {
		    if (f.isFile()) {
		    	System.out.println("File  exists: " + f.exists());
		    }
		    else if (f.isDirectory()) {
		    	System.out.println("Directory  exists: " + f.exists());
		    }
	    }
	    
	    System.out.println("Absolute Path: " + f.getAbsolutePath());

	    try {
	      System.out.println("Canonical Path: " + f.getCanonicalPath());
	    }

	    catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public static String GetUserFile(Scanner s) {
		System.out.println("Input the name and extension of the file you want to search for: ");
		String path = s.next();
		
		return path;	
	}
}


