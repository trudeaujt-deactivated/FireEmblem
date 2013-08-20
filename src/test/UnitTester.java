package test;

import model.unit.Affinity;
import model.unit.DamageType;
import model.unit.Health;
import model.unit.Inventory;
import model.unit.ItemType;
import model.unit.Level;
import model.unit.Rank;
import model.unit.Statistics;
import model.unit.Unit;
import model.unit.UnitClass;
import model.unit.Weapon;

public class UnitTester {

    public static void main(final String[] arguments) {

        Unit lyndis = buildUnit();

        System.out.println(lyndis.toString());
        
        lyndis.incrementExperience(60);
        lyndis.incrementExperience(60);
        lyndis.incrementExperience(80);
        lyndis.incrementExperience(100);
        //lyndis.incrementExperience(-1);
        //lyndis.incrementExperience(101);

    }

    public static Unit buildUnit() {

        Inventory inventory = new Inventory();
        inventory.add(new 
                Weapon.Builder("Mani Katti")
                .ItemType(ItemType.SWORD)
                .Durability(45)
                .Range(1)
                .Weight(3)
                .Might(8)
                .Hit(80)
                .Crit(20)
                .Rank(Rank.E)
                .Build());
        
        Statistics statistics = new 
                Statistics.Builder(DamageType.PHYSICAL)
                .Power(4, 40)
                .Skill(7, 60)
                .Spd(9, 60)
                .Luck(5, 55)
                .Def(2, 20)
                .Res(0, 30)
                .Move(5)
                .Con(5)
                .Aid(4)
                .Build();
        
        Unit lyndis = new
                Unit.Builder("Lyndis")
                .Affinity(Affinity.WIND)
                .Class(UnitClass.LORD)
                .Condition(null)
                .Health(new Health(16))
                .Inventory(inventory)
                .Level(new Level())
                .Rescue(null)
                .Stats(statistics)
                .Build();
        
        // TODO find a better way to do this
        lyndis.getLevel().registerObserver(lyndis);
        
        return lyndis;

    }

}
