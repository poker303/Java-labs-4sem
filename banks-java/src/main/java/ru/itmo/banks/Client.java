package ru.itmo.banks;

import ru.itmo.banks.account.Account;
import ru.itmo.banks.account.CreditAccount;
import ru.itmo.banks.account.DebitAccount;
import ru.itmo.banks.account.DepositAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    private final List<String> notifications;
    private final List<Account> creditAccounts;
    private final List<Account> depositAccounts;
    private final List<Account> debitAccounts;
    private final String name;
    private final String surname;
    private String address;
    private String passportNumber;
    private int money;
    private boolean subscriptionDesire;

    public Client(String name, String surname, int money) {
        this.name = name;
        this.surname = surname;
        this.money = money;
        notifications = new ArrayList<>();
        address = null;
        passportNumber = null;
        subscriptionDesire = false;
        creditAccounts = new ArrayList<>();
        depositAccounts = new ArrayList<>();
        debitAccounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Account> getCreditAccounts() {
        return Collections.unmodifiableList(creditAccounts);
    }

    public void addCreditAccount(CreditAccount creditAccount) {
        creditAccounts.add(creditAccount);
    }

    public List<Account> getDepositAccounts() {
        return Collections.unmodifiableList(depositAccounts);
    }

    public void addDepositAccount(DepositAccount depositAccount) {
        depositAccounts.add(depositAccount);
    }

    public List<Account> getDebitAccounts() {
        return Collections.unmodifiableList(debitAccounts);
    }

    public void addDebitAccount(DebitAccount debitAccount) {
        debitAccounts.add(debitAccount);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isSubscriptionDesire() {
        return subscriptionDesire;
    }

    public String addAddress(String address) {
        this.address = address;
        return this.address;
    }

    public String addPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
        return this.passportNumber;
    }

    public boolean changeSubscriptionDesire(boolean decision) {
        subscriptionDesire = decision;
        return subscriptionDesire;
    }

    public boolean getSubscriptionDesire() {
        return subscriptionDesire;
    }

    public void setSubscriptionDesire(boolean subscriptionDesire) {
        this.subscriptionDesire = subscriptionDesire;
    }

    public void update(Account account) {
        if (CreditAccount.class.equals(account.getClass())) {
            notifications.add("Credit account terms updated");
        } else if (DepositAccount.class.equals(account.getClass())) {
            notifications.add("Deposit account terms updated");
        } else if (DebitAccount.class.equals(account.getClass())) {
            notifications.add("Debit account terms updated");
        }
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
