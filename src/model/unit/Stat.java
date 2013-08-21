package model.unit;

import java.util.Random;

public enum Stat {

    HP(0, 0),
    POW(0, 0),
    SKILL(0, 0),
    SPD(0, 0),
    LUCK(0, 0),
    DEF(0, 0),
    RES(0,0),
    MOVE(0, 0),
    CON(0, 0),
    AID(0, 0);

    private int value;
    private int growthrate;
    
    private Random random;

    private Stat(int p_value, int p_growthrate) {

        value = p_value;
        growthrate = p_growthrate;
        
        random = new Random();

    }
    
    public void incrementValue() {
        
        int rand = random.nextInt(100);
        
        if(rand < growthrate) {
            
            System.out.print("Stat up! " + rand + " was rolled, with a growthrate of " + growthrate + " for Stat " + this.toString() + ". Was " + value);
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
    
    public int getValue() {
        
        return value;
        
    }
    
    public int getGrowthRate() {
        
        return growthrate;
        
    }

}
