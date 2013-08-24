package model.unit;

import java.util.ArrayList;

/**
 * Defines an object for containing and manipulating items.
 *
 * @author Jonathan Trudeau
 *
 */
public class Inventory implements Observer {

    /** the default inventory size */
    private static final int DEFAULT_SIZE = 5;

    private int size;
    private ArrayList<Item> items;

    /**
     * Constructs an Inventory object with the default defined for inventory size.
     */
    public Inventory() {

        size = DEFAULT_SIZE;
        items = new ArrayList<Item>(size);

    }

    /**
     * Adds an item to the list of items.
     * 
     * @param item - the item to be added
     */
    public void add(Item item) {

        if (!checkInventoryFull())
            items.add(item);

    }

    /**
     * Removes an item by reference.
     * 
     * @param item - the item to be removed
     */
    public void remove(Item item) {

        items.remove(item);

    }

    /**
     * Uses an item, performing actions defined in the item.
     * 
     * @param item - the item to be used
     */
    public void use(Item item) {
        
        if(item != null)
            item.use();

    }
    
    /**
     * Checks if the inventory is full.
     * 
     * @return true if full, false if empty
     */
    private boolean checkInventoryFull() {
        
        if (items.size() < size)
            return false;

        return true;

    }
    
    /**
     * Gets the equipped Item as a mutable object.
     * 
     * @return the item 
     */
    public Item getEquippedItem() {
        
        if(!items.isEmpty())
            return items.get(0);
        
        return null;
        
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
