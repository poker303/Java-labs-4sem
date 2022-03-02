package ru.itmo.banks.consoleapp.consolecommand.command;

import ru.itmo.banks.AmountPercentPair;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.transmittedparameter.BankParameters;

import java.util.ArrayList;
import java.util.Scanner;

public class SettingParametersToBank extends CommandClass {
    public void command() {
        int number = getConsoleApp().consoleToInt("Введите номер шаблона");
        String nameBank = getConsoleApp().consoleToString("Введите имя банка");
        int numbers = getConsoleApp().consoleToInt("Введите количество критических сумм");

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
        int reliabilityAmount = getConsoleApp().consoleToInt("Введите ограничительную сумму если счёт ненадёжный");
        int debitPercent = getConsoleApp().consoleToInt("Введите процент дебетового счёта");
        int debitCommission = getConsoleApp().consoleToInt("Введите комиссию дебетового счёта");
        int creditPercent = getConsoleApp().consoleToInt("Введите процент кредитного счёта");
        int creditCommission = getConsoleApp().consoleToInt("Введите комиссию кредитного счёта");
        int depositCommission = getConsoleApp().consoleToInt("Введите комиссию депозитного счёта");
        int creditLimit = getConsoleApp().consoleToInt("Введите лимит по кредитным счетам счёта");

        var parameters = new BankParameters(nameBank, table, reliabilityAmount, debitPercent, debitCommission, creditPercent, creditCommission, depositCommission, creditLimit);
        getTemplateParametersForCreatingBank().set(number, parameters);
    }
}
