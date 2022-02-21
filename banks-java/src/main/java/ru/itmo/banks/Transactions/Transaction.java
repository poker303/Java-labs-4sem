package ru.itmo.banks.Transactions;

import ru.itmo.banks.Accounts.Account;
import ru.itmo.banks.Exceptions.BanksExceptions;

public class Transaction {

    private boolean wasCanceled;

    public Transaction(int number, int amount, Account sender, Account recipient) {
        this.number = number;
        this.amount = amount;
        withdrawnAccount = sender;
        recipientAccount = recipient;
        wasCanceled = false;
    }

    protected int number;
    protected int amount;
    protected Account withdrawnAccount;
    protected Account recipientAccount;

    public int getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    public Account getWithdrawnAccount() {
        return withdrawnAccount;
    }

    public Account getRecipientAccount() {
        return recipientAccount;
    }

    public void cancellationOfTheTransaction() throws BanksExceptions {
    }

    public void changeCancellation() {
        wasCanceled = true;
    }

    public boolean getCancellation() {
        return wasCanceled;
    }
}
