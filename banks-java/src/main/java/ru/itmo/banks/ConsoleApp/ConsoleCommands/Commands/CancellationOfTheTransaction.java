package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Bank;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.FindSubtypes;
import ru.itmo.banks.Exceptions.BanksExceptions;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class CancellationOfTheTransaction extends CommandClass {
    public void command() throws BanksExceptions {
        String answer = consoleApp.consoleToString("Скажите, операция происходила с одним и тем же счётом ?");

        if (Objects.equals(answer, "Yes")) {
            System.out.println("Введите сегодняшнюю дату");

            Scanner in = new Scanner(System.in);
            String date = in.next();
            LocalDate tempDate = LocalDate.parse(date);

            int transactionNumber =
                    consoleApp.consoleToInt("Введите номер операции, которую хотите отменить: ");

            String bankName =
                    consoleApp.consoleToString("Введите имя банка, в котором происходила операция: ");
            Bank tempBank = FindSubtypes.findBankByName(centralBanks, bankName);

            tempBank.cancellationOfTheTransaction(transactionNumber);
            System.out.println("Перевод успешно отменён, деньги были вернуты на счета.");
        } else {
            System.out.println("Введите сегодняшнюю дату");
            Scanner in = new Scanner(System.in);
            String date = in.next();
            LocalDate tempDate = LocalDate.parse(date);

            int transactionNumber =
                    consoleApp.consoleToInt("Введите номер операции, которую хотите отменить: ");

            centralBanks.get(0).сancellationOfTheTransaction(transactionNumber);
            System.out.println("Перевод успешно отменён, деньги были вернуты на счета.");
        }
    }
}
