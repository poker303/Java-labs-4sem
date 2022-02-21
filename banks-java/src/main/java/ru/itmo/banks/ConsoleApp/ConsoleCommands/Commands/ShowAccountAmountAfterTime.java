package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Bank;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.FindSubtypes;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.ShowSubtypes;

import java.time.LocalDate;
import java.util.Scanner;

public class ShowAccountAmountAfterTime extends CommandClass {
    public void command()
    {
        int accountNumber = consoleApp.consoleToInt("Введите номер счёта");

        String bankName = consoleApp.consoleToString("Введите имя банка, которому принадлежит счёт");
        Bank tempBank = FindSubtypes.findBankByName(centralBanks, bankName);

        System.out.println("Введите дату, в которую хотите посмотреть сумму на счёте");
        Scanner in = new Scanner(System.in);
        LocalDate date = LocalDate.parse(in.next());


        System.out.println("Сумма на счёте к введённой дате: ");
        System.out.println(ShowSubtypes.showAccountAfterTime(FindSubtypes.findAccountByNumber(accountNumber, tempBank), date));
    }
}
