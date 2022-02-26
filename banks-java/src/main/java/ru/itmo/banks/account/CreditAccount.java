package ru.itmo.banks.account;

import ru.itmo.banks.exception.BanksExceptions;
import ru.itmo.banks.transmittedParameter.AccountParameters;

public class CreditAccount extends Account {
    private int limit;

    public CreditAccount(AccountParameters parameters, int limit, int percent) {
        super(parameters);
        setPercents(percent);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double withdrawal(int withdrawalAmount) {
        if (withdrawalAmount < 0) {
            throw new BanksExceptions("Insufficient funds for debiting.");
        }

        if (getAmount() - withdrawalAmount < -limit) {
            throw new BanksExceptions("Operation is not possible, going over the limit.");
        }

        setAmount(getAmount() - withdrawalAmount);
        return getAmount();
    }

    public double replenishment(int replenishmentAmount) {
        if (replenishmentAmount < 0) {
            throw new BanksExceptions("Wrong amount, please enter a different one.");
        }

        setAmount(getAmount() + replenishmentAmount);
        return getAmount();
    }
}
