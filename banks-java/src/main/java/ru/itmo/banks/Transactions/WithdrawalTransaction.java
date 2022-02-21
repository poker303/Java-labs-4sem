package ru.itmo.banks.Transactions;

import ru.itmo.banks.Accounts.Account;
import ru.itmo.banks.Exceptions.BanksExceptions;

public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(int number, int amount, Account sender, Account account2) {
        super(number, amount, sender, account2);
    }

    public void cancellationOfTheTransaction() throws BanksExceptions {
        if (getCancellation()) {
            throw new BanksExceptions("This operation's already been canceled.");
        }

        withdrawnAccount.replenishment(amount);
        changeCancellation();
    }
}
