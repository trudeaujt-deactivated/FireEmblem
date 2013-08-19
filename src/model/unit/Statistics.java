package model.unit;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private DamageType damageType;
    
    private Stat pow;
    private Stat skill;
    private Stat spd;
    private Stat luck;
    private Stat def;
    private Stat res;
    private Stat move;
    private Stat con;
    private Stat aid;
    
    public Statistics(Builder builder) {

        this.damageType     = builder.damageType;
        this.pow            = builder.pow;
        this.skill          = builder.skill;
        this.spd            = builder.spd;
        this.luck           = builder.luck;
        this.def            = builder.def;
        this.res            = builder.res;
        this.move           = builder.move;
        this.con            = builder.con;
        this.aid            = builder.aid;

    }
    
    public static class Builder {
        
        private final DamageType damageType;
        
        private Stat pow = Stat.POW;
        private Stat skill = Stat.SKILL;
        private Stat spd = Stat.SPD;
        private Stat luck = Stat.LUCK;
        private Stat def = Stat.DEF;
        private Stat res = Stat.RES;
        private Stat move = Stat.MOVE;
        private Stat con = Stat.CON;
        private Stat aid = Stat.AID;
        
        public Builder(DamageType p_damageType) {
            
            this.damageType = p_damageType;
            
        }
        
        public Builder Power(int p_value, int p_growthrate) {
            
            this.pow.setValue(p_value);
            this.pow.setGrowthRate(p_growthrate);
            return this;
            
        }
        
        public Builder Skill(int p_value, int p_growthrate) {
            
            this.skill.setValue(p_value);
            this.skill.setGrowthRate(p_growthrate);
            return this;
            
        }
        
        public Builder Spd(int p_value, int p_growthrate) {
            
            this.spd.setValue(p_value);
            this.spd.setGrowthRate(p_growthrate);
            return this;
            
        }
        
        public Builder Luck(int p_value, int p_growthrate) {
            
            this.luck.setValue(p_value);
            this.luck.setGrowthRate(p_growthrate);
            return this;
            
        }
        
        public Builder Def(int p_value, int p_growthrate) {
            
            this.def.setValue(p_value);
            this.def.setGrowthRate(p_growthrate);
            return this;
            
        }
        
        public Builder Res(int p_value, int p_growthrate) {
            
            this.res.setValue(p_value);
            this.res.setGrowthRate(p_growthrate);
            return this;
            
        }
        
        public Builder Move(int p_value) {
            
            this.move.setValue(p_value);
            return this;
            
        }
        
        public Builder Con(int p_value) {
            
            this.con.setValue(p_value);
            return this;
            
        }
        
        public Builder Aid(int p_value) {
            
            this.aid.setValue(p_value);
            return this;
            
        }
        
        public Statistics Build() {

            return new Statistics(this);

        }
        
    }


    @Override
    public String toString() {
        return "Statistics [damageType=" + damageType + ", pow=" + pow.getValue() + " " + pow.getGrowthRate()
                + ", skill=" + skill.getValue() + " " + skill.getGrowthRate() + ", spd=" + spd.getValue() + " " + spd.getGrowthRate() 
                + ", luck=" + luck.getValue() + " " + luck.getGrowthRate()
                + ", def=" + def.getValue() + " " + def.getGrowthRate() + ", res=" + res.getValue() + " " + res.getGrowthRate() 
                + ", move=" + move.getValue() + ", con=" + con.getValue() + ", aid=" + aid.getValue() + "]";
    }

}
