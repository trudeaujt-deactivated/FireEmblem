package model.unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum UnitClass {

    /** Un-promoted classes */
    ARCHER(
            DamageType.PHYSICAL),
    BARD(
            DamageType.PHYSICAL),
    BRIGAND(
            DamageType.PHYSICAL),
    CAVALIER(
            DamageType.PHYSICAL),
    CLERIC(
            DamageType.MAGICAL),
    DANCER(
            DamageType.PHYSICAL),
    DRAGONKNIGHT(
            DamageType.PHYSICAL),
    FIGHTER(
            DamageType.PHYSICAL),
    LORD(
            DamageType.PHYSICAL),
    MAGE(
            DamageType.MAGICAL),
    MERCENARY(
            DamageType.PHYSICAL),
    MONK(
            DamageType.MAGICAL),
    MYRMIDON(
            DamageType.PHYSICAL),
    NOMAD(
            DamageType.PHYSICAL),
    PEGASUSKNIGHT(
            DamageType.PHYSICAL),
    PIRATE(
            DamageType.PHYSICAL),
    SHAMAN(
            DamageType.MAGICAL),
    SOLDIER(
            DamageType.PHYSICAL),
    THIEF(
            DamageType.PHYSICAL),
    TROUBADOR(
            DamageType.MAGICAL),
    WYVERNRIDER(
            DamageType.PHYSICAL),

    /** Promoted classes */
    ASSASSIN(
            DamageType.PHYSICAL),
    BISHOP(
            DamageType.MAGICAL),
    DRUID(
            DamageType.MAGICAL),
    FALCOKNIGHT(
            DamageType.PHYSICAL),
    GENERAL(
            DamageType.PHYSICAL),
    PALADIN(
            DamageType.PHYSICAL),
    SAGE(
            DamageType.MAGICAL),
    SWORDMASTER(
            DamageType.PHYSICAL),
    VALKYRIE(
            DamageType.MAGICAL),
    WYVERNLORD(
            DamageType.PHYSICAL);

    private DamageType damageType;
    private Statistics maximumStats;
    private HashMap<ItemType, Rank> usableWeapons;

    private UnitClass(DamageType p_damageType) {

    }

    private UnitClass(DamageType p_damageType, Statistics p_maximumStats,
            HashMap<ItemType, Rank> p_usableWeapons) {

        // TODO find max stats for each class

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
