package lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
		
	public static final Path DEFAULTDIRECTORY = Paths.get(System.getProperty("user.dir") + "./FileDirectory");

	public static void main(String[] args) {

		Drivers.run();//Start application
	}
}


