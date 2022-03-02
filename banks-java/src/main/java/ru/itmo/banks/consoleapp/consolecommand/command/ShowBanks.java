package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.OutputSubtypes;
import ru.itmo.banks.consoleapp.consolesweep.ShowSubtypes;

import java.util.List;

public class ShowBanks extends CommandClass {
    public void command() {
        List<String> tempBanks = ShowSubtypes.showBanks(getCentralBanks());
        System.out.println("Текущие банки: ");
        OutputSubtypes.output((String[]) tempBanks.toArray());
    }
}
