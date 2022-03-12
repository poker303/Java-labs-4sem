package ru.itmo.banks.transaction;

import ru.itmo.banks.account.Account;
import ru.itmo.banks.exception.BanksExceptions;

public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(int number, int amount, Account sender, Account account2) {
        super(number, amount, sender, account2);
    }

    public void cancellationOfTheTransaction() {
        if (getCancellation()) {
            throw new BanksExceptions("This operation's already been canceled.");
        }

        getWithdrawnAccount().replenishment(getAmount());
        changeCancellation();
    }
}
