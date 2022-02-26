package ru.itmo.banks.transaction;

import ru.itmo.banks.account.Account;

public class Transaction {

    private final int number;
    private final int amount;
    private final Account withdrawnAccount;
    private final Account recipientAccount;
    private boolean wasCanceled;

    public Transaction(int number, int amount, Account sender, Account recipient) {
        this.number = number;
        this.amount = amount;
        withdrawnAccount = sender;
        recipientAccount = recipient;
        wasCanceled = false;
    }

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

    public void cancellationOfTheTransaction() {
    }

    public void changeCancellation() {
        wasCanceled = true;
    }

    public boolean getCancellation() {
        return wasCanceled;
    }
}
