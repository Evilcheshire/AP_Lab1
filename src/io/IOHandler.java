package io;

import fibnumber.FibNumber;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class for input and output
 * */

public class IOHandler {
    private Scanner sc;

    /** Constructor
     * */
    public IOHandler() {
        sc = new Scanner(System.in);
    }
    /** Method that grants accurate input
     *
     * @return n The amount of Fibonacci numbers to be generated
     * */
    public int getFibCount() {
        int n = 0;
        while (true) {
            System.out.println("Enter the amount of Fibonacci numbers to be generated (N, non-negative integer and non-zero): ");
            try {
                n = sc.nextInt();
                if (n < 1)
                    System.out.println("Error: N must be a non-negative integer and and non-zero. Please try again.");
                else
                    break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid non-negative integer.");
                sc.next();
            }
        }
        return n;
    }

    /** Method to display the result
     *
     * @param n The amount of Fibonacci numbers
     * */
    public void displayResults(int n) {
        System.out.println("Checking if generated Fibonacci numbers("+n+") are squares:");

        long f1 = 0, f2 = 1, fn = 0;

        for (int i=0; i<n; i++) {
            FibNumber fibNumber = new FibNumber(i, f1);
            System.out.print(fibNumber.toString());
            if (fibNumber.isSquare())
                System.out.print(" -> is square;\n");
            else
                System.out.print(" -> is not square;\n");
            fn = f1+f2;
            f1 = f2;
            f2 = fn;
        }
    }

    /** Method to close the scanner
     * */
    public void close() {
        sc.close();
    }
}
