package model.unit;

/**
 * Defines an object composed of various model.unit objects.
 *
 * @author Jonathan Trudeau
 *
 */
public class Unit implements Observer {

    private String name;
    private Affinity affinityType;
    private UnitClass classType;
    private Condition condition;
    private Health health;
    private Inventory inventory;
    private Level level;
    private Unit rescue;
    private Statistics stats;
    private CombatStats combatStats;

    /**
     * Constructs a Unit object as defined.
     * 
     * @param builder - the Builder used.
     */
    private Unit(Builder builder) {

        this.name           = builder.name;
        this.affinityType   = builder.affinityType;
        this.classType      = builder.classType;
        this.condition      = builder.condition;
        this.health         = builder.health;
        this.inventory      = builder.inventory;
        this.level          = builder.level;
        this.rescue         = builder.rescue;
        this.stats          = builder.stats;
        
        this.level.registerObserver(this);

    }

    /**
     * Defines a Builder for constructing a Unit object.
     *
     * @author Jonathan Trudeau
     *
     */
    public static class Builder {

        private final String name;
        private Affinity affinityType;
        private UnitClass classType;
        private Condition condition;
        private Health health;
        private Inventory inventory;
        private Level level;
        private Unit rescue;
        private Statistics stats;

        /**
         * Sets the name as defined. Required.
         * 
         * @param p_name - the name
         */
        public Builder(String p_name) {

            this.name = p_name;

        }

        /**
         * Sets the affinity as defined.
         * 
         * @param p_affinity - the affinity
         * 
         * @return the Builder
         */
        public Builder Affinity(Affinity p_affinity) {

            this.affinityType = p_affinity;
            return this;

        }

        /**
         * Sets the class type as defined.
         * 
         * @param p_class - the class
         * 
         * @return the Builder
         */
        public Builder Class(UnitClass p_class) {

            this.classType = p_class;
            return this;

        }

        /**
         * Sets the condition as defined.
         * 
         * @param p_condition - the condition
         * 
         * @return the Builder
         */
        public Builder Condition(Condition p_condition) {

            this.condition = p_condition;
            return this;

        }

        /**
         * Sets the Health as defined.
         * 
         * @param p_health - the health
         * 
         * @return the Builder
         */
        public Builder Health(Health p_health) {

            this.health = p_health;
            return this;

        }

        /**
         * Sets the inventory as defined.
         * 
         * @param p_inventory - the inventory
         * 
         * @return the Builder
         */
        public Builder Inventory(Inventory p_inventory) {

            this.inventory = p_inventory;
            return this;

        }

        /**
         * Sets the level as defined.
         * 
         * @param p_level - the level
         * 
         * @return the Builder
         */
        public Builder Level(Level p_level) {

            this.level = p_level;
            return this;

        }

        /**
         * Sets the rescued unit as defined.
         * 
         * @param p_rescue - the rescued unit
         * 
         * @return the Builder
         */
        public Builder Rescue(Unit p_rescue) {

            this.rescue = p_rescue;
            return this;

        }

        /**
         * Sets the statistics as defined.
         * 
         * @param p_statistics - the statistics
         * 
         * @return the Builder
         */
        public Builder Stats(Statistics p_statistics) {

            this.stats = p_statistics;
            return this;

        }

        /**
         * Constructs a Unit object with specified parameters.
         * 
         * @return the constructed Unit object.
         */
        public Unit Build() {

            return new Unit(this);

        }

    }
    
    /**
     * Increments experience of the Level by the specified amount.
     * 
     * @param xp - the experience to increment by
     */
    public void incrementExperience(int xp) {
        
        assert (xp >= 0 && xp <= 100) : xp;
        
        level.incrementExperience(xp);
        
    }

    /**
     * Performs a levelup operation.
     */
    private void levelUp() {

        System.out.println("Levelup occured! " + name + " is now level " + level.getLevel() + " with " + level.getExperience() + " xp.");
        stats.levelUp();
        health.setMaximumHealth(stats.getValue("HP"));
        
    }
    
    /**
     * Gets the level as a mutable object.
     * 
     * @return the level
     */
    public Level getLevel() {
        
        return level;
        
    }
    
    /**
     * Updates the combat statistics with values from statistics and equipped items.
     */
    private void updateCombatStats() {
        
        Weapon currentWeapon = (Weapon) inventory.getEquippedItem();
        
        combatStats = new 
                CombatStats.Builder(health.getCurrentHealth())
                .Atk(stats.getValue("POW")+ currentWeapon.getMight())
                .Def(stats.getValue("DEF"))
                .Hit(currentWeapon.getHit() + stats.getValue("SKILL") * 2 + stats.getValue("LUCK") * 0.5)
                .Crit(currentWeapon.getCrit() + stats.getValue("SKILL") * 0.5)
                .AttackSpeed(stats.getValue("SPD"))
                .Build();
        
    }
    
    /**
     * Gets the combat stats as a mutable object.
     * 
     * @return the combat stats
     */
    public CombatStats getCombatStats() {
        
        updateCombatStats();
        return combatStats;
        
    }

    @Override
    public void update(Observable observable) {
        
        levelUp();
        
    }

    @Override
    public String toString() {
        return "Unit [name=" + name + ", affinityType=" + affinityType
                + ", classType=" + classType + ", condition=" + condition
                + ", health=" + health + ", inventory=" + inventory
                + ", level=" + level + ", rescue=" + rescue + ", stats="
                + stats + "]";
    }

}
