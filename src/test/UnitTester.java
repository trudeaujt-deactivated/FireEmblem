package test;

import java.util.ArrayList;

import model.unit.*;

public class UnitTester {

	public static void main(final String[] arguments) {
		
		Unit lyndis = buildUnit();
		
		System.out.println(lyndis.toString());
		
	}

	public static Unit buildUnit() {
		
		return new 
				Unit.Builder("Lyndis")
				.Affinity(Affinity.WIND)
				.Class(UnitClass.LORD)
				.Condition(null)
				.Health(new Health(16))
				.Inventory(new Inventory())
				.Level(new Level())
				.Rescue(null)
				.Stats(new Statistics())
				.build();
		
	}
	
}
