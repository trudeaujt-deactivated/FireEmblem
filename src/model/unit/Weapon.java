package model.unit;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.type.UnknownTypeException;

/**
 * Defines a weapon object.
 *
 * @author Jonathan Trudeau
 *
 */
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
    
    /**
     * Constructs a Weapon object as defined.
     * 
     * @param builder - the Builder used.
     */
    private Weapon(Builder builder) {
        
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
    
    /**
     * Defines a Builder for constructing a Weapon object.
     *
     * @author Jonathan Trudeau
     *
     */
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
        
        /**
         * Sets the weapon name as defined. Required.
         * 
         * @param p_name - the name
         */
        public Builder(String p_name) {
            
            this.name = p_name;
            
        }
        
        /**
         * Sets the ItemType as defined.
         * 
         * @param p_type - the item type
         * 
         * @return the Builder
         * 
         * @throws UnknownTypeException
         */
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
        
        /**
         * Sets the Bonus target as defined.
         * 
         * @param p_bonus - the bonus target(s)
         * 
         * @return the Builder
         */
        public Builder Bonus(List<UnitType> p_bonus) {
            
            this.bonus = new ArrayList<UnitType>(p_bonus);
            return this;
            
        }
        
        /**
         * Sets the Durability as defined.
         * 
         * @param p_durability - the durability
         * 
         * @return the Builder
         */
        public Builder Durability(int p_durability) {
            
            this.durability = p_durability;
            return this;
            
        }
        
        /**
         * Sets the Range as defined.
         * 
         * @param p_range - the range
         * 
         * @return the Builder
         */
        public Builder Range(int p_range) {
            
            this.range = p_range;
            return this;
            
        }
        
        /**
         * Sets the Weight as defined.
         * 
         * @param p_weight - the weight
         * 
         * @return the Builder
         */
        public Builder Weight(int p_weight) {
            
            this.weight = p_weight;
            return this;
            
        }
        
        /**
         * Sets the Might as defined.
         * 
         * @param p_might - the might
         * 
         * @return the Builder
         */
        public Builder Might(int p_might) {
            
            this.might = p_might;
            return this;
            
        }
        
        /**
         * Sets the Hit as defined.
         * 
         * @param p_hit - the hit
         * 
         * @return the Builder
         */
        public Builder Hit(int p_hit) {
            
            this.hit = p_hit;
            return this;
            
        }

        /**
         * Sets the Crit as defined.
         * 
         * @param p_crit - the crit
         * 
         * @return the Builder
         */
        public Builder Crit(int p_crit) {
            
            this.crit = p_crit;
            return this;
            
        }
        
        /**
         * Sets the Rank as defined.
         * 
         * @param p_rank - the rank
         * 
         * @return the Builder
         */
        public Builder Rank(Rank p_rank) {
            
            this.rank = p_rank;
            return this;
            
        }
        
        /**
         * Constructs a Weapon object with specified parameters.
         * 
         * @return the constructed Weapon object
         */
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
    
    /**
     * Checks if the Weapon has the specified UnitType as a bonus target.
     * 
     * @param p_unitType - the unit type
     * 
     * @return true if the type is a target, false if not
     */
    public boolean hasBonus(UnitType p_unitType) {
        
        for(UnitType u : bonus)
            if(u.compareTo(p_unitType) == 0)
                return true;
        
        return false;
        
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
     * Gets the durability value as a primitive type.
     * 
     * @return the durability
     */
    public int getDurability() {
        
        return durability;
        
    }

    /**
     * Gets the range value as a primitive type.
     * 
     * @return the range
     */
    public int getRange() {
        
        return range;
        
    }

    /**
     * Gets the weight value as a primitive type.
     * 
     * @return the weight
     */
    public int getWeight() {
        
        return weight;
        
    }

    /**
     * Gets the might value as a primitive type.
     * 
     * @return the might
     */
    public int getMight() {
        
        return might;
        
    }

    /**
     * Gets the hit value as a primitive type.
     * 
     * @return the hit
     */
    public int getHit() {
        
        return hit;
        
    }

    /**
     * Gets the crit value as a primitive type.
     * 
     * @return the crit
     */
    public int getCrit() {
        
        return crit;
        
    }
    
    /**
     * Notifies observers when the Weapon has broken. 
     */
    public void notifyItemBroken() {
        
        observer.update(this);
        
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

}
