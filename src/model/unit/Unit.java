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
        
        this.level.registerObserver(this);

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
        health.setMaximumHealth(stats.getValue(Stat.HP));
        
    }
    
    public Level getLevel() {
        
        return level;
        
    }
    
    public CombatStats getCombatStats() {
        
        Weapon currentWeapon = (Weapon) inventory.getEquippedItem();
                
        CombatStats cs = new 
                CombatStats.Builder(health.getCurrentHealth())
                .Atk(stats.getValue(Stat.POW)+ currentWeapon.getMight())
                .Def(stats.getValue(Stat.DEF))
                .Hit(currentWeapon.getHit() + stats.getValue(Stat.SKILL) * 2 + stats.getValue(Stat.LUCK) * 0.5)
                .Crit(currentWeapon.getCrit() + stats.getValue(Stat.SKILL) * 0.5)
                .AttackSpeed(stats.getValue(Stat.SPD))
                .Build();
        
        return cs;
        
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
