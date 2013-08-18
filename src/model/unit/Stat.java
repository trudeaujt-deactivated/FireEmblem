package model.unit;

public enum Stat {

    STR(0, 0),
    MAG(0, 0),
    SKILL(0, 0),
    SPD(0, 0),
    LUCK(0, 0),
    DEF(0, 0),
    RES(0,0),
    MOVE(0, 0),
    CON(0, 0),
    AID(0, 0);

    private int value;
    private int growthrate;

    private Stat(int p_value, int p_growthrate) {

        value = p_value;
        growthrate = p_growthrate;

    }

}
