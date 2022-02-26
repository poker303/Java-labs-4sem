package ru.itmo.banks.transmittedParameter;

import ru.itmo.banks.AmountPercentPair;

public class BankParameters {
    private final String name;
    private final AmountPercentPair table;
    private final int reliabilityAmount;
    private final int debitPercent;
    private final int debitCommission;
    private final int creditPercent;
    private final int creditCommission;
    private final int depositCommission;
    private final int creditLimit;

    public BankParameters(String name, AmountPercentPair table, int reliabilityAmount, int debitPercent, int debitCommission, int creditPercent, int creditCommission, int depositCommission, int creditLimit) {
        this.name = name;
        this.table = table;
        this.reliabilityAmount = reliabilityAmount;
        this.debitPercent = debitPercent;
        this.debitCommission = debitCommission;
        this.creditPercent = creditPercent;
        this.creditCommission = creditCommission;
        this.depositCommission = depositCommission;
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public AmountPercentPair getTable() {
        return table;
    }

    public int getReliabilityAmount() {
        return reliabilityAmount;
    }

    public int getDebitPercent() {
        return debitPercent;
    }

    public int getDebitCommission() {
        return debitCommission;
    }

    public int getCreditPercent() {
        return creditPercent;
    }

    public int getCreditCommission() {
        return creditCommission;
    }

    public int getDepositCommission() {
        return depositCommission;
    }

    public int getCreditLimit() {
        return creditLimit;
    }
}
