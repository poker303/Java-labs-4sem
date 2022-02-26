package ru.itmo.banks.consoleApp.consoleCommand.command;

import ru.itmo.banks.Client;
import ru.itmo.banks.consoleApp.consoleCommand.CommandClass;
import ru.itmo.banks.consoleApp.consoleSweep.FindSubtypes;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CreateAccount extends CommandClass {
    public void command() {
        String bankName = getConsoleApp().consoleToString("Введите имя банка, в котором хотите создать счёт");
        String clientName = getConsoleApp().consoleToString("Введите имя клиента");
        String clientSurName = getConsoleApp().consoleToString("Введите фамилию клиента");

        FindSubtypes.findClientByNameSurname(getClients(), clientName, clientSurName);
        int amount = getConsoleApp().consoleToInt("Введите сумму счёта");

        System.out.println("Введите дату открытия счёта.");

        Scanner in = new Scanner(System.in);
        String date = in.next();
        LocalDate openingDate = LocalDate.parse(date);

        int duration = getConsoleApp().consoleToInt("Введите период длительности счёта.");

        List<Client> accountOwner = FindSubtypes.findClientByNameSurname(getClients(), clientName, clientSurName);
        FindSubtypes.findBankByName(getCentralBanks(), bankName).createDebitAccount(accountOwner.get(0), amount, openingDate, duration);
    }
}
