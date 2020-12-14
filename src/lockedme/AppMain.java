package lockedme;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.lockedme.business.rules.DirectoryManager;
import com.lockedme.business.rules.Drivers;

public class AppMain {
		
	public static final Path DEFAULTDIRECTORY = Paths.get(System.getProperty("user.dir") + "./TempDirectory");
	
	static {

		DirectoryManager.GenerateTempDirectory(); //Create temp working directory
	}

	public static void main(String[] args) {

		Drivers.run();//Start application
	}
}


