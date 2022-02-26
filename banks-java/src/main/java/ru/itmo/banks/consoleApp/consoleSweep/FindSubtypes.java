package ru.itmo.banks.consoleApp.consoleSweep;

import ru.itmo.banks.Bank;
import ru.itmo.banks.CentralBank;
import ru.itmo.banks.Client;
import ru.itmo.banks.account.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindSubtypes {

    public static List<Client> findClientByNameSurname(List<Client> clients, String clientName, String clientSurName) {
        List<Client> foundClients = new ArrayList<>();
        for (Client client : clients) {
            if (Objects.equals(client.getName(), clientName) && Objects.equals(client.getSurname(), clientSurName)) {
                foundClients.add(client);
            }
        }
        return foundClients;
    }

    public static Bank findBankByName(List<CentralBank> centralBanks, String nameBank) {
        List<Bank> foundBanks = new ArrayList<>();
        for (Bank bank : centralBanks.get(0).getBanks()) {
            if (Objects.equals(bank.getName(), nameBank)) {
                foundBanks.add(bank);
            }
        }
        return foundBanks.get(0);
    }

    public static Account findAccountByNumber(int number, Bank bank) {
        Account foundAccount = null;

        List<Account> tempAccounts = new ArrayList<>(bank.getCreditAccounts());
        tempAccounts.addAll(bank.getDebitAccounts());
        tempAccounts.addAll(bank.getDepositAccounts());

        for (Account account : tempAccounts) {
            if (account.getNumber() == number) {
                foundAccount = account;
            }
        }

        return foundAccount;
    }
}
