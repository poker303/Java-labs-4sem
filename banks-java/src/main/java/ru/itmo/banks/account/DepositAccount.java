package ru.itmo.banks.account;

import ru.itmo.banks.AmountPercentPair;
import ru.itmo.banks.exception.BanksExceptions;
import ru.itmo.banks.transmittedParameter.AccountParameters;

public class DepositAccount extends Account {
    public DepositAccount(AccountParameters parameters, AmountPercentPair table) {
        super(parameters);
        for (int i = 0; i < table.getPercents().size(); i++) {
            if (table.getAmounts().get(i) <= parameters.getAmount() && parameters.getAmount() < table.getAmounts().get(i + 1)) {
                setPercents(table.getPercents().get(i));
            }
        }
    }

    public double withdrawal(int withdrawalAmount) {
        if (withdrawalAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        if (getAmount() < withdrawalAmount) {
            throw new BanksExceptions("Operation is not possible, going over the limit.");
        }

        setPossibilityOfWithdrawal(true);

        setAmount(getAmount() - withdrawalAmount);
        return getAmount();
    }

    public double replenishment(int replenishmentAmount) {
        if (replenishmentAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        //amount += replenishmentAmount;
        setAmount(getAmount() + replenishmentAmount);
        return getAmount();
    }
}
