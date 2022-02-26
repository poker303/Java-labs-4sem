package ru.itmo.banks.consoleApp.consoleCommand.command;

import ru.itmo.banks.Bank;
import ru.itmo.banks.account.Account;
import ru.itmo.banks.consoleApp.consoleCommand.CommandClass;
import ru.itmo.banks.consoleApp.consoleSweep.FindSubtypes;

public class ChangeDebitAccountOptions extends CommandClass {
    public void command() {
        String bankName = getConsoleApp().consoleToString(
                "Введите имя банка, в котором будет счёт условия которого мы хотим поменять: ");
        Bank tempBank = FindSubtypes.findBankByName(getCentralBanks(), bankName);

        int accountNumber =
                getConsoleApp().consoleToInt("Введите номер дебитового счёта, условия которого хотите поменять:");
        Account tempAccount = FindSubtypes.findAccountByNumber(accountNumber, tempBank);
        int newDebitPercent = getConsoleApp().consoleToInt("Введите новый процент дебетового счёта");
        int newDebitCommission = getConsoleApp().consoleToInt("Введите новую комиссию дебетового счёта");

        tempBank.changeDebitAccountOptions(tempAccount, newDebitPercent, newDebitCommission);
    }
}
