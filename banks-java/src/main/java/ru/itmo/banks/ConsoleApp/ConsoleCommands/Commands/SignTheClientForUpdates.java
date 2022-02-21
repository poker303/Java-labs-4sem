package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Bank;
import ru.itmo.banks.Client;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.FindSubtypes;
import ru.itmo.banks.Exceptions.BanksExceptions;

public class SignTheClientForUpdates extends CommandClass {
    public void command() throws BanksExceptions {
        String clientName = consoleApp.consoleToString("Введите имя клиента");
        String clientSurName = consoleApp.consoleToString("Введите фамилию клиента");
        Client tempClient = FindSubtypes.findClientByNameSurname(clients, clientName, clientSurName).get(0);

        String bankName = consoleApp.consoleToString(
                "Введите имя банка, на счета которого будет подписываться клиент: ");
        Bank tempBank = FindSubtypes.findBankByName(centralBanks, bankName);

        tempBank.attachObserver(tempClient);
    }
}
