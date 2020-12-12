package lockedme;

import java.nio.file.Path;

public class UserDirectory
{
	private Path userDirectory;
	
	public UserDirectory(Path directory)
	{
		this.userDirectory = directory;
	}
	public Path getUserDirectory() {
		return userDirectory;
	}

	public void setUserDirectory(Path userDirectory) {
		this.userDirectory = userDirectory;
	}
}
