package model.unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines an object for holding unit Stats.
 *
 * @author Jonathan Trudeau
 *
 */
public class Statistics {
    
    private DamageType damageType;
        
    private List<Stat> stats;
    
    /**
     * Constructs a Statistics object as defined.
     * 
     * @param builder - the Builder used.
     */
    private Statistics(Builder builder) {

        this.damageType = builder.damageType;
        
        stats = new ArrayList<Stat>(builder.stats);

    }
    
    /**
     * Defines a Builder for constructing a Statistics object.
     *
     * @author Jonathan Trudeau
     *
     */
    public static class Builder {
        
        private final DamageType damageType;
        
        private Stat hp     = new Stat("HP");
        private Stat pow    = new Stat("POW");
        private Stat skill  = new Stat("SKILL");
        private Stat spd    = new Stat("SPD");
        private Stat luck   = new Stat("LUCK");
        private Stat def    = new Stat("DEF");
        private Stat res    = new Stat("RES");
        private Stat move   = new Stat("MOVE");
        private Stat con    = new Stat("CON");
        private Stat aid    = new Stat("AID");
        
        private List<Stat> stats = new ArrayList<Stat>();
        
        /**
         * Sets the DamageType as defined.
         * 
         * @param p_damageType - the damage type
         */
        public Builder(DamageType p_damageType) {
            
            this.damageType = p_damageType;
            
        }
        
        /**
         * Sets the HP Stat as defined.
         * 
         * @param p_value - the value
         * @param p_growthrate - the growthrate
         * 
         * @return the Builder
         */
        public Builder Hp(int p_value, int p_growthrate) {
            
            this.hp.setValue(p_value);
            this.hp.setGrowthRate(p_growthrate);
            this.stats.add(this.hp);
            return this;
            
        }
        
        /**
         * Sets the Power Stat as defined.
         * 
         * @param p_value - the value
         * @param p_growthrate - the growthrate
         * 
         * @return the Builder
         */
        public Builder Power(int p_value, int p_growthrate) {
            
            this.pow.setValue(p_value);
            this.pow.setGrowthRate(p_growthrate);
            this.stats.add(this.pow);
            return this;
            
        }
        
        /**
         * Sets the Skill Stat as defined.
         * 
         * @param p_value - the value
         * @param p_growthrate - the growthrate
         * 
         * @return the Builder
         */
        public Builder Skill(int p_value, int p_growthrate) {
            
            this.skill.setValue(p_value);
            this.skill.setGrowthRate(p_growthrate);
            this.stats.add(this.skill);
            return this;
            
        }
        
        /**
         * Sets the Spd value as defined.
         * 
         * @param p_value - the value
         * @param p_growthrate - the growthrate
         * 
         * @return the Builder
         */
        public Builder Spd(int p_value, int p_growthrate) {
            
            this.spd.setValue(p_value);
            this.spd.setGrowthRate(p_growthrate);
            this.stats.add(this.spd);
            return this;
            
        }
        
        /**
         * Sets the Luck value as defined.
         * 
         * @param p_value - the value
         * @param p_growthrate - the growthrate
         * 
         * @return the Builder
         */
        public Builder Luck(int p_value, int p_growthrate) {
            
            this.luck.setValue(p_value);
            this.luck.setGrowthRate(p_growthrate);
            this.stats.add(this.luck);
            return this;
            
        }
        
        /**
         * Sets the Def value as defined.
         * 
         * @param p_value - the value
         * @param p_growthrate - the growthrate
         * 
         * @return the Builder
         */
        public Builder Def(int p_value, int p_growthrate) {
            
            this.def.setValue(p_value);
            this.def.setGrowthRate(p_growthrate);
            this.stats.add(this.def);
            return this;
            
        }
        
        /**
         * Sets the Res value as defined.
         * 
         * @param p_value - the value
         * @param p_growthrate - the growthrate
         * 
         * @return the Builder
         */
        public Builder Res(int p_value, int p_growthrate) {
            
            this.res.setValue(p_value);
            this.res.setGrowthRate(p_growthrate);
            this.stats.add(this.res);
            return this;
            
        }
        
        /**
         * Sets the Move value as defined.
         * 
         * @param p_value - the value
         * 
         * @return the Builder
         */
        public Builder Move(int p_value) {
            
            this.move.setValue(p_value);
            this.stats.add(this.move);
            return this;
            
        }
        
        /**
         * Sets the Con value as defined.
         * 
         * @param p_value - the value
         * 
         * @return the Builder
         */
        public Builder Con(int p_value) {
            
            this.con.setValue(p_value);
            this.stats.add(this.con);
            return this;
            
        }
        
        /**
         * Sets the Aid value as defined.
         * 
         * @param p_value - the value
         * 
         * @return the Builder
         */
        public Builder Aid(int p_value) {
            
            this.aid.setValue(p_value);
            this.stats.add(this.aid);
            return this;
            
        }
        
        /**
         * Constructs a Statistics object with specified parameters.
         * 
         * @return the constructed Statistics object
         */
        public Statistics Build() {

            return new Statistics(this);

        }
        
    }

    /**
     * Tells each Stat to increment its value.
     */
    public void levelUp() {
        
        for(Stat s : stats)
            s.incrementValue();
        
    }
    
    /**
     * Returns the value of the specified Stat.
     * 
     * @param p_stat - the stat
     * @return gets the stat value as a primitive type
     */
    public int getValue(String p_stat) {
        
        Stat s = new Stat(p_stat);
        Stat ret = getStat(s);
        return ret.getValue();
        
    }
    
    /**
     * Returns the Stat matching the defined Stat.
     * 
     * @param p_stat - the stat to fetch
     * @return gets the Stat as a mutable object
     */
    private Stat getStat(Stat p_stat) {

        Stat temp = null;
        
        for(Stat s : stats)
            if(s.getName() == p_stat.getName())
                temp = s;
        
        return temp;
        
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        for(Stat s : stats) {
            
            sb.append(s.toString() + ": " + s.getValue() + " " + s.getGrowthRate() + " ");
            
        }
        
        return sb.toString();
        
    }

}
