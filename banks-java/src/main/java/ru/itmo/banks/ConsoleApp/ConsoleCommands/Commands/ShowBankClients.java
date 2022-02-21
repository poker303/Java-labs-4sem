package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Bank;
import ru.itmo.banks.Client;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.FindSubtypes;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.OutputSubtypes;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.ShowSubtypes;

import java.util.List;

public class ShowBankClients extends CommandClass {
    public void command() {
        String bankName = consoleApp.consoleToString("Введите имя банка, клиентов которого хотите посмотреть");
        Bank tempBank = FindSubtypes.findBankByName(centralBanks, bankName);

        List<Client> tempBankClients = ShowSubtypes.showBankClients(tempBank);
        System.out.println("Клиенты текущего банка: ");
        OutputSubtypes.output((Client[]) tempBankClients.toArray());
    }
}
