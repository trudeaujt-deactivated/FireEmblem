package model.unit;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    List<Stat> statistics = new ArrayList<Stat>();

    public Statistics() {

        for (Stat s : Stat.values())
            statistics.add(s);

    }

    @Override
    public String toString() {
        return "Statistics [statistics=" + statistics + "]";
    }

}
