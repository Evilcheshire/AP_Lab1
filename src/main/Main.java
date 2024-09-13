package main;

import io.IOHandler;

/**
 * Main class with I/O and with the result of the check
 * */

public class Main {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();

        int n = ioHandler.getFibCount();

        ioHandler.displayResults(n);

        ioHandler.close();
    }
}