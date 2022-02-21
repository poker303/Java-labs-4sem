package ru.itmo.banks.Banks;

import org.junit.jupiter.api.Test;
import ru.itmo.banks.*;
import ru.itmo.banks.Accounts.CreditAccount;
import ru.itmo.banks.Accounts.DebitAccount;
import ru.itmo.banks.Accounts.DepositAccount;
import ru.itmo.banks.Exceptions.BanksExceptions;
import ru.itmo.banks.TransmittedParameters.BankParameters;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankTest {

    private final CentralBank centralBank = new CentralBank("ЦБ", "Россия");

    @Test
    public void createBanksAddClientsCreateAddAccounts() throws BanksExceptions {
        ArrayList<Integer> boundarySums1 = new ArrayList<>(Arrays.asList(0, 50000, 100000, 150000, 200000));
        ArrayList<Integer> boundarySums2 = new ArrayList<>(Arrays.asList(0, 100000, 200000, 300000));

        ArrayList<Integer> percents1 = new ArrayList<>(Arrays.asList(4, 6, 8, 10));
        ArrayList<Integer> percents2 = new ArrayList<>(Arrays.asList(4, 8, 12));

        var table1 = new AmountPercentPair(boundarySums1, percents1);
        var table2 = new AmountPercentPair(boundarySums2, percents2);

        var bankParameters1 = new BankParameters("Сбербанк", table1, 100000, 6, 0, 0, 20, 0, 100000);
        var bankParameters2 = new BankParameters("Тинькофф", table2, 100000, 8, 0, 0, 10, 0, 100000);

        Bank bank1 = centralBank.createBank(bankParameters1);
        Bank bank2 = centralBank.createBank(bankParameters2);

        assertEquals(2, centralBank.getBanks().size());

        var client1 = new Client("Алексей", "Иванов", 500000);
        var client2 = new Client("Сергей", "Иванов", 200000);
        var client3 = new Client("Даниил", "Титов", 50000);

        bank1.addClients(new ArrayList<>(List.of(client1)));
        bank2.addClients(new ArrayList<>(List.of(client2, client3)));

        assertEquals(1, bank1.getClients().size());
        assertEquals(2, bank2.getClients().size());

        CreditAccount account1 = bank1.createCreditAccount(client2, 100000, LocalDate.of(2020, 12, 12), 180);
        DebitAccount account2 = bank2.createDebitAccount(client1, 200000, LocalDate.of(2020, 12, 12), 180);
        DepositAccount account3 = bank2.createDepositAccount(client3, 40000, LocalDate.of(2020, 12, 12), 180);

        assertTrue(bank1.getCreditAccounts().contains(account1));
        assertTrue(bank2.getDebitAccounts().contains(account2));
        assertTrue(bank2.getDepositAccounts().contains(account3));

        assertTrue(client2.getCreditAccounts().contains(account1));
        assertTrue(client1.getDebitAccounts().contains(account2));
        assertTrue(client3.getDepositAccounts().contains(account3));
    }

    @Test
    public void checkingTheOperabilityOfOperations() throws BanksExceptions {
        ArrayList<Integer> boundarySums1 = new ArrayList<>(Arrays.asList(0, 50000, 100000, 150000, 200000));
        ArrayList<Integer> boundarySums2 = new ArrayList<>(Arrays.asList(0, 100000, 200000, 300000));

        ArrayList<Integer> percents1 = new ArrayList<>(Arrays.asList(4, 6, 8, 10));
        ArrayList<Integer> percents2 = new ArrayList<>(Arrays.asList(4, 8, 12));

        var table1 = new AmountPercentPair(boundarySums1, percents1);
        var table2 = new AmountPercentPair(boundarySums2, percents2);

        var bankParameters1 = new BankParameters("Сбербанк", table1, 50000, 6, 0, 0, 20, 0, 100000);
        var bankParameters2 = new BankParameters("Тинькофф", table2, 50000, 10, 0, 0, 10, 0, 100000);

        Bank bank1 = centralBank.createBank(bankParameters1);
        Bank bank2 = centralBank.createBank(bankParameters2);

        var client1 = new Client("Алексей", "Иванов", 500000);
        var client2 = new Client("Сергей", "Иванов", 200000);
        var client3 = new Client("Даниил", "Титов", 50000);

        bank1.addClients(new ArrayList<>(List.of(client1)));
        bank2.addClients(new ArrayList<>(List.of(client2, client3)));

        CreditAccount account1 = bank1.createCreditAccount(client2, 100000, LocalDate.of(2020, 12, 12), 180);
        DebitAccount account2 = bank2.createDebitAccount(client1, 200000, LocalDate.of(2020, 12, 12), 180);
        DepositAccount account3 = bank2.createDepositAccount(client3, 40000, LocalDate.of(2020, 12, 12), 180);

        bank1.withdrawal(10000, account1, LocalDate.of(2020, 12, 15));
        assertEquals(90000, account1.getAmount());
        bank1.replenishment(10000, account1, LocalDate.of(2020, 12, 18));
        assertEquals(100000, account1.getAmount());

        client2.addAddress("Озеро Чемиге");
        client2.addPassportNumber("999768 5012");
        bank1.clientAccountsUpdate(client2, LocalDate.of(2021, 1, 10));

        bank1.withdrawal(110000, account1, LocalDate.of(2021, 1, 15));
        assertEquals(-10000, account1.getAmount());
        bank1.replenishment(100000, account1, LocalDate.of(2021, 1, 28));

        centralBank.transfer(20000, account1, account2, bank1, bank2, LocalDate.of(2021, 2, 2));

        assertEquals(70000, account1.getAmount());
        assertEquals(220000, account2.getAmount());

        centralBank.сancellationOfTheTransaction(0);

        assertEquals(90000, account1.getAmount());
        assertEquals(200000, account2.getAmount());

        var tempTime = LocalDate.of(2021, 10, 24);
        centralBank.transfer(20000, account3, account2, bank2, tempTime);


        assertEquals(20000, account3.getAmount());
        assertEquals(220000, account2.getAmount());

        assertEquals(10, account2.getPercent());

        centralBank.notification(LocalDate.of(2021, 1, 12));
        assertEquals(221876.19226510564d, account2.getAmount());

        var timeRewinder1 = new TimeRewinder("timeRewinder1");
        var time1 = LocalDate.of(2020, 12, 12);
        var time2 = LocalDate.of(2021, 1, 12);
        assertEquals(time2, timeRewinder1.rewindTime(time1, time1.plusDays(31)));

        client1.changeSubscriptionDesire(true);
        bank2.attachObserver(client1);
        bank2.changeDebitAccountOptions(account2, 20, account2.getCommission());
        assertEquals(1, client1.getNotifications().size());
    }
}
