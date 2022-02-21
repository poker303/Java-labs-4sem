package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;

import java.time.LocalDate;
import java.util.Scanner;

public class ChargeInterestAndCommissions extends CommandClass {
    public void command() {
        System.out.println("Введите сегодняшнюю дату");
        Scanner in = new Scanner(System.in);
        String date = in.next();
        LocalDate tempDate = LocalDate.parse(date);
        centralBanks.get(0).notification(tempDate);
    }
}
