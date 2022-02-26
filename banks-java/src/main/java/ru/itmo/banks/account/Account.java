package ru.itmo.banks.account;

import ru.itmo.banks.exception.BanksExceptions;
import ru.itmo.banks.transmittedParameter.AccountParameters;

import java.time.LocalDate;

public class Account {
    private final int duration;
    private final int number;
    private final LocalDate openingDate;
    private final LocalDate closeDate;
    private int reliabilityAmount;
    private float percent;
    private int commission;
    private boolean reliability;
    private double amount;
    private boolean possibilityOfWithdrawal;

    public Account(AccountParameters parameters) {
        number = parameters.getNumber();
        if (parameters.getAmount() < 0) {
            throw new BanksExceptions("Account's amount can't be less zero.");
        }

        duration = parameters.getDuration();
        reliabilityAmount = parameters.getReliabilityAmount();
        closeDate = parameters.getOpeningDate().plusDays(parameters.getDuration());
        this.reliability = parameters.isReliability();
        commission = parameters.getCommission();
        amount = parameters.getAmount();
        this.openingDate = parameters.getOpeningDate();
        this.possibilityOfWithdrawal = parameters.isPossibilityOfWithdrawal();
    }

    public int getReliabilityAmount() {
        return reliabilityAmount;
    }

    public void setReliabilityAmount(int reliabilityAmount) {
        this.reliabilityAmount = reliabilityAmount;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public boolean isReliability() {
        return reliability;
    }

    public void setReliability(boolean reliability) {
        this.reliability = reliability;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public boolean isPossibilityOfWithdrawal() {
        return possibilityOfWithdrawal;
    }

    public void setPossibilityOfWithdrawal(boolean possibilityOfWithdrawal) {
        this.possibilityOfWithdrawal = possibilityOfWithdrawal;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public int getNumber() {
        return number;
    }

    public int getDuration() {
        return duration;
    }

    public double withdrawal(int withdrawalAmount) {
        if (withdrawalAmount < 0) {
            throw new BanksExceptions("You cannot withdraw a negative amount.");
        }

        amount -= withdrawalAmount;
        return amount;
    }

    public double replenishment(int replenishmentAmount) {
        if (replenishmentAmount < 0) {
            throw new BanksExceptions("You cannot put a negative amount on the account.");
        }

        amount += replenishmentAmount;
        return amount;
    }

    public float setPercents(float newPercent) {
        percent = newPercent;
        return percent;
    }
}
