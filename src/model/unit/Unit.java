package model.unit;

import java.util.ArrayList;
import java.util.List;

public class Unit {

	private String name;
	private Affinity affinityType;
	private UnitClass classType;
	private Condition condition;
	private Health health;
	private Inventory inventory;
	private Level level;
	private Unit rescue;
	private List<Statistics> stats = new ArrayList<Statistics>();
	
	public Unit(Builder builder) {
		
		this.name 			= builder.name;
		this.affinityType 	= builder.affinityType;
		this.classType 		= builder.classType;
		this.condition 		= builder.condition;
		this.health 		= builder.health;
		this.inventory 		= builder.inventory;
		this.level 			= builder.level;
		this.rescue 		= builder.rescue;
		this.stats 			= builder.stats;
		
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
		private List<Statistics> stats = new ArrayList<Statistics>();
		
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
		
		public Builder Stats(ArrayList<Statistics> p_statistics) {
			
			this.stats = p_statistics;
			return this;
			
		}
		
		public Unit build() {
			
			return new Unit(this);
			
		}
		
	}
	
	@Override
	public String toString() {
		
		return "Unit [name=" + name + ", affinityType=" + affinityType
				+ ", classType=" + classType + ", condition=" + condition
				+ ", health=" + health + ", inventory=" + inventory
				+ ", level=" + level + ", rescue=" + rescue + ", stats="
				+ stats + "]";
	}

	public void levelUp() {
		
		
		
	}
	
}
