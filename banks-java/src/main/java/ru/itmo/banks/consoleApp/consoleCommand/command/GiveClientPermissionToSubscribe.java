package ru.itmo.banks.consoleApp.consoleCommand.command;

import ru.itmo.banks.Client;
import ru.itmo.banks.consoleApp.consoleCommand.CommandClass;
import ru.itmo.banks.consoleApp.consoleSweep.FindSubtypes;

public class GiveClientPermissionToSubscribe extends CommandClass {
    public void command() {
        String clientName = getConsoleApp().consoleToString("Введите имя клиента");
        String clientSurName = getConsoleApp().consoleToString("Введите фамилию клиента");
        Client tempClient = FindSubtypes.findClientByNameSurname(getClients(), clientName, clientSurName).get(0);
        tempClient.changeSubscriptionDesire(true);
    }
}
