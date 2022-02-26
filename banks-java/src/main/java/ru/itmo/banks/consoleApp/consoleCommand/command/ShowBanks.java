package ru.itmo.banks.consoleApp.consoleCommand.command;

import ru.itmo.banks.consoleApp.consoleCommand.CommandClass;
import ru.itmo.banks.consoleApp.consoleSweep.OutputSubtypes;
import ru.itmo.banks.consoleApp.consoleSweep.ShowSubtypes;

import java.util.List;

public class ShowBanks extends CommandClass {
    public void command() {
        List<String> tempBanks = ShowSubtypes.showBanks(getCentralBanks());
        System.out.println("Текущие банки: ");
        OutputSubtypes.output((String[]) tempBanks.toArray());
    }
}
