package ru.itmo.banks.Accounts;

import ru.itmo.banks.Exceptions.BanksExceptions;
import ru.itmo.banks.TransmittedParameters.AccountParameters;

public class DebitAccount extends Account {
    public DebitAccount(AccountParameters parameters, int percent) throws BanksExceptions {
        super(parameters);
        setPercents(percent);
    }

    public double withdrawal(int withdrawalAmount) throws BanksExceptions {
        if (withdrawalAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        if (amount < withdrawalAmount) {
            throw new BanksExceptions("Operation is not possible, going over the limit.");
        }

        amount -= withdrawalAmount;
        return amount;
    }

    public double replenishment(int replenishmentAmount) throws BanksExceptions {
        if (replenishmentAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        amount += replenishmentAmount;
        return amount;
    }
}
