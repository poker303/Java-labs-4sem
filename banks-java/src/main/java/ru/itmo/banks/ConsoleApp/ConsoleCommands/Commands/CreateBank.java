package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.CreateSubtypes;

public class CreateBank extends CommandClass {
    public void command() {
        String centralBank = consoleApp.consoleToString("Введите имя центрального банка");
        int number = consoleApp.consoleToInt("Введите номер шаблона банка");
        CreateSubtypes.createBank(templateParametersForCreatingBank, centralBanks, centralBank, number);
    }
}
