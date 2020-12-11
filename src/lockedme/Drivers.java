package lockedme;

public class Drivers 
{
	
	public static void ApplicationDetails() 
	{
		final String APPNAME = "Locked Me"; //Application name
		final String DEV = "Developed by Nicholas Nicholson"; //Developer details
		
		System.out.println("------WELCOME TO------");
		System.out.println(APPNAME + ": " + DEV);
	}
	public static void WelcomeScreen() 
	{
		
	}
	public static void SystemOptions() 
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
	public static void FileManagerOptions() 
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
	public static void InvalidInput() {
		System.out.println("Invalid Input. Please select a different option.");
	}
	public static void CloseApplication() 
	{
		System.out.println("Closing Application, Goodbye");
		System.exit(0);
	}

}
