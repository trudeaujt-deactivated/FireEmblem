package model.unit;

public class Level implements Observable{

    /** Maximum level a unit can reach */
    private final int MAXIMUM_LEVEL = 20;
    
    private Observer observer;
    
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
        
        if(experience > 99 && level < MAXIMUM_LEVEL) {
            
            ++level;
            ++totalLevel;
            experience -= 100;
            
            if(checkMaximumLevel())
                experience = 0;
                
            notifyLevelUp();
            
        }
        
        else if(level == 20)
            experience = 0;
        
    }

    @Override
    public void registerObserver(Observer observer) {
        
        this.observer = observer;
        
    }

    private void notifyLevelUp() {
        
        observer.update(this);
        
    }
    
    private boolean checkMaximumLevel() {
        
        return level == MAXIMUM_LEVEL;
        
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
