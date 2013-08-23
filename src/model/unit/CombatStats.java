package model.unit;

public class CombatStats {

    private int hp;
    private int attack;
    private int defense;
    private int hit;
    private int crit;
    private int attackSpeed;

    public CombatStats(Builder builder) {

        this.hp = builder.hp;
        this.attack = builder.attack;
        this.defense = builder.defense;
        this.hit = builder.hit;
        this.crit = builder.crit;
        this.attackSpeed = builder.attackSpeed;

    }

    public static class Builder {

        private int hp;
        private int attack;
        private int defense;
        private int hit;
        private int crit;
        private int attackSpeed;

        public Builder(int p_hp) {

            this.hp = p_hp;

        }

        public Builder Atk(int p_attack) {

            this.attack = p_attack;
            return this;

        }

        public Builder Def(int p_defense) {

            this.defense = p_defense;
            return this;

        }

        public Builder Hit(double p_hit) {

            if(p_hit > 100)
                p_hit = 100;
            
            this.hit = (int) p_hit;
            return this;

        }

        public Builder Crit(double p_crit) {

            this.crit = (int) Math.floor(p_crit);
            return this;

        }

        public Builder AttackSpeed(int p_attackSpeed) {

            this.attackSpeed = p_attackSpeed;
            return this;

        }

        public CombatStats Build() {

            return new CombatStats(this);

        }

    }

    public int getHp() {
        
        return hp;
        
    }

    public int getAttack() {
        
        return attack;
        
    }

    public int getDefense() {
        
        return defense;
        
    }

    public int getHit() {
        
        return hit;
        
    }

    public int getCrit() {
        
        return crit;
        
    }

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
