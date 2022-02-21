package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.AmountPercentPair;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.TransmittedParameters.BankParameters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SettingParametersToBank extends CommandClass {
    public void command() {
        int number = consoleApp.consoleToInt("Введите номер шаблона");
        String nameBank = consoleApp.consoleToString("Введите имя банка");
        int numbers = consoleApp.consoleToInt("Введите количество критических сумм");

        var boundarySums = new ArrayList<Integer>();
        for (int i = 0; i < numbers; i++) {
            //int boundarySum = Convert.ToInt32(Console.ReadLine());
            Scanner in = new Scanner(System.in);
            String sum = in.next();
            int boundarySum = Integer.parseInt(sum);
            boundarySums.add(boundarySum);
        }

        System.out.println("Введите проценты");
        var percents = new ArrayList<Integer>();
        for (int i = 0; i < numbers - 1; i++) {
            Scanner in = new Scanner(System.in);
            String per = in.next();
            int percent = Integer.parseInt(per);
            percents.add(percent);
        }

        var table = new AmountPercentPair(boundarySums, percents);
        int reliabilityAmount = consoleApp.consoleToInt("Введите ограничительную сумму если счёт ненадёжный");
        int debitPercent = consoleApp.consoleToInt("Введите процент дебетового счёта");
        int debitCommission = consoleApp.consoleToInt("Введите комиссию дебетового счёта");
        int creditPercent = consoleApp.consoleToInt("Введите процент кредитного счёта");
        int creditCommission = consoleApp.consoleToInt("Введите комиссию кредитного счёта");
        int depositCommission = consoleApp.consoleToInt("Введите комиссию депозитного счёта");
        int creditLimit = consoleApp.consoleToInt("Введите лимит по кредитным счетам счёта");

        var parameters = new BankParameters(nameBank, table, reliabilityAmount, debitPercent, debitCommission, creditPercent, creditCommission, depositCommission, creditLimit);
        templateParametersForCreatingBank.set(number, parameters);
    }
}
