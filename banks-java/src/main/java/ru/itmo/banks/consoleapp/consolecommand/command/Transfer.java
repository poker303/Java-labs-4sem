package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.Bank;
import ru.itmo.banks.account.Account;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.FindSubtypes;

import java.time.LocalDate;
import java.util.Scanner;

public class Transfer extends CommandClass {
    public void command() {
        String answer =
                getConsoleApp().consoleToString("Скажите, вы хотите сделать перевод со счёта на счёт в одном банке ?");

        if (answer.equals("Yes")) {
            System.out.println("Введите сегодняшнюю дату");
            Scanner in = new Scanner(System.in);
            LocalDate tempDate = LocalDate.parse(in.next());
            String bankName =
                    getConsoleApp().consoleToString("Введите имя банка, которому принадлежат счёта");
            Bank tempBank = FindSubtypes.findBankByName(getCentralBanks(), bankName);
            int accountNumber1 =
                    getConsoleApp().consoleToInt("Введите номер счёта, с которого хотите перевести деньги: ");
            Account tempAccount3 = FindSubtypes.findAccountByNumber(accountNumber1, tempBank);
            int accountNumber2 =
                    getConsoleApp().consoleToInt("Введите номер счёта, на который хотите перевести деньги:");
            Account tempAccount = FindSubtypes.findAccountByNumber(accountNumber2, tempBank);
            int transferAmount = getConsoleApp().consoleToInt("Введите сумму, которую хотите перевести: ");

            getCentralBanks().get(0).transfer(transferAmount, tempAccount3, tempAccount, tempBank, tempDate);

            System.out.printf("Операция прошла успешно, текущяя сумма на первом счёте: %f , на втором: %f",
                    tempAccount3.getAmount(), tempAccount.getAmount());
        } else {
            System.out.println("Введите сегодняшнюю дату");
            Scanner in = new Scanner(System.in);
            LocalDate tempDate = LocalDate.parse(in.next());
            String bankName1 =
                    getConsoleApp().consoleToString(
                            "Введите имя банка, с аккаунта которого хотите перевести деньги");
            Bank tempBank1 = FindSubtypes.findBankByName(getCentralBanks(), bankName1);
            String bankName2 =
                    getConsoleApp().consoleToString(
                            "Введите имя банка, на аккаунт которого хотите получить деньги");
            Bank tempBank2 = FindSubtypes.findBankByName(getCentralBanks(), bankName2);
            int accountNumber1 =
                    getConsoleApp().consoleToInt("Введите номер счёта, с которого хотите перевести деньги: ");
            Account tempAccount1 = FindSubtypes.findAccountByNumber(accountNumber1, tempBank1);
            int accountNumber2 =
                    getConsoleApp().consoleToInt("Введите номер счёта, на который хотите перевести деньги:");
            Account tempAccount2 = FindSubtypes.findAccountByNumber(accountNumber2, tempBank1);
            int transferAmount = getConsoleApp().consoleToInt("Введите сумму, которую хотите перевести: ");

            getCentralBanks().get(0).transfer(transferAmount, tempAccount1, tempAccount2, tempBank1, tempBank2, tempDate);

            System.out.printf("Операция прошла успешно, текущяя сумма на первом счёте: %f , на втором: %f",
                    tempAccount1.getAmount(), tempAccount2.getAmount());
        }
    }
}
