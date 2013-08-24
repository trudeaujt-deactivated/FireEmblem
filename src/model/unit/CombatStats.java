package model.unit;

/**
 * Defines an object for holding combat statistics.
 *
 * @author Jonathan Trudeau
 *
 */
public class CombatStats {

    private int hp;
    private int attack;
    private int defense;
    private int hit;
    private int crit;
    private int attackSpeed;

    /**
     * Constructs a CombatStats object as defined.
     * 
     * @param builder - the Builder used.
     */
    private CombatStats(Builder builder) {

        this.hp = builder.hp;
        this.attack = builder.attack;
        this.defense = builder.defense;
        this.hit = builder.hit;
        this.crit = builder.crit;
        this.attackSpeed = builder.attackSpeed;

    }

    /**
     * Defines a Builder for constructing a CombatStats object.
     *
     * @author Jonathan Trudeau
     *
     */
    public static class Builder {

        private int hp;
        private int attack;
        private int defense;
        private int hit;
        private int crit;
        private int attackSpeed;

        /**
         * Sets the HP as defined. Required.
         * 
         * @param p_hp - the hitpoints value
         */
        public Builder(int p_hp) {

            this.hp = p_hp;

        }

        /**
         * Sets the Atk as defined.
         * 
         * @param p_attack - the attack value
         * 
         * @return the Builder
         */
        public Builder Atk(int p_attack) {

            this.attack = p_attack;
            return this;

        }

        /**
         * Sets the Def as defined.
         * 
         * @param p_defense - the defense value
         * 
         * @return the Builder
         */
        public Builder Def(int p_defense) {

            this.defense = p_defense;
            return this;

        }

        /**
         * Sets the Hit as defined.
         * 
         * @param p_hit - the hit value
         * 
         * @return the Builder
         */
        public Builder Hit(double p_hit) {

            if(p_hit > 100)
                p_hit = 100;
            
            this.hit = (int) p_hit;
            return this;

        }

        /**
         * Sets the Crit as defined.
         * 
         * @param p_crit - the critical chance value
         * 
         * @return the Builder
         */
        public Builder Crit(double p_crit) {

            this.crit = (int) Math.floor(p_crit);
            return this;

        }

        /**
         * Sets the AttackSpeed as defined.
         * 
         * @param p_attackSpeed - the attack speed value
         * 
         * @return the Builder
         */
        public Builder AttackSpeed(int p_attackSpeed) {

            this.attackSpeed = p_attackSpeed;
            return this;

        }

        /**
         * Constructs a CombatStats object with specified parameters.
         * 
         * @return the constructed CombatStats object
         */
        public CombatStats Build() {

            return new CombatStats(this);

        }

    }

    /**
     * Gets the hitpoints as a primitive type.
     * 
     * @return the hitpoints value
     */
    public int getHp() {
        
        return hp;
        
    }

    /**
     * Gets the attack value as a primitive type.
     * 
     * @return the attack value
     */
    public int getAttack() {
        
        return attack;
        
    }

    /**
     * Gets the defense value as a primitive type.
     * 
     * @return the defense value 
     */
    public int getDefense() {
        
        return defense;
        
    }

    /**
     * Gets the hit value as a primitive type.
     * 
     * @return the hit value 
     */
    public int getHit() {
        
        return hit;
        
    }

    /**
     * Gets the critical hit chance value as a primitive type.
     * 
     * @return the crit value 
     */
    public int getCrit() {
        
        return crit;
        
    }

    /**
     * Gets the attack speed value as a primitive type.
     * 
     * @return the attack speed value 
     */
    public int getAttackSpeed() {
        
        return attackSpeed;
        
    }

    @Override
    public String toString() {
        return "CombatStats [hp=" + hp + ", attack=" + attack + ", defense="
                + defense + ", hit=" + hit + ", crit=" + crit
                + ", attackSpeed=" + attackSpeed + "]";
    }

}
