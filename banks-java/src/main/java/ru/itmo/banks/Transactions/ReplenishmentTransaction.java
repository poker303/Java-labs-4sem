package ru.itmo.banks.Transactions;

import ru.itmo.banks.Accounts.Account;
import ru.itmo.banks.Exceptions.BanksExceptions;

public class ReplenishmentTransaction extends Transaction {
    public ReplenishmentTransaction(int number, int amount, Account sender, Account recipient) {
        super(number, amount, sender, recipient);
    }

    public void cancellationOfTheTransaction() throws BanksExceptions {
        if (getCancellation()) {
            throw new BanksExceptions("This operation's already been canceled.");
        }

        recipientAccount.withdrawal(amount);
        changeCancellation();
    }
}
