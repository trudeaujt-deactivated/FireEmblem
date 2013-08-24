package model.unit;

/**
 * Defines an object to handle levels, experience, and levelups.
 *
 * @author Jonathan Trudeau
 *
 */
public class Level implements Observable{

    /** Maximum level a unit can reach */
    private final int MAXIMUM_LEVEL = 20;
    
    private Observer observer;
    
    private int experience;
    private int level;
    private int totalLevel;

    /**
     * Constructs a Level object, with zero experience and a level and totalLevel of one.
     */
    public Level() {
        
        experience = 0;
        level = 1;
        totalLevel = 1;

    }

    /**
     * Increments experience by the specified amount.
     * 
     * @param xp - the experience to increment by
     */
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

    /**
     * Notifies observers that a levelup event has occured.
     */
    private void notifyLevelUp() {
        
        observer.update(this);
        
    }
    
    /**
     * Checks if the current level is the maximum possible level.
     * 
     * @return true if the maximum level has been reached, otherwise false
     */
    private boolean checkMaximumLevel() {
        
        return level == MAXIMUM_LEVEL;
        
    }
    
    /**
     * Gets the experience value as a primitive type.
     * 
     * @return the experience 
     */
    public int getExperience() {
        
        return experience;
        
    }

    /**
     * Gets the current level value as a primitive type.
     * 
     * @return the level 
     */
    public int getLevel() {
        
        return level;
        
    }

    @Override
    public String toString() {
        return "Level [experience=" + experience + ", level=" + level
                + ", totalLevel=" + totalLevel + "]";
    }

}
