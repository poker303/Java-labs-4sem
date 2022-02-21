package ru.itmo.banks.ConsoleApp.ConsoleSweeps;

import ru.itmo.banks.Client;

import java.io.Console;
import java.util.List;

public class OutputSubtypes {

    public static void output(String[] outputsElements) {
        for (String element : outputsElements) {
            System.out.println(element);
        }
    }

    public void output(Integer[] outputsElements) {
        for (int element : outputsElements) {
            System.out.printf("%d", element);
        }
    }

    public static void output(Client[] outputsElements) {
        for (Client element : outputsElements) {
            System.out.printf("Имя клиента: %s Фамилия клиента: %s \n", element.getName(), element.getSurname());
        }
    }
}
