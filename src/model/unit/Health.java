package model.unit;

public class Health {

    private int currentHealth;
    private int maximumHealth;

    public Health(int p_maximumHealth) {

        maximumHealth = p_maximumHealth;
        currentHealth = p_maximumHealth;

    }

    public void setMaximumHealth(int p_maximumHealth) {
        
        assert (p_maximumHealth > 0) : p_maximumHealth;
        
        if(maximumHealth < 61)
            maximumHealth = p_maximumHealth;
        
        if(currentHealth > maximumHealth)
            currentHealth = maximumHealth;
        
    }
    
    public int getCurrentHealth() {
        
        return currentHealth;
        
    }

    public int getMaximumHealth() {
        
        return maximumHealth;
        
    }
    
    @Override
    public String toString() {
        return "Health [currentHealth=" + currentHealth + ", maximumHealth="
                + maximumHealth + "]";
    }

}
