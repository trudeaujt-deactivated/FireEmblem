package model.unit;

import java.util.ArrayList;

public class Inventory implements Observer {

    /** the default inventory size */
    private static final int DEFAULT_SIZE = 5;

    private int size;
    private ArrayList<Item> items;

    public Inventory() {

        size = DEFAULT_SIZE;
        items = new ArrayList<Item>(size);

    }

    public void add(Item item) {

        if (!checkInventoryFull())
            items.add(item);

    }

    public void remove(Item item) {

        items.remove(item);

    }

    public void use(Item item) {
        
        if(item != null)
            item.use();

    }
    
    public Item getEquippedItem() {
        
        if(!items.isEmpty())
            return items.get(0);
        
        return null;
        
    }

    private boolean checkInventoryFull() {
        
        if (items.size() < size)
            return false;

        return true;

    }

    @Override
    public String toString() {
        return "Inventory [size=" + size + ", items=" + items + "]";
    }

    @Override
    public void update(Observable observable) {
        
        System.out.println("Item " + (Item) observable + " has broken.");
        remove((Item) observable);
        
    }

}
