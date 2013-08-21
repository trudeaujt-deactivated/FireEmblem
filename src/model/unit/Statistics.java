package model.unit;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private DamageType damageType;
        
    private List<Stat> stats;
    
    private Statistics(Builder builder) {

        this.damageType     = builder.damageType;
        
        stats = new ArrayList<Stat>(builder.stats);

    }
    
    public static class Builder {
        
        private final DamageType damageType;
        
        private Stat hp = Stat.HP;
        private Stat pow = Stat.POW;
        private Stat skill = Stat.SKILL;
        private Stat spd = Stat.SPD;
        private Stat luck = Stat.LUCK;
        private Stat def = Stat.DEF;
        private Stat res = Stat.RES;
        private Stat move = Stat.MOVE;
        private Stat con = Stat.CON;
        private Stat aid = Stat.AID;
        
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
    
    public Stat get(Stat p_stat) {

        Stat temp = null;
        
        for(Stat s : stats)
            if(s.name() == p_stat.name())
                temp = s;
        
        return temp;
        
    }

    @Override
    public String toString() {
        return "Statistics [damageType=" + damageType + ", stats=" + stats
                + "]";
    }

}
