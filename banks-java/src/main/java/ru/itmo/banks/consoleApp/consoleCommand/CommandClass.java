package ru.itmo.banks.consoleApp.consoleCommand;

import ru.itmo.banks.CentralBank;
import ru.itmo.banks.Client;
import ru.itmo.banks.consoleApp.ConsoleAppRecordingMethods;
import ru.itmo.banks.consoleApp.consoleSweep.CreateSubtypes;
import ru.itmo.banks.consoleApp.consoleSweep.FindSubtypes;
import ru.itmo.banks.consoleApp.consoleSweep.OutputSubtypes;
import ru.itmo.banks.consoleApp.consoleSweep.ShowSubtypes;
import ru.itmo.banks.transmittedParameter.BankParameters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandClass {
    private final ConsoleAppRecordingMethods consoleApp;
    private final List<CentralBank> centralBanks;
    private final List<BankParameters> templateParametersForCreatingBank;
    private final List<Client> clients;
    private final CreateSubtypes createSubtypes;
    private final FindSubtypes findSubtypes;
    private final OutputSubtypes outputSubtypes;
    private final ShowSubtypes showSubtypes;

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
        return Collections.unmodifiableList(centralBanks);
    }

    public List<BankParameters> getTemplateParametersForCreatingBank() {
        return templateParametersForCreatingBank;
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void command() {
    }
}
