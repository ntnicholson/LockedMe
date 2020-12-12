package lockedme;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import com.lockedme.interfaces.IApplicationInterface;
import com.lockedme.interfaces.IUserInteraction;

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
			case '1':
				DirectoryManager.GetDirectoryFiles(currentDirectory, fileList);
				DirectoryManager.DisplayDirectoryFiles(currentDirectory);
				break;
			case '2':
				do { // Inner loop
					FileManagerOptions();
					manage = in.next().charAt(0);
					
					if (manage == 'a') {
						
					}
					else if (manage == 'b') {
						
					}
					else if (manage == 'c') //Search for file
					{
						String path = GetUserInput(in);
						DirectoryManager.GetDirectoryFiles(currentDirectory, fileList);
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
	@Override
	public void GetUserInput(Scanner s) {
		// TODO Auto-generated method stub
		
	}
	private static void InvalidInput() {
		System.out.println("Invalid Input. Please select a different option.");
	}

}
