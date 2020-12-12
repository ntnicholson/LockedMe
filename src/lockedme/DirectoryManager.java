package lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class DirectoryManager 
{
	public static void GetDirectoryFiles(UserDirectory dir, ArrayList<Path> arrList) 
	{
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir.getUserDirectory())) 
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
	public static void DisplayDirectoryFiles(UserDirectory dir) 
	{
		CurrentWorkingDirectory(dir);
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir.getUserDirectory())) 
		{
			
			for (Path file : stream) 
			{
				System.out.println(file.getFileName());
			}
		} catch (IOException | DirectoryIteratorException x) {
			System.err.println(x);
		}
	}
	
	public static void CurrentWorkingDirectory(UserDirectory current) 
	{
		File i = new File(current.getUserDirectory().toString());
		try {
			System.out.println("The Current Working Directory is: " + i.getCanonicalPath());
			System.out.println("--------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void ChangeCurrentDirectory(UserDirectory dir) 
	{
		Scanner n = new Scanner(System.in);
		String change = n.next();
		
		File x = new File(change);
		
		if (x.isDirectory()) 
		{
			dir.setUserDirectory(x.toPath());
		}
		else 
		{
			System.out.println("Error: Your input is not a valid directory.");
		}
		
		n.close();
	}

}
