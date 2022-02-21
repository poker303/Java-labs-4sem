package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Client;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;

public class CreateClient extends CommandClass {
    public void command() {
        String clientName = consoleApp.consoleToString("Введите имя клиента");
        String clientSurname = consoleApp.consoleToString("Введите фамилию клиента");
        int clientMoney = consoleApp.consoleToInt("Введите деньги клиента");

        var client = new Client(clientName, clientSurname, clientMoney);
        clients.add(client);
    }
}
