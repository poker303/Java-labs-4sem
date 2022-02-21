package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.OutputSubtypes;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.ShowSubtypes;

import java.util.List;

public class ShowBanks extends CommandClass {
    public void command() {
        List<String> tempBanks = ShowSubtypes.showBanks(centralBanks);
        System.out.println("Текущие банки: ");
        OutputSubtypes.output((String[]) tempBanks.toArray());
    }
}
