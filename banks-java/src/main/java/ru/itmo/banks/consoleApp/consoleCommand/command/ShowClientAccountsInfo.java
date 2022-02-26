package ru.itmo.banks.consoleApp.consoleCommand.command;

import ru.itmo.banks.Client;
import ru.itmo.banks.account.Account;
import ru.itmo.banks.consoleApp.consoleCommand.CommandClass;
import ru.itmo.banks.consoleApp.consoleSweep.FindSubtypes;

public class ShowClientAccountsInfo extends CommandClass {
    public void command() {
        String clientName = getConsoleApp().consoleToString("Введите имя клиента");
        String clientSurName = getConsoleApp().consoleToString("Введите фамилию клиента");
        Client tempClient = FindSubtypes.findClientByNameSurname(getClients(), clientName, clientSurName).get(0);

        System.out.println("Дебитовые счета: ");

        for (Account debitAccount : tempClient.getDebitAccounts()) {
            System.out.printf("Номер счёта: %d , Сумма на счёте: %f", debitAccount.getNumber(), debitAccount.getAmount());
        }

        System.out.println("Кредитные счета: ");

        for (Account creditAccount : tempClient.getCreditAccounts()) {
            System.out.printf("Номер счёта: %d , Сумма на счёте: %f", creditAccount.getNumber(), creditAccount.getAmount());
        }

        System.out.println("Депозитные счета: ");

        for (Account depositAccount : tempClient.getDepositAccounts()) {
            System.out.printf("Номер счёта: %d , Сумма на счёте: %f", depositAccount.getNumber(), depositAccount.getAmount());
        }
    }
}
