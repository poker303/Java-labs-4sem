package ru.itmo.banks;

import ru.itmo.banks.ConsoleApp.ConsoleApp;
import ru.itmo.banks.Exceptions.BanksExceptions;

public class Program {
    public static void main(String[] args) throws BanksExceptions {
        var consoleApp1 = new ConsoleApp();
        consoleApp1.startConsole();
    }
}
