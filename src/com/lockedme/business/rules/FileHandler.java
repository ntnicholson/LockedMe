package com.lockedme.business.rules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

import com.lockedme.business.data.UserDirectory;


public class FileHandler {

	public static void CreateFile(UserDirectory dir, String fileName) 
	{
		Path p = Paths.get(dir.getUserDirectory() + "\\" + fileName);
		
		try {
			Files.createFile(p);
			System.out.println("File: " + fileName + " was successfully created in: " + dir.getUserDirectory().toString());
		}catch (FileAlreadyExistsException x) {
			System.out.println("File " + fileName + " already exists.");
		}catch (IOException x) {
			System.out.println("Error creating file: " + x.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void DeleteFile(UserDirectory dir, String fileName) {
		
		Path p = Paths.get(dir.getUserDirectory() + "\\" + fileName);
		
		try {
			Files.delete(p);
			System.out.println("File: " + fileName + " was successfully deleted from: " + dir.getUserDirectory().toString());
		}catch (FileNotFoundException x) {
			System.out.println("File " + fileName + " was not found.");
		}catch (IOException x) {
			System.out.println("Error deleting file: " + x.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void SearchFile(UserDirectory dir, String fileName, ArrayList<Path> arrList) {
		
		Path path = Paths.get(dir.getUserDirectory() + "\\" + fileName); 
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
