package lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;


public class FileHandler {

	public static void GetDirectoryFiles(Path pathName, ArrayList<Path> arrList) 
	{
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(pathName)) 
		{
			arrList.clear();
			
			for (Path file : stream) 
			{
				arrList.add(file);
				//System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
		}
	}
	public static void DisplayDirectoryFiles(Path pathName) 
	{
		CurrentWorkingDirectory(pathName);
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(pathName)) 
		{
			
			for (Path file : stream) 
			{
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
		}
	}
	
	public static void CurrentWorkingDirectory(Path dir) 
	{
		File i = new File(dir.toString());
		try {
			System.out.println("The Current Working Directory is: " + i.getCanonicalPath());
			System.out.println("--------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void CreateFile(String fileName) 
	{
		fileName = "December 20";
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
