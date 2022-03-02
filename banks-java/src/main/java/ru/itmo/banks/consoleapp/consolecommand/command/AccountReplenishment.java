package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.Bank;
import ru.itmo.banks.account.Account;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.FindSubtypes;

import java.time.LocalDate;
import java.util.Scanner;

public class AccountReplenishment extends CommandClass {
    public void command() {
        System.out.println("Введите сегодняшнюю дату");
        Scanner in = new Scanner(System.in);
        String date = in.next();
        LocalDate tempDate = LocalDate.parse(date);
        int accountNumber = getConsoleApp().consoleToInt("Введите номер счёта");
        String bankName = getConsoleApp().consoleToString("Введите имя банка, которому принадлежит счёт");
        Bank tempBank = FindSubtypes.findBankByName(getCentralBanks(), bankName);
        int replenishmentAmount = getConsoleApp().consoleToInt("Введите сумму, которую хотите внести на счёт: ");

        Account tempAccount = FindSubtypes.findAccountByNumber(accountNumber, tempBank);
        tempBank.replenishment(replenishmentAmount, tempAccount, tempDate);
        System.out.printf("Операция прошла успешно, текущяя сумма на счёте: %d", tempAccount.getAmount());
    }
}
