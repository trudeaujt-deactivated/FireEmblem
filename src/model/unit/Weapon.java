package model.unit;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.UnknownTypeException;

public class Weapon implements Item, Observable {

    private Observer observer;
    
    private String name;
    private DamageType damageType;
    private ItemType type;
    private ItemType wta;
    private List<UnitType> bonus;
    private int durability;
    private int range;
    private int weight;
    private int might;
    private int hit;
    private int crit;
    private Rank rank;
    
    public Weapon(Builder builder) {
        
        this.name           = builder.name;
        this.damageType     = builder.damageType;
        this.type           = builder.type;
        this.wta            = builder.wta;
        this.bonus          = builder.bonus;
        this.durability     = builder.durability;
        this.range          = builder.range;
        this.weight         = builder.weight;
        this.might          = builder.might;
        this.hit            = builder.hit;
        this.crit           = builder.crit;
        this.rank           = builder.rank;
        
    }
    
    public static class Builder {
        
        private final String name;
        private DamageType damageType;
        private ItemType type;
        private ItemType wta;
        private ArrayList<UnitType> bonus;
        private int durability;
        private int range;
        private int weight;
        private int might;
        private int hit;
        private int crit;
        private Rank rank;
        
        public Builder(String p_name) {
            
            this.name = p_name;
            
        }
        
        public Builder ItemType(ItemType p_type) {
            
            this.type = p_type;
            
            if((this.type == ItemType.AXE) || (this.type == ItemType.BOW) || (this.type == ItemType.LANCE) || (this.type == ItemType.SWORD))
                damageType = DamageType.PHYSICAL;
            
            else if((this.type == ItemType.ANIMA) || (this.type == ItemType.DARK) || (this.type == ItemType.LIGHT) || (this.type == ItemType.STAFF))
                damageType = DamageType.PHYSICAL;
            
            else if((this.type == ItemType.USABLE))
                damageType = null;
            
            else
                throw new UnknownTypeException(null, p_type);
                        
            return this;
            
        }
        
        public Builder Bonus(List<UnitType> p_bonus) {
            
            this.bonus = new ArrayList<UnitType>(p_bonus);
            return this;
            
        }
        
        public Builder Durability(int p_durability) {
            
            this.durability = p_durability;
            return this;
            
        }
        
        public Builder Range(int p_range) {
            
            this.range = p_range;
            return this;
            
        }
        
        public Builder Weight(int p_weight) {
            
            this.weight = p_weight;
            return this;
            
        }
        
        public Builder Might(int p_might) {
            
            this.might = p_might;
            return this;
            
        }
        
        public Builder Hit(int p_hit) {
            
            this.hit = p_hit;
            return this;
            
        }

        public Builder Crit(int p_crit) {
            
            this.crit = p_crit;
            return this;
            
        }
        
        public Builder Rank(Rank p_rank) {
            
            this.rank = p_rank;
            return this;
            
        }
        
        public Weapon Build() {

            return new Weapon(this);

        }
        
    }

    @Override
    public void use() {

        this.durability--;
        
        if(durability == 0)
            notifyItemBroken();
        
    }
    
    public boolean hasBonus(UnitType p_unitType) {
        
        for(UnitType u : bonus)
            if(u.compareTo(p_unitType) == 0)
                return true;
        
        return false;
        
    }

    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public int getRange() {
        return range;
    }

    public int getWeight() {
        return weight;
    }

    public int getMight() {
        return might;
    }

    public int getHit() {
        return hit;
    }

    public int getCrit() {
        return crit;
    }

    @Override
    public String toString() {
        return "Weapon [name=" + name + ", type=" + type + ", bonus=" + bonus
                + ", durability=" + durability + ", range=" + range
                + ", weight=" + weight + ", might=" + might + ", hit=" + hit
                + ", crit=" + crit + ", rank=" + rank + "]";
    }

    @Override
    public void registerObserver(Observer observer) {
        
        this.observer = observer;
        
    }
    
    public void notifyItemBroken() {
        
        observer.update(this);
        
    }

}
