package ru.itmo.banks.consoleApp.consoleCommand.command;

import ru.itmo.banks.consoleApp.consoleCommand.CommandClass;
import ru.itmo.banks.consoleApp.consoleSweep.CreateSubtypes;

public class CreateBank extends CommandClass {
    public void command() {
        String centralBank = getConsoleApp().consoleToString("Введите имя центрального банка");
        int number = getConsoleApp().consoleToInt("Введите номер шаблона банка");
        CreateSubtypes.createBank(getTemplateParametersForCreatingBank(), getCentralBanks(), centralBank, number);
    }
}
