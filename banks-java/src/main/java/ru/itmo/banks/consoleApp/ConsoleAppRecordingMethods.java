package ru.itmo.banks.consoleApp;

import java.io.Console;

public class ConsoleAppRecordingMethods {

    private final Console console = System.console();

    public String consoleToString(String temp) {
        console.printf(temp);
        return console.readLine();
    }

    public int consoleToInt(String temp) {
        console.printf(temp);
        return Integer.parseInt(console.readLine());
    }
}
