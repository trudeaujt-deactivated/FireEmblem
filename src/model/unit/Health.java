package model.unit;

/**
 * Defines an object for unit health.
 *
 * @author Jonathan Trudeau
 *
 */
public class Health {

    private int currentHealth;
    private int maximumHealth;

    /**
     * Constructs a Health object as defined.
     * 
     * @param p_maximumHealth - the maximum and current health
     */
    public Health(int p_maximumHealth) {

        maximumHealth = p_maximumHealth;
        currentHealth = p_maximumHealth;

    }

    /**
     * Updates the maximum health.
     * 
     * @param p_maximumHealth - the new maximum health
     */
    public void setMaximumHealth(int p_maximumHealth) {
        
        assert (p_maximumHealth > 0) : p_maximumHealth;
        
        if(maximumHealth < 61)
            maximumHealth = p_maximumHealth;
        
        if(currentHealth > maximumHealth)
            currentHealth = maximumHealth;
        
    }
    
    /**
     * Gets the current health as a primitive type.
     * 
     * @return the current health 
     */
    public int getCurrentHealth() {
        
        return currentHealth;
        
    }

    /**
     * Gets the maximum health as a primitive type.
     * 
     * @return the maximum health 
     */
    public int getMaximumHealth() {
        
        return maximumHealth;
        
    }
    
    @Override
    public String toString() {
        return "Health [currentHealth=" + currentHealth + ", maximumHealth="
                + maximumHealth + "]";
    }

}
