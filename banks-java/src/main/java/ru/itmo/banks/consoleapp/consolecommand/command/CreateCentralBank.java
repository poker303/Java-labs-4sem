package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.CreateSubtypes;

public class CreateCentralBank extends CommandClass {
    public void command() {
        String centralBankName = getConsoleApp().consoleToString("Введите имя центрального банка");
        String centralBankCountry = getConsoleApp().consoleToString("Введите страну центрального банка");
        CreateSubtypes.createCentralBank(getCentralBanks(), centralBankName, centralBankCountry);
        System.out.printf("Центральный Банк: %s в стране %s создан.", centralBankName, centralBankCountry);
    }
}
