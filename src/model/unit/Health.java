package model.unit;

public class Health {

    private int currentHealth;
    private int maximumHealth;

    public Health(int p_maximumHealth) {

        maximumHealth = p_maximumHealth;
        currentHealth = p_maximumHealth;

    }

    @Override
    public String toString() {
        return "Health [currentHealth=" + currentHealth + ", maximumHealth="
                + maximumHealth + "]";
    }

}