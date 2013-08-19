package model.unit;

public enum Rank {

    E(0),
    D(1),
    C(2),
    B(3),
    A(4),
    S(5);

    private int rank;

    Rank(int p_rank) {

        rank = p_rank;

    }
    
    public int getRank() {
        
        return rank;
        
    }

}
