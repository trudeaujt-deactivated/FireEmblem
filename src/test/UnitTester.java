package test;

import java.util.ArrayList;
import java.util.List;

import model.unit.Affinity;
import model.unit.CombatStats;
import model.unit.DamageType;
import model.unit.Health;
import model.unit.Inventory;
import model.unit.ItemType;
import model.unit.Level;
import model.unit.Rank;
import model.unit.Stat;
import model.unit.Statistics;
import model.unit.Unit;
import model.unit.UnitClass;
import model.unit.UnitType;
import model.unit.Weapon;

public class UnitTester {

    public static void main(final String[] arguments) {

        Unit lyndis = buildUnit();

        System.out.println(lyndis.toString());
        
        CombatStats cs = lyndis.getCombatStats();
        System.out.println(cs.toString());
        
        lyndis.incrementExperience(60);
        lyndis.incrementExperience(60);
        lyndis.incrementExperience(81);
        
        for (int i = 0; i < 20; i++) {
            
            lyndis.incrementExperience(100);
            
        }
        
        cs = lyndis.getCombatStats();
        System.out.println(cs.toString());
        
        //lyndis.incrementExperience(-1);
        //lyndis.incrementExperience(101);
        
//        System.out.println(lyndis.toString());

    }

    public static Unit buildUnit() {

        Inventory inventory = new Inventory();
        
        List<UnitType> bonus = new ArrayList<UnitType>();
        bonus.add(UnitType.INFANTRY);
        
        inventory.add(new 
                Weapon.Builder("Iron Sword")
                .ItemType(ItemType.SWORD)
                .Bonus(bonus)
                .Durability(45)
                .Range(1)
                .Weight(5)
                .Might(5)
                .Hit(90)
                .Crit(0)
                .Rank(Rank.E)
                .Build());
        
        Statistics statistics = new 
                Statistics.Builder(DamageType.PHYSICAL)
                .Hp(18, 70)
                .Power(5, 40)
                .Skill(9, 60)
                .Spd(12, 60)
                .Luck(8, 55)
                .Def(3, 20)
                .Res(2, 30)
                .Move(5)
                .Con(5)
                .Aid(4)
                .Build();
                
        Unit lyndis = new
                Unit.Builder("Lyndis")
                .Affinity(Affinity.WIND)
                .Class(UnitClass.LORD_LYNDIS)
                .Condition(null)
                .Health(new Health(statistics.getValue("HP")))
                .Inventory(inventory)
                .Level(new Level())
                .Rescue(null)
                .Stats(statistics)
                .Build();
                
        return lyndis;

    }

}
