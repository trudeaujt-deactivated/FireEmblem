package model;

import java.util.ArrayList;

public class Inventory {

	/** the default inventory size */
	private static final int DEFAULT_SIZE = 5;
	
	private int size;
	private ArrayList<Item> items;
	
	public Inventory() {
		
		size = DEFAULT_SIZE;
		
	}
	
	public void add(Item item) {
		
		if(checkInventoryFull())
			items.add(item);
		
	}
	
	public void remove(Item item) {
		
		items.remove(item);
		
	}
	
	public void use(Item item) {
		
		item.use();
		remove(item);
		
	}
	
	private boolean checkInventoryFull() {
		
		if(items.size() < size)
			return false;
		
		return true;
		
	}
	
}
