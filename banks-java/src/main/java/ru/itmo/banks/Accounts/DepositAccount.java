package ru.itmo.banks.Accounts;

import ru.itmo.banks.AmountPercentPair;
import ru.itmo.banks.Exceptions.BanksExceptions;
import ru.itmo.banks.TransmittedParameters.AccountParameters;

public class DepositAccount extends Account {
    public DepositAccount(AccountParameters parameters, AmountPercentPair table) throws BanksExceptions {
        super(parameters);
        for (int i = 0; i < table.getPercents().size(); i++) {
            if (table.getAmounts().get(i) <= parameters.getAmount() && parameters.getAmount() < table.getAmounts().get(i + 1)) {
                setPercents(table.getPercents().get(i));
            }
        }
    }

    public double withdrawal(int withdrawalAmount) throws BanksExceptions {
        if (withdrawalAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        if (amount < withdrawalAmount) {
            throw new BanksExceptions("Operation is not possible, going over the limit.");
        }

        possibilityOfWithdrawal = true;
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
