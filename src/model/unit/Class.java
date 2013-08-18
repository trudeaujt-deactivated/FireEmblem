package model.unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum Class {

	/** Un-promoted classes */
	ARCHER,
	BARD,
	BRIGAND,
	CAVALIER,
	CLERIC,
	DANCER,
	DRAGONKNIGHT,
	FIGHTER,
	LORD,
	MAGE,
	MERCENARY,
	MONK,
	MYRMIDON,
	NOMAD,
	PEGASUSKNIGHT,
	PIRATE,
	SHAMAN,
	SOLDIER,
	THIEF,
	TROUBADOR,
	WYVERNRIDER,
	
	/** Promoted classes */
	ASSASSIN,
	BISHOP,
	DRUID,
	FALCOKNIGHT,
	GENERAL,
	PALADIN,
	SAGE,
	SWORDMASTER,
	VALKYRIE,
	WYVERNLORD;
	
	private DamageType damageType;
	private List<Statistics> maximumStats = new ArrayList<Statistics>();
	private HashMap<ItemType, Rank> usableWeapons;
	
}
