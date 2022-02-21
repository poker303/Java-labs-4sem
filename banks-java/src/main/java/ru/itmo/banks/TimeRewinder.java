package ru.itmo.banks;

import ru.itmo.banks.Accounts.Account;

import java.time.LocalDate;
import java.time.Period;

public class TimeRewinder {
    public TimeRewinder(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }

    public LocalDate rewindTime(LocalDate startDate, LocalDate time) {
        Period tempDate = startDate.until(time);
        startDate = startDate.plus(tempDate);
        return startDate;
    }

    public double accountAfterTime(Account account, LocalDate date) {
        double tempPercent = account.getPercent() / 36500d;
        int numberOfElapsedDays = (date.until(account.getOpeningDate())).getDays();
        for (int day = 0; day < numberOfElapsedDays; day++) {
            account.setAmount(account.getAmount() + account.getAmount() * tempPercent);
            if (account.getAmount() < 0) {
                account.setAmount(account.getAmount() - account.getCommission());
            }
        }

        return account.getAmount();
    }
}
