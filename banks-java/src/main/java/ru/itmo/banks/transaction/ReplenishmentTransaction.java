package ru.itmo.banks.transaction;

import ru.itmo.banks.account.Account;
import ru.itmo.banks.exception.BanksExceptions;

public class ReplenishmentTransaction extends Transaction {
    public ReplenishmentTransaction(int number, int amount, Account sender, Account recipient) {
        super(number, amount, sender, recipient);
    }

    public void cancellationOfTheTransaction() {
        if (getCancellation()) {
            throw new BanksExceptions("This operation's already been canceled.");
        }

        getRecipientAccount().withdrawal(getAmount());
        changeCancellation();
    }
}
