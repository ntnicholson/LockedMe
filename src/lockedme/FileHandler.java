package lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;


public class FileHandler {

	public static void DisplayDirectoryFiles(Path pathName) 
	{
		CurrentWorkingDirectory();
		
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
	public static void CurrentWorkingDirectory() 
	{
		System.out.println("The Current Working Directory is: " );
		
	}
	public static void CreateFile(String fileName) 
	{
		fileName = "December 20";
		String path = AppMain.TEMP.toString() + "\\" + fileName; 
		
		File f = new File(path);
		System.out.println(f.toPath().toString());
	
	}
	public static void DeleteFile() {
		
		
	}
	public static void SearchFile() {
		
		Path x = Paths.get("");
		x.toString();
	}
	
}
