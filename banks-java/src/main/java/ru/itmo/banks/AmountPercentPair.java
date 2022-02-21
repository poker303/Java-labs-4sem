package ru.itmo.banks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AmountPercentPair {

    public List<Integer> getPercents() {
        return Collections.unmodifiableList(percents);
    }

    public List<Integer> getAmounts() {
        return Collections.unmodifiableList(amounts);
    }

    private final List<Integer> percents;
    private final List<Integer> amounts;

    public AmountPercentPair(ArrayList<Integer> boundarySums, ArrayList<Integer> percents) {
        this.percents = percents;
        this.amounts = boundarySums;
    }
}
