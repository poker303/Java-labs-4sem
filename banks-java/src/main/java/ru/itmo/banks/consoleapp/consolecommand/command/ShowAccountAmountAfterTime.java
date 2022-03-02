package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.Bank;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.FindSubtypes;
import ru.itmo.banks.consoleapp.consolesweep.ShowSubtypes;

import java.time.LocalDate;
import java.util.Scanner;

public class ShowAccountAmountAfterTime extends CommandClass {
    public void command() {
        int accountNumber = getConsoleApp().consoleToInt("Введите номер счёта");

        String bankName = getConsoleApp().consoleToString("Введите имя банка, которому принадлежит счёт");
        Bank tempBank = FindSubtypes.findBankByName(getCentralBanks(), bankName);

        System.out.println("Введите дату, в которую хотите посмотреть сумму на счёте");
        Scanner in = new Scanner(System.in);
        LocalDate date = LocalDate.parse(in.next());


        System.out.println("Сумма на счёте к введённой дате: ");
        System.out.println(ShowSubtypes.showAccountAfterTime(FindSubtypes.findAccountByNumber(accountNumber, tempBank), date));
    }
}
