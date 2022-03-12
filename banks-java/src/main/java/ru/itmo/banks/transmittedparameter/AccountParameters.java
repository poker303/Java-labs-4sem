package ru.itmo.banks.transmittedparameter;

import java.time.LocalDate;

public class AccountParameters {
    private int reliabilityAmount;
    private int number;
    private double amount;
    private int commission;
    private boolean possibilityOfWithdrawal;
    private LocalDate openingDate;
    private int duration;
    private boolean reliability;

    public AccountParameters(int number, double amount, int commission, boolean possibilityOfWithdrawal, LocalDate openingDate, int duration, boolean reliability, int reliabilityAmount) {
        this.number = number;
        this.amount = amount;
        this.commission = commission;
        this.possibilityOfWithdrawal = possibilityOfWithdrawal;
        this.openingDate = openingDate;
        this.duration = duration;
        this.reliability = reliability;
        this.reliabilityAmount = reliabilityAmount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public boolean isPossibilityOfWithdrawal() {
        return possibilityOfWithdrawal;
    }

    public void setPossibilityOfWithdrawal(boolean possibilityOfWithdrawal) {
        this.possibilityOfWithdrawal = possibilityOfWithdrawal;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isReliability() {
        return reliability;
    }

    public void setReliability(boolean reliability) {
        this.reliability = reliability;
    }

    public int getReliabilityAmount() {
        return reliabilityAmount;
    }

    public void setReliabilityAmount(int reliabilityAmount) {
        this.reliabilityAmount = reliabilityAmount;
    }
}
