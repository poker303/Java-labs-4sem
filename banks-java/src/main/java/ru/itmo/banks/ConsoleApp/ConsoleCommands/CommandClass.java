package ru.itmo.banks.ConsoleApp.ConsoleCommands;

import ru.itmo.banks.CentralBank;
import ru.itmo.banks.Client;
import ru.itmo.banks.ConsoleApp.ConsoleAppRecordingMethods;
import ru.itmo.banks.ConsoleApp.ConsoleSweeps.*;
import ru.itmo.banks.Exceptions.BanksExceptions;
import ru.itmo.banks.TransmittedParameters.BankParameters;

import java.util.ArrayList;
import java.util.List;

public class CommandClass {
    public CommandClass() {
        consoleApp = new ConsoleAppRecordingMethods();

        centralBanks = new ArrayList<>();
        templateParametersForCreatingBank = new ArrayList<>();
        clients = new ArrayList<>();

        createSubtypes = new CreateSubtypes();
        findSubtypes = new FindSubtypes();
        outputSubtypes = new OutputSubtypes();
        showSubtypes = new ShowSubtypes();
    }

    protected ConsoleAppRecordingMethods consoleApp;

    protected List<CentralBank> centralBanks;

    protected List<BankParameters> templateParametersForCreatingBank;

    protected List<Client> clients;


    protected CreateSubtypes createSubtypes;

    protected FindSubtypes findSubtypes;

    protected OutputSubtypes outputSubtypes;

    protected ShowSubtypes showSubtypes;

    public CreateSubtypes getCreateSubtypes() {
        return createSubtypes;
    }

    public FindSubtypes getFindSubtypes() {
        return findSubtypes;
    }

    public OutputSubtypes getOutputSubtypes() {
        return outputSubtypes;
    }

    public ShowSubtypes getShowSubtypes() {
        return showSubtypes;
    }

    public ConsoleAppRecordingMethods getConsoleApp() {
        return consoleApp;
    }

    public List<CentralBank> getCentralBanks() {
        return centralBanks;
    }

    public List<BankParameters> getTemplateParametersForCreatingBank() {
        return templateParametersForCreatingBank;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void command() throws BanksExceptions {
    }
}
