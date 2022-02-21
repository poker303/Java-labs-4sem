package ru.itmo.banks;

import ru.itmo.banks.Accounts.Account;
import ru.itmo.banks.Accounts.CreditAccount;
import ru.itmo.banks.Accounts.DebitAccount;
import ru.itmo.banks.Accounts.DepositAccount;
import ru.itmo.banks.Exceptions.BanksExceptions;
import ru.itmo.banks.Transactions.ReplenishmentTransaction;
import ru.itmo.banks.Transactions.Transaction;
import ru.itmo.banks.Transactions.WithdrawalTransaction;
import ru.itmo.banks.TransmittedParameters.AccountParameters;
import ru.itmo.banks.TransmittedParameters.BankParameters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Bank {

    private final List<Client> observers;
    private int accountNumbers = 1;

    public Bank(BankParameters parameters) {
        observers = new ArrayList<>();
        name = parameters.getName();
        reliabilityAmount = parameters.getReliabilityAmount();

        table = parameters.getTable();
        depositCommission = parameters.getDepositCommission();

        debitPercent = parameters.getDebitPercent();
        debitCommission = parameters.getDebitCommission();

        creditPercent = parameters.getCreditPercent();
        creditCommission = parameters.getCreditCommission();
        creditLimit = parameters.getCreditLimit();

        clients = new ArrayList<>();
        creditAccounts = new ArrayList<>();
        depositAccounts = new ArrayList<>();
        debitAccounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    private final List<Client> clients;
    private final List<Account> creditAccounts;
    private final List<Account> depositAccounts;
    private final List<Account> debitAccounts;
    private final List<Transaction> transactions;
    private final String name;
    private final AmountPercentPair table;
    private int reliabilityAmount;
    private final int debitPercent;
    private final int debitCommission;
    private final int creditPercent;
    private final int creditCommission;
    private final int depositCommission;
    private final int creditLimit;

    public int getReliabilityAmount() {
        return reliabilityAmount;
    }

    public void setReliabilityAmount(int reliabilityAmount) {
        this.reliabilityAmount = reliabilityAmount;
    }

    public String getName() {
        return name;
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public List<Account> getCreditAccounts() {
        return Collections.unmodifiableList(creditAccounts);
    }

    public List<Account> getDepositAccounts() {
        return Collections.unmodifiableList(depositAccounts);
    }

    public List<Account> getDebitAccounts() {
        return Collections.unmodifiableList(debitAccounts);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public AmountPercentPair getTable() {
        return table;
    }

    public int getDebitPercent() {
        return debitPercent;
    }

    public int getDebitCommission() {
        return debitCommission;
    }

    public int getCreditPercent() {
        return creditPercent;
    }

    public int getCreditCommission() {
        return creditCommission;
    }

    public int getDepositCommission() {
        return depositCommission;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void addClients(ArrayList<Client> clients) {
        for (Client client : clients) {
            if (!this.clients.contains(client)) {
                this.clients.add(client);
            }
        }
    }

    public DebitAccount createDebitAccount(Client client, int initialAmount, LocalDate creationTime, int duration) throws BanksExceptions {
        boolean reliability = checkingAccount(client, initialAmount);

        var parameters = new AccountParameters(accountNumbers, initialAmount, debitCommission, true, creationTime, duration, reliability, reliabilityAmount);
        var newDebitAccount = new DebitAccount(parameters, debitPercent);

        debitAccounts.add(newDebitAccount);
        client.addDebitAccount(newDebitAccount);
        accountNumbers++;
        return newDebitAccount;
    }

    public CreditAccount createCreditAccount(Client client, int initialAmount, LocalDate creationTime, int duration) throws BanksExceptions {
        boolean reliability = checkingAccount(client, initialAmount);

        var parameters = new AccountParameters(accountNumbers, initialAmount, creditCommission, true, creationTime, duration, reliability, reliabilityAmount);
        var newCreditAccount = new CreditAccount(parameters, creditLimit, creditPercent);
        creditAccounts.add(newCreditAccount);
        client.addCreditAccount(newCreditAccount);
        accountNumbers++;
        return newCreditAccount;
    }

    public DepositAccount createDepositAccount(Client client, int initialAmount, LocalDate creationTime, int duration) throws BanksExceptions {
        boolean reliability = checkingAccount(client, initialAmount);

        var parameters = new AccountParameters(accountNumbers, initialAmount, debitCommission, false, creationTime, duration, reliability, reliabilityAmount);
        var newDepositAccount = new DepositAccount(parameters, table);
        depositAccounts.add(newDepositAccount);
        client.addDepositAccount(newDepositAccount);
        accountNumbers++;
        return newDepositAccount;
    }

    public void withdrawal(int withdrawalAmount, Account account, LocalDate operationDate) throws BanksExceptions {
        if (!account.isReliability()) {
            if (withdrawalAmount > account.getReliabilityAmount()) {
                throw new BanksExceptions("To perform the operation, enter your passport number.");
            }
        }

        if (account.equals(DepositAccount.class)) {
            if (account.getCloseDate().isAfter(operationDate)) {
                throw new BanksExceptions("The operation is impossible.");
            }
        }

        account.withdrawal(withdrawalAmount);
        var newTransaction = new WithdrawalTransaction(transactions.size(), withdrawalAmount, account, account);
        transactions.add(newTransaction);
    }

    public void replenishment(int replenishmentAmount, Account account, LocalDate operationDate) throws BanksExceptions {
        account.replenishment(replenishmentAmount);
        var newTransaction = new ReplenishmentTransaction(transactions.size(), replenishmentAmount, account, account);
        transactions.add(newTransaction);
    }

    public void cancellationOfTheTransaction(int number) throws BanksExceptions {
        for (Transaction transaction : transactions) {
            if (transaction.getNumber() == number) {
                transaction.cancellationOfTheTransaction();
            }
        }
    }

    public void accruals(Account account, LocalDate date) {

        double tempPercent = account.getPercent() / 36500d;

        LocalDate tempDate = account.getOpeningDate();
        while (!date.equals(tempDate)) {
            account.setAmount(account.getAmount() + account.getAmount() * tempPercent);
            if (account.getAmount() < 0) {
                account.setAmount(account.getAmount() - account.getCommission());
            }
            tempDate = tempDate.plusDays(1);
        }
    }

    public void clientAccountsUpdate(Client client, LocalDate operationDate) {
        if (client.passportNumber != null && client.address != null) {
            List<Account> tempAccounts = new ArrayList<>(client.getCreditAccounts());
            tempAccounts.addAll(client.getDebitAccounts());
            tempAccounts.addAll(client.getDepositAccounts());
            for (Account account : tempAccounts) {
                account.setReliability(true);
            }
        }

        for (Account account : client.getDepositAccounts()) {
            if (operationDate.isAfter(account.getCloseDate())) {
                account.setPossibilityOfWithdrawal(true);
            }
        }
    }

    public void attachObserver(Client client) throws BanksExceptions {
        if (!client.getSubscriptionDesire()) throw new BanksExceptions("No subscription permission.");
        if (!observers.contains(client)) {
            observers.add(client);
        }
    }

    public void detachObserver(Client client) {
        observers.remove(client);
    }

    public void notifyObservers(Account account) {
        for (Client observer : observers) {
            List<Account> tempAccounts = new ArrayList<>(observer.getCreditAccounts());
            tempAccounts.addAll(observer.getDebitAccounts());
            tempAccounts.addAll(observer.getDepositAccounts());
            if (tempAccounts.contains(account)) {
                observer.update(account);
            }
        }
    }

    public void changeDebitAccountOptions(Account account, int newDebitPercent, int newDebitCommission) {
        account.setCommission(newDebitCommission);
        account.setPercent(newDebitPercent);
        notifyObservers(account);
    }

    public void changeDepositAccountOptions(DepositAccount account, int newDepositCommission) {
        account.setCommission(newDepositCommission);
        notifyObservers(account);
    }

    public void changeCreditAccountOptions(CreditAccount account, int newCreditPercent, int newCreditCommission, int newCreditLimit) {
        account.setCommission(newCreditCommission);
        account.setPercent(newCreditPercent);
        account.setLimit(newCreditLimit);
        notifyObservers(account);
    }

    public void changeReliabilityAmount(int newReliabilityAmount) {
        reliabilityAmount = newReliabilityAmount;
    }

    public boolean checkingAccount(Client client, int initialAmount) throws BanksExceptions {
        if (initialAmount > client.money) {
            throw new BanksExceptions("You don't have that much money");
        }

        client.money -= initialAmount;

        return client.passportNumber != null && client.address != null;
    }
}
