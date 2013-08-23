package model.unit;

import java.util.Random;

public class Stat {

    private String name;
    private int value;
    private int growthrate;

    private Random random;

    public Stat(String p_name) {

        setName(p_name);

        random = new Random();

    }

    public Stat(String p_name, int p_value, int p_growthrate) {

        setName(p_name);
        setValue(p_value);
        setGrowthRate(p_growthrate);

        random = new Random();

    }

    private void setName(String n) {

        assert (n.equals("HP") || n.equals("POW") || n.equals("SKILL")
                || n.equals("SPD") || n.equals("LUCK") || n.equals("DEF")
                || n.equals("DEF") || n.equals("RES") || n.equals("MOVE")
                || n.equals("CON") || n.equals("AID")) : n;

        name = n;

    }

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

    public void setValue(int p_value) {

        assert (p_value >= 0) : p_value;
        value = p_value;

    }

    public void setGrowthRate(int p_growthrate) {

        assert (p_growthrate >= 0) : p_growthrate;
        growthrate = p_growthrate;

    }

    public String getName() {

        return name;

    }

    public int getValue() {

        return value;

    }

    public int getGrowthRate() {

        return growthrate;

    }

    @Override
    public String toString() {
        
        return "Stat [name=" + name + "]";
        
    }

}
