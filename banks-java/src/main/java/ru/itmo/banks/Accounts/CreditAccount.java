package ru.itmo.banks.Accounts;

import ru.itmo.banks.Exceptions.BanksExceptions;
import ru.itmo.banks.TransmittedParameters.AccountParameters;

public class CreditAccount extends Account {
    public CreditAccount(AccountParameters parameters, int limit, int percent) throws BanksExceptions {
        super(parameters);
        setPercents(percent);
        this.limit = limit;
    }

    protected int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double withdrawal(int withdrawalAmount) throws BanksExceptions {
        if (withdrawalAmount < 0) {
            throw new BanksExceptions("Insufficient funds for debiting.");
        }

        if (amount - withdrawalAmount < -limit) {
            throw new BanksExceptions("Operation is not possible, going over the limit.");
        }

        amount -= withdrawalAmount;
        return amount;
    }

    public double replenishment(int replenishmentAmount) throws BanksExceptions {
        if (replenishmentAmount < 0) {
            throw new BanksExceptions("Wrong amount, please enter a different one.");
        }

        amount += replenishmentAmount;
        return amount;
    }
}
