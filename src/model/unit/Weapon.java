package model.unit;

public class Weapon implements Item {

    private ItemType type;
    private int durability;
    private int range;
    private int weight;
    private int might;
    private int hit;
    private int crit;
    private Rank rank;

    @Override
    public void use() {

    }

}
