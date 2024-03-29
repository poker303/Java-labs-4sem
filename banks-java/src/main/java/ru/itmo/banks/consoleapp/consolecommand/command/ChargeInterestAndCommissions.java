package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.consoleapp.consolecommand.CommandClass;

import java.time.LocalDate;
import java.util.Scanner;

public class ChargeInterestAndCommissions extends CommandClass {
    public void command() {
        System.out.println("Введите сегодняшнюю дату");
        Scanner in = new Scanner(System.in);
        String date = in.next();
        LocalDate tempDate = LocalDate.parse(date);
        getCentralBanks().get(0).notification(tempDate);
    }
}
