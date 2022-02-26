package ru.itmo.banks.consoleApp.consoleSweep;

import ru.itmo.banks.Client;

public class OutputSubtypes {

    public static void output(String[] outputsElements) {
        for (String element : outputsElements) {
            System.out.println(element);
        }
    }

    public static void output(Client[] outputsElements) {
        for (Client element : outputsElements) {
            System.out.printf("Имя клиента: %s Фамилия клиента: %s \n", element.getName(), element.getSurname());
        }
    }

    public void output(Integer[] outputsElements) {
        for (int element : outputsElements) {
            System.out.printf("%d", element);
        }
    }
}
