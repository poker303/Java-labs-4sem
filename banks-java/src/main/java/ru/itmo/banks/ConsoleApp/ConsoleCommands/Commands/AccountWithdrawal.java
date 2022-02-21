package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Accounts.Account;
import ru.itmo.banks.Bank;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.FindSubtypes;
import ru.itmo.banks.Exceptions.BanksExceptions;

import java.time.LocalDate;
import java.util.Scanner;

public class AccountWithdrawal extends CommandClass {
    public void command() throws BanksExceptions {
        System.out.println("Введите сегодняшнюю дату");
        Scanner in = new Scanner(System.in);
        String date = in.next();
        LocalDate tempDate = LocalDate.parse(date);
        int accountNumber = consoleApp.consoleToInt("Введите номер счёта");
        String bankName = consoleApp.consoleToString("Введите имя банка, которому принадлежит счёт");
        Bank tempBank = FindSubtypes.findBankByName(centralBanks, bankName);
        int withdrawalAmount = consoleApp.consoleToInt("Введите сумму, которую хотите внести на счёт: ");

        Account tempAccount = FindSubtypes.findAccountByNumber(accountNumber, tempBank);
        tempBank.withdrawal(withdrawalAmount, tempAccount, tempDate);
        System.out.printf("Операция прошла успешно, текущяя сумма на счёте: %d", tempAccount.getAmount());
    }
}
