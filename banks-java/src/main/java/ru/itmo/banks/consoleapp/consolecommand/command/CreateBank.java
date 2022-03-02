package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.CreateSubtypes;

public class CreateBank extends CommandClass {
    public void command() {
        String centralBank = getConsoleApp().consoleToString("Введите имя центрального банка");
        int number = getConsoleApp().consoleToInt("Введите номер шаблона банка");
        CreateSubtypes.createBank(getTemplateParametersForCreatingBank(), getCentralBanks(), centralBank, number);
    }
}
