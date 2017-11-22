package logic;

import java.io.File;

final class LevelFileCounter {
	
	private int numberofLevels = 0;
	
	protected LevelFileCounter() {
		
		while (new File("levels/level" + numberofLevels + ".xml").exists())
			numberofLevels++;
	}
	
	protected int getNumberofLevels() {
		return numberofLevels;
	}

}
