package com.project.goit.sieveoferatosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws NegativeValueException, IOException {
        return BUFFERED_READER.readLine();
    }

    public static int readPositiveInteger() throws IOException, NegativeValueException {
        try {
            int number = Integer.parseInt(BUFFERED_READER.readLine());
            if (number <= 0) {
                throw new NegativeValueException("You entered a negative number or zero, Try again!!!");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("You enter not number!Try again!!!");
        }
    }
}
