package ru.itmo.banks.ConsoleApp.ConsoleCommands.Commands;

import ru.itmo.banks.Accounts.Account;
import ru.itmo.banks.Client;
import ru.itmo.banks.ConsoleApp.ConsoleCommands.CommandClass;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.FindSubtypes;

public class ShowClientAccountsInfo extends CommandClass {
    public void command()
    {
        String clientName = consoleApp.consoleToString("Введите имя клиента");
        String clientSurName = consoleApp.consoleToString("Введите фамилию клиента");
        Client tempClient = FindSubtypes.findClientByNameSurname(clients, clientName, clientSurName).get(0);

        System.out.println("Дебитовые счета: ");

        for (Account debitAccount : tempClient.getDebitAccounts()){
            System.out.printf("Номер счёта: %d , Сумма на счёте: %f", debitAccount.getNumber(), debitAccount.getAmount());
        }

        System.out.println("Кредитные счета: ");

        for (Account creditAccount : tempClient.getCreditAccounts()){
            System.out.printf("Номер счёта: %d , Сумма на счёте: %f", creditAccount.getNumber(), creditAccount.getAmount());
        }

        System.out.println("Депозитные счета: ");

        for (Account depositAccount : tempClient.getDepositAccounts()){
            System.out.printf("Номер счёта: %d , Сумма на счёте: %f", depositAccount.getNumber(), depositAccount.getAmount());
        }
    }
}
