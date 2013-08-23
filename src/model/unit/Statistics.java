package model.unit;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    
    private DamageType damageType;
        
    private List<Stat> stats;
    
    private Statistics(Builder builder) {

        this.damageType = builder.damageType;
        
        stats = new ArrayList<Stat>(builder.stats);

    }
    
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
        
        public Builder(DamageType p_damageType) {
            
            this.damageType = p_damageType;
            
        }
        
        public Builder Hp(int p_value, int p_growthrate) {
            
            this.hp.setValue(p_value);
            this.hp.setGrowthRate(p_growthrate);
            this.stats.add(this.hp);
            return this;
            
        }
        
        public Builder Power(int p_value, int p_growthrate) {
            
            this.pow.setValue(p_value);
            this.pow.setGrowthRate(p_growthrate);
            this.stats.add(this.pow);
            return this;
            
        }
        
        public Builder Skill(int p_value, int p_growthrate) {
            
            this.skill.setValue(p_value);
            this.skill.setGrowthRate(p_growthrate);
            this.stats.add(this.skill);
            return this;
            
        }
        
        public Builder Spd(int p_value, int p_growthrate) {
            
            this.spd.setValue(p_value);
            this.spd.setGrowthRate(p_growthrate);
            this.stats.add(this.spd);
            return this;
            
        }
        
        public Builder Luck(int p_value, int p_growthrate) {
            
            this.luck.setValue(p_value);
            this.luck.setGrowthRate(p_growthrate);
            this.stats.add(this.luck);
            return this;
            
        }
        
        public Builder Def(int p_value, int p_growthrate) {
            
            this.def.setValue(p_value);
            this.def.setGrowthRate(p_growthrate);
            this.stats.add(this.def);
            return this;
            
        }
        
        public Builder Res(int p_value, int p_growthrate) {
            
            this.res.setValue(p_value);
            this.res.setGrowthRate(p_growthrate);
            this.stats.add(this.res);
            return this;
            
        }
        
        public Builder Move(int p_value) {
            
            this.move.setValue(p_value);
            this.stats.add(this.move);
            return this;
            
        }
        
        public Builder Con(int p_value) {
            
            this.con.setValue(p_value);
            this.stats.add(this.con);
            return this;
            
        }
        
        public Builder Aid(int p_value) {
            
            this.aid.setValue(p_value);
            this.stats.add(this.aid);
            return this;
            
        }
        
        public Statistics Build() {

            return new Statistics(this);

        }
        
    }

    public void levelUp() {
        
        for(Stat s : stats)
            s.incrementValue();
        
    }
    
    public int getValue(String p_stat) {
        
        Stat s = new Stat(p_stat);
        Stat ret = getStat(s);
        return ret.getValue();
        
    }
    
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
