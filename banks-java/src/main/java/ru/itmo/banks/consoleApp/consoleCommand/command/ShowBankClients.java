package ru.itmo.banks.consoleApp.consoleCommand.command;

import ru.itmo.banks.Bank;
import ru.itmo.banks.Client;
import ru.itmo.banks.consoleApp.consoleCommand.CommandClass;
import ru.itmo.banks.consoleApp.consoleSweep.FindSubtypes;
import ru.itmo.banks.consoleApp.consoleSweep.OutputSubtypes;
import ru.itmo.banks.consoleApp.consoleSweep.ShowSubtypes;

import java.util.List;

public class ShowBankClients extends CommandClass {
    public void command() {
        String bankName = getConsoleApp().consoleToString("Введите имя банка, клиентов которого хотите посмотреть");
        Bank tempBank = FindSubtypes.findBankByName(getCentralBanks(), bankName);

        List<Client> tempBankClients = ShowSubtypes.showBankClients(tempBank);
        System.out.println("Клиенты текущего банка: ");
        OutputSubtypes.output((Client[]) tempBankClients.toArray());
    }
}
