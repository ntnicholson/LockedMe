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
		Scanner in = new Scanner(System.in);
		//ArrayList<String> fileList = new ArrayList<>();
		ArrayList<Path> fileList = new ArrayList<>();
		char choice = 'z';
		char manage = 'z';

		//Start application
		Drivers.ApplicationDetails();
		do {// Main loop
			Drivers.SystemOptions(); // Get system options
			choice = in.next().charAt(0);

			switch (choice) 
			{
			case '1':
				FileHandler.GetDirectoryFiles(DEFAULTDIRECTORY, fileList);
				FileHandler.DisplayDirectoryFiles(DEFAULTDIRECTORY);
				break;
			case '2':
				do { // Inner loop
					Drivers.FileManagerOptions();
					manage = in.next().charAt(0);
					
					if (manage == 'a') {
						
					}
					else if (manage == 'b') {
						
					}
					else if (manage == 'c') //Search for file
					{
						String path = GetUserInput(in);
						FileHandler.GetDirectoryFiles(DEFAULTDIRECTORY, fileList);
						FileHandler.SearchFile(path, fileList);
					}
					else if (manage == 'x') {
						System.out.println("Returning to Main Menu");
						break;
					}
					else {
						Drivers.InvalidInput();
					}
				} while (manage != 'x');
				break;
			case '3':
				break;
			case '0':
				break;
			default:
					Drivers.InvalidInput();
					break;
			}
		} while (choice != '0');
		
		Drivers.CloseApplication();
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
	
	public static String GetUserInput(Scanner s) {
		System.out.println("Input the name and extension of the file you want to search for: ");
		String path = s.next();
		
		return path;
		
	}
}


