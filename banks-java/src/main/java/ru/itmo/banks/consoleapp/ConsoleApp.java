package ru.itmo.banks.consoleapp;

import ru.itmo.banks.CentralBank;
import ru.itmo.banks.Client;
import ru.itmo.banks.consoleapp.consolecommand.CommandClass;
import ru.itmo.banks.consoleapp.consolecommand.command.*;
import ru.itmo.banks.consoleapp.consolesweep.FindSubtypes;

import java.util.*;

public class ConsoleApp {

    private final ConsoleAppRecordingMethods console = new ConsoleAppRecordingMethods();
    private final FindSubtypes findSubtypes = new FindSubtypes();
    private final CommandClass createCentralBank = new CreateCentralBank();
    private final CommandClass settingParametersToBank = new SettingParametersToBank();
    private final CommandClass createBank = new CreateBank();
    private final CommandClass createClient = new CreateClient();
    private final CommandClass createAccount = new CreateAccount();
    private final CommandClass showBanks = new ShowBanks();
    private final CommandClass showClientAccountsInfo = new ShowClientAccountsInfo();
    private final CommandClass showBankClients = new ShowBankClients();
    private final CommandClass showAccountAmountAfterTime = new ShowAccountAmountAfterTime();
    private final CommandClass accountWithdrawal = new AccountWithdrawal();
    private final CommandClass accountReplenishment = new AccountReplenishment();
    private final CommandClass transfer = new Transfer();
    private final CommandClass cancellationOfTheTransaction = new CancellationOfTheTransaction();
    private final CommandClass giveClientPermissionToSubscribe = new GiveClientPermissionToSubscribe();
    private final CommandClass signTheClientForUpdates = new SignTheClientForUpdates();
    private final CommandClass unsubscribeTheClientForUpdates = new UnsubscribeTheClientForUpdates();
    private final CommandClass changeDebitAccountOptions = new ChangeDebitAccountOptions();
    private final CommandClass chargeInterestAndCommissions = new ChargeInterestAndCommissions();
    private final List<CentralBank> centralBanks;
    private final List<Client> clients;
    private List<String> commands;

    public ConsoleApp() {
        clients = new ArrayList<>();
        centralBanks = new ArrayList<>();
        List<String> commands = new ArrayList<>(Arrays.asList(
                "CreateCentralBank",
                "SettingParametersToBank",
                "SettingTheAppendedAmounts",
                "SettingThePercents",
                "CreateBank",
                "CreateClient",
                "AddClientToTheBank",
                "CreateAccount",
                "ShowBanks",
                "ShowClientAccountsInfo",
                "ShowBankClients",
                "ShowAccountAmountAfterTime",
                "AccountWithdrawal",
                "AccountReplenishment",
                "Transfer",
                "CancellationOfTheTransaction",
                "GiveClientPermissionToSubscribe",
                "SignTheClientForUpdates",
                "UnsubscribeTheClientForUpdates",
                "ChangeDebitAccountOptions",
                "ChargeInterestAndCommissions",
                "Stop"
        ));
    }

    public void startConsole() {
        System.out.println("Hello 3-hundred bucks boys! \n");
        while (true) {
            Scanner in = new Scanner(System.in);
            String command = in.next();

            if (Objects.equals(command, "Stop")) {
                System.out.println("By boys, take care of your fingers. \n");
                break;
            }

            switch (command) {
                case "CreateCentralBank" -> createCentralBank.command();
                case "SettingParametersToBank" -> settingParametersToBank.command();
                case "CreateBank" -> createBank.command();
                case "CreateClient" -> createClient.command();
                case "AddClientToTheBank" -> {
                    String clientName1 = console.consoleToString("Введите имя клиента");
                    String clientSurName1 = console.consoleToString("Введите фамилию клиента");
                    String nameBank1 = console.consoleToString("Введите имя банка");
                    addClient(clientName1, clientSurName1, nameBank1);
                }
                case "CreateAccount" -> createAccount.command();
                case "ShowBanks" -> showBanks.command();
                case "ShowClientAccountsInfo" -> showClientAccountsInfo.command();
                case "ShowBankClients" -> showBankClients.command();
                case "ShowAccountAmountAfterTime" -> showAccountAmountAfterTime.command();
                case "AccountWithdrawal" -> accountWithdrawal.command();
                case "AccountReplenishment" -> accountReplenishment.command();
                case "Transfer" -> transfer.command();
                case "CancellationOfTheTransaction" -> cancellationOfTheTransaction.command();
                case "GiveClientPermissionToSubscribe" -> giveClientPermissionToSubscribe.command();
                case "SignTheClientForUpdates" -> signTheClientForUpdates.command();
                case "UnsubscribeTheClientForUpdates" -> unsubscribeTheClientForUpdates.command();
                case "ChangeDebitAccountOptions" -> changeDebitAccountOptions.command();
                case "ChargeInterestAndCommissions" -> chargeInterestAndCommissions.command();
            }
        }
    }

    private void addClient(String clientName, String clientSurName, String nameBank) {
        List<Client> addedClients = findSubtypes.findClientByNameSurname(clients, clientName, clientSurName);

        //addClients((ArrayList<Client>) addedClients
        findSubtypes.findBankByName(centralBanks, nameBank).addClients((ArrayList<Client>) addedClients);
    }
}
