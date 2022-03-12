package ru.itmo.banks.account;

import ru.itmo.banks.exception.BanksExceptions;
import ru.itmo.banks.transmittedparameter.AccountParameters;

public class DebitAccount extends Account {
    public DebitAccount(AccountParameters parameters, int percent) {
        super(parameters);
        setPercents(percent);
    }

    public double withdrawal(int withdrawalAmount) {
        if (withdrawalAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        if (getAmount() < withdrawalAmount) {
            throw new BanksExceptions("Operation is not possible, going over the limit.");
        }

        setAmount(getAmount() - withdrawalAmount);
        return getAmount();
    }

    public double replenishment(int replenishmentAmount) {
        if (replenishmentAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        setAmount(getAmount() + replenishmentAmount);
        return getAmount();
    }
}
