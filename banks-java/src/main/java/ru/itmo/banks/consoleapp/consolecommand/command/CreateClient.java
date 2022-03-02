package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.Client;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;

public class CreateClient extends CommandClass {
    public void command() {
        String clientName = getConsoleApp().consoleToString("Введите имя клиента");
        String clientSurname = getConsoleApp().consoleToString("Введите фамилию клиента");
        int clientMoney = getConsoleApp().consoleToInt("Введите деньги клиента");

        var client = new Client(clientName, clientSurname, clientMoney);
        addClient(client);
    }
}
