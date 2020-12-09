package lockedme;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> fileList = new ArrayList<>();
		char choice = 'z';
		char manage = 'z';

		do {// Main loop
			Drivers.SystemOptions(); // Get system options
			choice = in.next().charAt(0);

			switch (choice) 
			{
			case '1':
				break;
			case '2':
				do { // Inner loop
					Drivers.FileManagerOptions();
					manage = in.next().charAt(0);
					
					if (manage == 'a') {
						
					}
					else if (manage == 'b') {
						
					}
					else if (manage == 'c') {
						
					}
					else if (manage == 'z') {
						System.out.println("Returning to Main Menu");
						break;
					}
					else {
						InvalidInput();
					}
				} while (manage != 'x');
				break;
			case '3':
				break;
			case '0':
				break;
			default:
					InvalidInput();
					break;
			}
		} while (choice != '0');
		
		System.out.println("Goodbye");
		System.exit(0);
	}
	private static void InvalidInput() {
		System.out.println("Invalid Input. Please select a different option.");
	}
}


