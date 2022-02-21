package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.CreateSubtypes;

public class CreateCentralBank extends CommandClass {
    public void command()
    {
        String centralBankName = consoleApp.consoleToString("Введите имя центрального банка");
        String centralBankCountry = consoleApp.consoleToString("Введите страну центрального банка");
        CreateSubtypes.createCentralBank(centralBanks, centralBankName, centralBankCountry);
        System.out.printf("Центральный Банк: %s в стране %s создан.", centralBankName, centralBankCountry);
    }
}
