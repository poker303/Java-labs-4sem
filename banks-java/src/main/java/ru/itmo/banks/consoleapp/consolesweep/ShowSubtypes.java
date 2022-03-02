package ru.itmo.banks.consoleapp.consolesweep;

import ru.itmo.banks.Bank;
import ru.itmo.banks.CentralBank;
import ru.itmo.banks.Client;
import ru.itmo.banks.TimeRewinder;
import ru.itmo.banks.account.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowSubtypes {

    public static List<String> showBanks(List<CentralBank> centralBanks) {
        List<String> banksNames = new ArrayList<>();
        for (Bank bank : centralBanks.get(0).getBanks()) {
            banksNames.add(bank.getName());
        }
        return banksNames;
    }

    public static List<Client> showBankClients(Bank bank) {
        return bank.getClients();
    }

    public static double showAccountAfterTime(Account account, LocalDate date) {
        var timeRewinder = new TimeRewinder("first");
        return timeRewinder.accountAfterTime(account, date);
    }
}
