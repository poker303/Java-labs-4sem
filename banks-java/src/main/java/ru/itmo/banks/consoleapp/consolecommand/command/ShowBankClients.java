package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.Bank;
import ru.itmo.banks.Client;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.FindSubtypes;
import ru.itmo.banks.consoleapp.consolesweep.OutputSubtypes;
import ru.itmo.banks.consoleapp.consolesweep.ShowSubtypes;

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
