package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Client;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.FindSubtypes;
import ru.itmo.banks.Exceptions.BanksExceptions;

import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateAccount extends CommandClass {
    public  void command() throws BanksExceptions {
        String bankName = consoleApp.consoleToString("Введите имя банка, в котором хотите создать счёт");
        String clientName = consoleApp.consoleToString("Введите имя клиента");
        String clientSurName = consoleApp.consoleToString("Введите фамилию клиента");

        FindSubtypes.findClientByNameSurname(clients, clientName, clientSurName);
        int amount = consoleApp.consoleToInt("Введите сумму счёта");

        System.out.println("Введите дату открытия счёта.");

        Scanner in = new Scanner(System.in);
        String date = in.next();
        LocalDate openingDate = LocalDate.parse(date);

        int duration = consoleApp.consoleToInt("Введите период длительности счёта.");

        List<Client> accountOwner = FindSubtypes.findClientByNameSurname(clients, clientName, clientSurName);
        FindSubtypes.findBankByName(centralBanks, bankName).createDebitAccount(accountOwner.get(0), amount, openingDate, duration);
    }
}
