package model.unit;

import java.util.HashMap;

public enum UnitClass {

    /** Un-promoted classes */
    ARCHER(DamageType.PHYSICAL, UnitType.INFANTRY),
    BANDIT(DamageType.PHYSICAL, UnitType.INFANTRY),
    BARD(DamageType.PHYSICAL, UnitType.INFANTRY),
    CAVALIER(DamageType.PHYSICAL, UnitType.MOUNTED),
    CLERIC(DamageType.MAGICAL, UnitType.INFANTRY),
    DANCER(DamageType.PHYSICAL, UnitType.INFANTRY),
    FIGHTER(DamageType.PHYSICAL, UnitType.INFANTRY),
    KNIGHT(DamageType.PHYSICAL, UnitType.ARMORED),
    LORD_ELIWOOD(DamageType.PHYSICAL, UnitType.INFANTRY),
    LORD_HECTOR(DamageType.PHYSICAL, UnitType.INFANTRY),
    LORD_LYNDIS(DamageType.PHYSICAL, UnitType.INFANTRY),
    MAGE(DamageType.MAGICAL, UnitType.INFANTRY),
    MERCENARY(DamageType.PHYSICAL, UnitType.INFANTRY),
    MONK(DamageType.MAGICAL, UnitType.INFANTRY),
    MYRMIDON(DamageType.PHYSICAL, UnitType.INFANTRY),
    NOMAD(DamageType.PHYSICAL, UnitType.MOUNTED),
    PEGASUSKNIGHT(DamageType.PHYSICAL, UnitType.FLYING),
    PIRATE(DamageType.PHYSICAL, UnitType.INFANTRY),
    SHAMAN(DamageType.MAGICAL, UnitType.INFANTRY),
    SOLDIER(DamageType.PHYSICAL, UnitType.INFANTRY),
    THIEF(DamageType.PHYSICAL, UnitType.INFANTRY),
    TROUBADOUR(DamageType.MAGICAL, UnitType.MOUNTED),
    WYVERNRIDER(DamageType.PHYSICAL, UnitType.FLYING),

    /** Promoted classes */
    ARCHSAGE(DamageType.MAGICAL, UnitType.INFANTRY),
    ASSASSIN(DamageType.PHYSICAL, UnitType.INFANTRY),
    BERSERKER(DamageType.PHYSICAL, UnitType.INFANTRY),
    BISHOP(DamageType.MAGICAL, UnitType.INFANTRY),
    BLADELORD(DamageType.PHYSICAL, UnitType.INFANTRY),
    CORSAIR(DamageType.PHYSICAL, UnitType.INFANTRY),
    DRUID(DamageType.MAGICAL, UnitType.INFANTRY),
    FALCONKNIGHT(DamageType.PHYSICAL, UnitType.FLYING),
    GENERAL(DamageType.PHYSICAL, UnitType.ARMORED),
    GREATLORD(DamageType.PHYSICAL, UnitType.INFANTRY),
    HERO(DamageType.PHYSICAL, UnitType.INFANTRY),
    KNIGHTLORD(DamageType.PHYSICAL, UnitType.MOUNTED),
    NOMADTROOPER(DamageType.PHYSICAL, UnitType.MOUNTED),
    PALADIN(DamageType.PHYSICAL, UnitType.MOUNTED),
    SAGE(DamageType.MAGICAL, UnitType.INFANTRY),
    SNIPER(DamageType.PHYSICAL, UnitType.INFANTRY),
    SWORDMASTER(DamageType.PHYSICAL, UnitType.INFANTRY),
    VALKYRIE(DamageType.MAGICAL, UnitType.MOUNTED),
    WARRIOR(DamageType.PHYSICAL, UnitType.INFANTRY),
    WYVERNLORD(DamageType.PHYSICAL, UnitType.FLYING);

    private DamageType damageType;
    private UnitType unitType;
    private Statistics maximumStats;
    private HashMap<ItemType, Rank> usableWeapons;

    private UnitClass(DamageType p_damageType, UnitType p_unitType) {

        this.damageType = p_damageType;
        this.unitType = p_unitType;
        
    }

    public DamageType getDamageType() {

        return damageType;

    }
    
    public UnitType getUnitType() {
        
        return unitType;
        
    }

    public Statistics getMaximumStats() {

        return maximumStats;

    }

    public HashMap<ItemType, Rank> getUsableWeapons() {

        return usableWeapons;

    }

}
