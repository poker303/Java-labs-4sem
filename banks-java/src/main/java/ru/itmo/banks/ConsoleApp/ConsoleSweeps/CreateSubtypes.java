package ru.itmo.banks.ConsoleApp.ConsoleSweeps;

import ru.itmo.banks.CentralBank;
import ru.itmo.banks.TransmittedParameters.BankParameters;

import java.util.List;
import java.util.Objects;

public class CreateSubtypes {

    public static CentralBank createCentralBank(List<CentralBank> centralBanks, String centralBankName, String centralBankCountry) {
        var centralBank = new CentralBank(centralBankName, centralBankCountry);
        centralBanks.add(centralBank);
        return centralBank;
    }

    public static void createBank(List<BankParameters> bankParameters, List<CentralBank> centralBanks, String centralBankName, int bankTemplateNumber) {
        for (CentralBank centralBank : centralBanks) {
            if (Objects.equals(centralBank.getName(), centralBankName)) {
                centralBank.createBank(bankParameters.get(bankTemplateNumber));
            }
        }
    }
}
