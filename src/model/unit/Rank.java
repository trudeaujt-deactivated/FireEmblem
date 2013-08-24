package model.unit;

/**
 * Defines possible weapon and support ranks.
 *
 * @author Jonathan Trudeau
 *
 */
public enum Rank {

    E(0),
    D(1),
    C(2),
    B(3),
    A(4),
    S(5);

    private int rank;

    /**
     * Constructs a rank as defined.
     * 
     * @param p_rank - the rank value
     */
    Rank(int p_rank) {

        rank = p_rank;

    }
    
    /**
     * Gets the rank as a primitive type.
     * 
     * @return the rank
     */
    public int getRank() {
        
        return rank;
        
    }

}
