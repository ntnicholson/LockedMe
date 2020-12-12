package lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;


public class FileHandler {

	public static void CreateFile(UserDirectory dir) 
	{
		String fileName = "December 20";
		String path = AppMain.DEFAULTDIRECTORY.toString() + "\\" + fileName; 
		
		File f = new File(path);
		System.out.println(f.toPath().toString());
	
	}
	public static void DeleteFile() {
		
		
	}
	public static void SearchFile(String fileName, ArrayList<Path> arrList) {
		
		Path path = Paths.get(AppMain.DEFAULTDIRECTORY.toString() + "\\" + fileName); 
		boolean matchFound = false;
		
		try {
			File x = new File(path.toString());
			
			for (Path p : arrList) 
			{
				
				if (p.toString().equals(path.toString())) 
				{
					matchFound = true;
				}
		
			}
			
			if (matchFound == true) 
			{
				System.out.println("Your file: " + fileName + " was found.");
			}
			else 
			{
				System.out.println("Your file: " + fileName + " was not found.");
			}
		}catch (Exception e) {
			
		}

	}
	
}
