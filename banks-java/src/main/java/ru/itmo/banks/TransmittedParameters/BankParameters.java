package ru.itmo.banks.TransmittedParameters;

import ru.itmo.banks.AmountPercentPair;

public class BankParameters {
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

    protected String name;
    protected AmountPercentPair table;
    protected int reliabilityAmount;
    protected int debitPercent;
    protected int debitCommission;
    protected int creditPercent;
    protected int creditCommission;
    protected int depositCommission;
    protected int creditLimit;

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
