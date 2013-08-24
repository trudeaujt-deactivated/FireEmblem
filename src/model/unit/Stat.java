package model.unit;

import java.util.Random;

/**
 * Defines a stat object.
 *
 * @author Jonathan Trudeau
 *
 */
public class Stat {

    private String name;
    private int value;
    private int growthrate;

    private Random random;

    /**
     * Constructs a Stat object, with a value and growth rate of zero.
     * 
     * @param p_name - the name
     */
    public Stat(String p_name) {

        setName(p_name);
        setValue(0);
        setGrowthRate(0);

        random = new Random();

    }

    /**
     * Constructs a Stat object as defined.
     * 
     * @param p_name - the name
     * @param p_value - the value
     * @param p_growthrate - the growth rate
     */
    public Stat(String p_name, int p_value, int p_growthrate) {

        setName(p_name);
        setValue(p_value);
        setGrowthRate(p_growthrate);

        random = new Random();

    }

    /**
     * Sets the name of the Stat.
     * 
     * @param n - the name
     */
    private void setName(String n) {

        assert (n.equals("HP") || n.equals("POW") || n.equals("SKILL")
                || n.equals("SPD") || n.equals("LUCK") || n.equals("DEF")
                || n.equals("DEF") || n.equals("RES") || n.equals("MOVE")
                || n.equals("CON") || n.equals("AID")) : n;

        name = n;

    }

    /**
     * Increments the Stat's value if a valid number is rolled.
     */
    public void incrementValue() {

        int rand = random.nextInt(100);

        if (rand < growthrate) {

            System.out.print("Stat up! " + rand
                    + " was rolled, with a growthrate of " + growthrate
                    + " for Stat " + this.getName() + ". Was " + value);
            setValue(value + 1);
            System.out.println(" and is now " + value);

        }

    }

    /**
     * Sets the value of the Stat as defined.
     * 
     * @param p_value - the value
     */
    public void setValue(int p_value) {

        assert (p_value >= 0) : p_value;
        value = p_value;

    }

    /**
     * Sets the growth rate of the Stat as defined.
     * 
     * @param p_growthrate - the growth rate
     */
    public void setGrowthRate(int p_growthrate) {

        assert (p_growthrate >= 0) : p_growthrate;
        growthrate = p_growthrate;

    }

    /** 
     * Gets the name as a mutable object.
     * 
     * @return the name 
     */
    public String getName() {

        return name;

    }

    /**
     * Gets the value as a primitive type.
     * 
     * @return the value 
     */
    public int getValue() {

        return value;

    }

    /**
     * Gets the growth rate as a primitive type.
     * 
     * @return the growth rate 
     */
    public int getGrowthRate() {

        return growthrate;

    }

    @Override
    public String toString() {
        
        return "Stat [name=" + name + "]";
        
    }

}
