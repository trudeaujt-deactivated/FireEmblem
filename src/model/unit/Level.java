package model.unit;

public class Level {

	private int experience;
	private int level;
	private int totalLevel;
	
	public Level() {
		
		experience = 0;
		level = 1;
		totalLevel = 1;
		
	}

	@Override
	public String toString() {
		return "Level [experience=" + experience + ", level=" + level
				+ ", totalLevel=" + totalLevel + "]";
	}
	
}
