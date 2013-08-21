package model.unit;

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

    }

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

        public Builder(String p_name) {

            this.name = p_name;

        }

        public Builder Affinity(Affinity p_affinity) {

            this.affinityType = p_affinity;
            return this;

        }

        public Builder Class(UnitClass p_class) {

            this.classType = p_class;
            return this;

        }

        public Builder Condition(Condition p_condition) {

            this.condition = p_condition;
            return this;

        }

        public Builder Health(Health p_health) {

            this.health = p_health;
            return this;

        }

        public Builder Inventory(Inventory p_inventory) {

            this.inventory = p_inventory;
            return this;

        }

        public Builder Level(Level p_level) {

            this.level = p_level;
            return this;

        }

        public Builder Rescue(Unit p_rescue) {

            this.rescue = p_rescue;
            return this;

        }

        public Builder Stats(Statistics p_statistics) {

            this.stats = p_statistics;
            return this;

        }

        public Unit Build() {

            return new Unit(this);

        }

    }
    
    public void incrementExperience(int xp) {
        
        assert (xp >= 0 && xp <= 100) : xp;
        
        level.incrementExperience(xp);
        
    }

    private void levelUp() {

        System.out.println("Levelup occured! " + name + " is now level " + level.getLevel() + " with " + level.getExperience() + " xp.");
        stats.levelUp();
        health.setMaximumHealth(stats.get(Stat.HP).getValue());
        System.out.println("Max health is: " + health.getMaximumHealth());
        
    }
    
    public Level getLevel() {
        
        return level;
        
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
