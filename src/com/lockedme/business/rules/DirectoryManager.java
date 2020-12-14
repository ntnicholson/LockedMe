package com.lockedme.business.rules;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.lockedme.business.data.UserDirectory;

import lockedme.AppMain;

public class DirectoryManager 
{
	public static void GenerateTempDirectory() 
	{
		try
		{
			Files.createDirectory(AppMain.DEFAULTDIRECTORY);
			
		}catch(NoSuchFileException x) {
			x.printStackTrace();
		}catch(FileAlreadyExistsException x) {
			x.printStackTrace();
		}
		catch(IOException x) {
			x.printStackTrace();
		}catch(Exception x) {
			x.printStackTrace();
		}
	}
	public static void GetDirectoryFiles(UserDirectory dir, ArrayList<Path> arrList) 
	{
		
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir.getUserDirectory())) 
		{
			arrList.clear();
			
			for (Path file : stream) 
			{
				arrList.add(file);
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
			System.out.println(x);
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
		Scanner in = new Scanner(System.in);
		System.out.println("Input the path of the new directory: ");
		String change = in.next();
		
		File x = new File(change);
		Path p = Paths.get(x.toURI());
		//System.out.println("Path: " + p.toString());
	
		if (x.isDirectory()) 
		{
			dir.setUserDirectory(x.toPath());
			System.out.println("The Current Working Directory has been changed to: " + dir.getUserDirectory().toString());
		}
		else 
		{
			System.out.println("Error: Your input is not a valid directory.");
		}
		
	}

}
