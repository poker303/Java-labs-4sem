package ru.itmo.banks.consoleApp.consoleCommand.command;

import ru.itmo.banks.consoleApp.consoleCommand.CommandClass;
import ru.itmo.banks.consoleApp.consoleSweep.CreateSubtypes;

public class CreateCentralBank extends CommandClass {
    public void command() {
        String centralBankName = getConsoleApp().consoleToString("Введите имя центрального банка");
        String centralBankCountry = getConsoleApp().consoleToString("Введите страну центрального банка");
        CreateSubtypes.createCentralBank(getCentralBanks(), centralBankName, centralBankCountry);
        System.out.printf("Центральный Банк: %s в стране %s создан.", centralBankName, centralBankCountry);
    }
}
