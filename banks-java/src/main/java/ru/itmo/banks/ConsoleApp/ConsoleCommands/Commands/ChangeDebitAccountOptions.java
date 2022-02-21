package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Accounts.Account;
import ru.itmo.banks.Bank;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.FindSubtypes;

public class ChangeDebitAccountOptions extends CommandClass {
    public void command() {
        String bankName = consoleApp.consoleToString(
                "Введите имя банка, в котором будет счёт условия которого мы хотим поменять: ");
        Bank tempBank = FindSubtypes.findBankByName(centralBanks, bankName);

        int accountNumber =
                consoleApp.consoleToInt("Введите номер дебитового счёта, условия которого хотите поменять:");
        Account tempAccount = FindSubtypes.findAccountByNumber(accountNumber, tempBank);
        int newDebitPercent = consoleApp.consoleToInt("Введите новый процент дебетового счёта");
        int newDebitCommission = consoleApp.consoleToInt("Введите новую комиссию дебетового счёта");

        tempBank.changeDebitAccountOptions(tempAccount, newDebitPercent, newDebitCommission);
    }
}
