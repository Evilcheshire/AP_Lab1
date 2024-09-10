import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class is for Fibonacci numbers
 * It has a constructor and methods to access number's index and value.
 * There is also a method to display number as a string (<i>public String toString()</i>)
 * */

class FibNumber {
    private long index,
                 value;

    /** Constructor
     *
     * @param index Index of Fibonacci number
     * @param value Value of Fibonacci number
     * */
    public FibNumber (long index, long value){
        this.index = index;
        this.value = value;
    }

    /** Method to access the index of Fibonacci number(isn't used in the program though)
     * */
    public long getIndex(){
        return index;
    }
    /** Method to access the value of Fibonacci number
     * */
    public long getValue(){
        return value;
    }

    /** Method to display a number
     *
     * @return A string of this type: F(index) = value
     * */
    public String toString() {
        return "F(" + index + ") = " + value;
    }
}

/**
 * Class for utilities
 * */

class Utils {

    /** Method to check if this Fibonacci number is a square of a natural number
     *
     * @param number The number to be checked
     * @return If the square of square roots of this number equals the number itself the result is <i>true</i>
     * */
    public static boolean isSquare(long number) {
        long sqrt = (long) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    /** Method to check if this Fibonacci number is a square of a natural number
     *
     * @param n The amount of Fibonacci numbers to be generated
     * @return An array (<i>fibNumbers</i>) of generated Fibonacci numbers (including 0)
     * */
    public static FibNumber[] generateFibNumber(int n) {
        FibNumber[] fibNumbers = new FibNumber[n];
        long f1 = 0, f2 = 1;

        for (int i = 0; i < n; i++) {
            fibNumbers[i] = new FibNumber (i, f1);
            long fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fibNumbers;
    }
}

/**
 * Class for input and output
 * */

class IOHandler {
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
     * @param fibNumbers The array of generated numbers
     * */
    public void displayResults(FibNumber[] fibNumbers, int n) {
        System.out.println("Checking if generated Fibonacci numbers("+n+") are squares:");
        for (FibNumber fibNumber : fibNumbers) {
            System.out.print(fibNumber);
            if (Utils.isSquare(fibNumber.getValue()))
                System.out.print(" -> is square;\n");
            else
                System.out.print(" -> is not square;\n");
        }
    }

    /** Method to close the scanner
     * */
    public void close() {
        sc.close();
    }
}

/**
 * Main class with I/O, generated array of Fibonacci numbers and with the result of the check
 * */

public class Main {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler();

        int n = ioHandler.getFibCount();

        FibNumber[] fibNumbers = Utils.generateFibNumber(n);

        ioHandler.displayResults(fibNumbers, n);

        ioHandler.close();
    }
}