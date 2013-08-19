package model.unit;

public class Weapon implements Item {

    private String name;
    private ItemType type;
    private int durability;
    private int range;
    private int weight;
    private int might;
    private int hit;
    private int crit;
    private Rank rank;
    
    public Weapon(Builder builder) {
        
        this.name           = builder.name;
        this.type           = builder.type;
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
        private ItemType type;
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

    }

    @Override
    public String toString() {
        return "Weapon [name=" + name + ", type=" + type + ", durability="
                + durability + ", range=" + range + ", weight=" + weight
                + ", might=" + might + ", hit=" + hit + ", crit=" + crit
                + ", rank=" + rank + "]";
    }

}
