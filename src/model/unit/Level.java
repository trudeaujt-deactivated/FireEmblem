package model.unit;

public class Level implements Observable{

    Observer observer;
    
    private int experience;
    private int level;
    private int totalLevel;

    public Level() {
        
        experience = 0;
        level = 1;
        totalLevel = 1;

    }

    public void incrementExperience(int xp) {
        
        experience += xp;
        
        while(experience > 99 && level < 20) {
            
            ++level;
            ++totalLevel;
            experience -= 100;
            notifyLevelUp();
            
        }
        
    }

    @Override
    public void registerObserver(Observer observer) {
        
        this.observer = observer;
        
    }

    private void notifyLevelUp() {
        
        observer.update(this);
        
    }
    
    public int getExperience() {
        
        return experience;
        
    }

    public int getLevel() {
        
        return level;
        
    }

    @Override
    public String toString() {
        return "Level [experience=" + experience + ", level=" + level
                + ", totalLevel=" + totalLevel + "]";
    }

}
