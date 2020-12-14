package com.lockedme.business.rules;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import com.lockedme.business.data.UserDirectory;
import com.lockedme.interfaces.IApplicationInterface;
import com.lockedme.interfaces.IUserInteraction;

import lockedme.AppMain;

public class Drivers implements IApplicationInterface, IUserInteraction
{
	public static void run() 
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Path> fileList = new ArrayList<>();
		UserDirectory currentDirectory = new UserDirectory(AppMain.DEFAULTDIRECTORY);
		char choice = 'z';
		char manage = 'z';
		
		ApplicationDetails();
		
		do {// Main loop
			SystemOptions(); // Get system options
			choice = in.next().charAt(0);

			switch (choice) 
			{
			case '1': //Display file names in directory
				DirectoryManager.GetDirectoryFiles(currentDirectory, fileList);
				DirectoryManager.DisplayDirectoryFiles(currentDirectory);
				break;
			case '2': //Manage files
				do { // Inner loop
					FileManagerOptions();
					manage = in.next().charAt(0);
					
					if (manage == 'a') {//Create a file
						String createFile = Drivers.GetUserFileName(in);
						FileHandler.CreateFile(currentDirectory, createFile);
						continue;
					} 
					else if (manage == 'b') {//Delete a file
						String deleteFile = Drivers.GetUserFileName(in);
						FileHandler.DeleteFile(currentDirectory, deleteFile);
						continue;
					}
					else if (manage == 'c') //Search for file
					{
						String path = Drivers.GetUserFileName(in);
						DirectoryManager.GetDirectoryFiles(currentDirectory, fileList);
						FileHandler.SearchFile(currentDirectory, path, fileList);
						continue;
					}
					else if (manage == 'x') {
						System.out.println("Returning to Main Menu");
						break;
					}
					else {
						InvalidInput();
						break;
					}
				} while (manage != 'x');
				break;
			case '3': //Change working directory
				DirectoryManager.ChangeCurrentDirectory(currentDirectory);
				break;
			case '0':
				break;
			default:
					InvalidInput();
					break;
			}
		} while (choice != '0');
		
		in.close();
		CloseApplication();
	}
	public static void ApplicationDetails() 
	{
		final String APPNAME = "Locked Me"; //Application name
		final String DEV = "Developed by Nicholas Nicholson"; //Developer details
		
		System.out.println("------WELCOME TO------");
		System.out.println(APPNAME + ": " + DEV);
	}
	private static void SystemOptions() 
	{
		System.out.println();
		System.out.println("--------Main Menu-------");
		System.out.println();
		System.out.println("   ~ Select an option ~ ");
		System.out.println();
		System.out.println("1. [ Display File Names ]");
		System.out.println("2. [ Manage Files ]");
		System.out.println("3. [ Change Current Working Directory ]");
		System.out.println("0: { Close Application }");
		System.out.println();
	}
	private static void FileManagerOptions() 
	{
		System.out.println();
		System.out.println("Select an option: ");
		System.out.println();
		System.out.println("a. [ Create a File ]");
		System.out.println("b. [ Delete a File ]");
		System.out.println("c. [ Search for a File ]");
		System.out.println("x: { Return to Main Menu }");
		System.out.println();
	}
	public static void CloseApplication() 
	{
		System.out.println("Closing Application, Goodbye");
		System.exit(0);
	}
	private static String GetUserFileName(Scanner s) {
		
		System.out.println("Input the name and extension of the file: ");
		String fName = s.next();
		
		return fName;		
	}
	private static void InvalidInput() {
		System.out.println("Invalid Input. Please select a different option.");
	}

}
