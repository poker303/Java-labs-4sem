package ru.itmo.banks;

import ru.itmo.banks.account.Account;
import ru.itmo.banks.exception.BanksExceptions;
import ru.itmo.banks.transaction.Transaction;
import ru.itmo.banks.transaction.TransferBetweenAccounts;
import ru.itmo.banks.transmittedParameter.BankParameters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CentralBank {
    private final List<Bank> banks;
    private final String country;
    private final List<Transaction> transactions;
    private final String name;

    public CentralBank(String name, String country) {
        this.name = name;
        this.country = country;
        banks = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Bank> getBanks() {
        return Collections.unmodifiableList(banks);
    }

    public String getCountry() {
        return country;
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public Bank createBank(BankParameters parameters) {
        var bank = new Bank(parameters);
        banks.add(bank);
        return bank;
    }

    public void transfer(int transferAmount, Account sender, Account recipient, Bank bank, LocalDate operationDate) {
        if (transferAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        var newTransaction = new Transaction(transactions.size(), transferAmount, sender, recipient);
        bank.withdrawal(transferAmount, newTransaction.getWithdrawnAccount(), operationDate);
        bank.replenishment(transferAmount, newTransaction.getRecipientAccount(), operationDate);

        transactions.add(newTransaction);
    }

    public void transfer(int transferAmount, Account sender, Account recipient, Bank bank1, Bank bank2, LocalDate operationDate) {
        if (transferAmount < 0) {
            throw new BanksExceptions("The amount specified is incorrect, please change it.");
        }

        var newTransaction = new TransferBetweenAccounts(transactions.size(), transferAmount, sender, recipient);
        bank1.withdrawal(transferAmount, newTransaction.getWithdrawnAccount(), operationDate);
        bank2.replenishment(transferAmount, newTransaction.getRecipientAccount(), operationDate);
        transactions.add(newTransaction);
    }

    public void сancellationOfTheTransaction(int number) {

        for (Transaction transaction : transactions) {
            if (transaction.getNumber() == number) {
                transaction.cancellationOfTheTransaction();
            }
        }
    }

    public void notification(LocalDate operationDate) {
        for (Bank bank : banks) {
            List<Account> tempBankAccounts = new ArrayList<>(bank.getCreditAccounts());
            tempBankAccounts.addAll(bank.getDebitAccounts());
            tempBankAccounts.addAll(bank.getDepositAccounts());
            for (Account account : tempBankAccounts) {
                bank.accruals(account, operationDate);
            }
        }
    }
}
