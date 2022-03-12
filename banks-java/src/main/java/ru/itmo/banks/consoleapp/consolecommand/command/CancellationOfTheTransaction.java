package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.Bank;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolesweep.FindSubtypes;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class CancellationOfTheTransaction extends CommandClass {
    public void command() {
        String answer = getConsoleApp().consoleToString("Скажите, операция происходила с одним и тем же счётом ?");

        if (Objects.equals(answer, "Yes")) {
            System.out.println("Введите сегодняшнюю дату");

            Scanner in = new Scanner(System.in);
            String date = in.next();
            LocalDate tempDate = LocalDate.parse(date);

            int transactionNumber =
                    getConsoleApp().consoleToInt("Введите номер операции, которую хотите отменить: ");

            String bankName =
                    getConsoleApp().consoleToString("Введите имя банка, в котором происходила операция: ");
            Bank tempBank = FindSubtypes.findBankByName(getCentralBanks(), bankName);

            tempBank.cancellationOfTheTransaction(transactionNumber);
            System.out.println("Перевод успешно отменён, деньги были вернуты на счета.");
        } else {
            System.out.println("Введите сегодняшнюю дату");
            Scanner in = new Scanner(System.in);
            String date = in.next();
            LocalDate tempDate = LocalDate.parse(date);

            int transactionNumber =
                    getConsoleApp().consoleToInt("Введите номер операции, которую хотите отменить: ");

            getCentralBanks().get(0).сancellationOfTheTransaction(transactionNumber);
            System.out.println("Перевод успешно отменён, деньги были вернуты на счета.");
        }
    }
}
