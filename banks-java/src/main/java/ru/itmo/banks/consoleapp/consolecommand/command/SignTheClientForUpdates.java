package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.Bank;
import ru.itmo.banks.Client;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.FindSubtypes;

public class SignTheClientForUpdates extends CommandClass {
    public void command() {
        String clientName = getConsoleApp().consoleToString("Введите имя клиента");
        String clientSurName = getConsoleApp().consoleToString("Введите фамилию клиента");
        Client tempClient = FindSubtypes.findClientByNameSurname(getClients(), clientName, clientSurName).get(0);

        String bankName = getConsoleApp().consoleToString(
                "Введите имя банка, на счета которого будет подписываться клиент: ");
        Bank tempBank = FindSubtypes.findBankByName(getCentralBanks(), bankName);

        tempBank.attachObserver(tempClient);
    }
}
