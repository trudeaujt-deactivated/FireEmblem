package test;

import model.unit.Inventory;
import model.unit.ItemType;
import model.unit.Rank;
import model.unit.Weapon;

public class ItemTester {

    public static void main(final String[] args) {
        
        Inventory inventory = new Inventory();
        
        Weapon ironSword = new 
                Weapon.Builder("Iron Sword")
                .ItemType(ItemType.SWORD)
                .Durability(4)
                .Range(1)
                .Weight(5)
                .Might(5)
                .Hit(90)
                .Crit(0)
                .Rank(Rank.E)
                .Build();
        
        ironSword.registerObserver(inventory);
        
        inventory.add(ironSword);
        
        inventory.use(inventory.getEquippedItem());
        inventory.use(inventory.getEquippedItem());
        inventory.use(inventory.getEquippedItem());
        inventory.use(inventory.getEquippedItem());
        inventory.use(inventory.getEquippedItem());
        
    }
    
}
