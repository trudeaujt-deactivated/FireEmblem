package model.unit;

import java.util.HashMap;

public enum UnitClass {

    /** Un-promoted classes */
    ARCHER(DamageType.PHYSICAL),
    BANDIT(DamageType.PHYSICAL),
    BARD(DamageType.PHYSICAL),
    CAVALIER(DamageType.PHYSICAL),
    CLERIC(DamageType.MAGICAL),
    DANCER(DamageType.PHYSICAL),
    FIGHTER(DamageType.PHYSICAL),
    LORD_ELIWOOD(DamageType.PHYSICAL),
    LORD_HECTOR(DamageType.PHYSICAL),
    LORD_LYNDIS(DamageType.PHYSICAL),
    MAGE(DamageType.MAGICAL),
    MERCENARY(DamageType.PHYSICAL),
    MONK(DamageType.MAGICAL),
    MYRMIDON(DamageType.PHYSICAL),
    NOMAD(DamageType.PHYSICAL),
    PEGASUSKNIGHT(DamageType.PHYSICAL),
    PIRATE(DamageType.PHYSICAL),
    SHAMAN(DamageType.MAGICAL),
    SOLDIER(DamageType.PHYSICAL),
    THIEF(DamageType.PHYSICAL),
    TROUBADOUR(DamageType.MAGICAL),
    WYVERNRIDER(DamageType.PHYSICAL),

    /** Promoted classes */
    ARCHSAGE(DamageType.MAGICAL),
    ASSASSIN(DamageType.PHYSICAL),
    BERSERKER(DamageType.PHYSICAL),
    BISHOP(DamageType.MAGICAL),
    BLADELORD(DamageType.PHYSICAL),
    CORSAIR(DamageType.PHYSICAL),
    DRUID(DamageType.MAGICAL),
    FALCONKNIGHT(DamageType.PHYSICAL),
    GENERAL(DamageType.PHYSICAL),
    GREATLORD(DamageType.PHYSICAL),
    HERO(DamageType.PHYSICAL),
    KNIGHTLORD(DamageType.PHYSICAL),
    NOMADTROOPER(DamageType.PHYSICAL),
    PALADIN(DamageType.PHYSICAL),
    SAGE(DamageType.MAGICAL),
    SNIPER(DamageType.PHYSICAL),
    SWORDMASTER(DamageType.PHYSICAL),
    VALKYRIE(DamageType.MAGICAL),
    WARRIOR(DamageType.PHYSICAL),
    WYVERNLORD(DamageType.PHYSICAL);

    private DamageType damageType;
    private Statistics maximumStats;
    private HashMap<ItemType, Rank> usableWeapons;

    private UnitClass(DamageType p_damageType) {

        this.damageType = p_damageType;
        
    }
    
    private UnitClass(DamageType p_damageType, Statistics p_maximumStats) {

        this.damageType = p_damageType;
        this.maximumStats.equals(p_maximumStats);
        
    }

    private UnitClass(DamageType p_damageType, Statistics p_maximumStats,
            HashMap<ItemType, Rank> p_usableWeapons) {

        this.damageType = p_damageType;
        this.maximumStats.equals(p_maximumStats);
        this.usableWeapons = p_usableWeapons;

    }

    public DamageType getDamageType() {

        return damageType;

    }

    public Statistics getMaximumStats() {

        return maximumStats;

    }

    public HashMap<ItemType, Rank> getUsableWeapons() {

        return usableWeapons;

    }

}
