package ru.itmo.banks;

import java.util.Collections;
import java.util.List;

public class AmountPercentPair {

    private final List<Integer> percents;
    private final List<Integer> amounts;

    public AmountPercentPair(List<Integer> boundarySums, List<Integer> percents) {
        this.percents = percents;
        this.amounts = boundarySums;
    }

    public List<Integer> getPercents() {
        return Collections.unmodifiableList(percents);
    }

    public List<Integer> getAmounts() {
        return Collections.unmodifiableList(amounts);
    }
}
