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

    /** Method to generate the next Fibonacci number
     *
     * @param f1 - f(i-2), where <i>i</i> is index of the next Fibonacci number
     * @param f2 - f(i-1)
     * @return f1+f2 = fn - the next Fibonacci number
     * */
    public static long nextFibNumber(long f1, long f2) {
        return f1 + f2;
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
     * */
    public void displayResults(int n) {
        System.out.println("Checking if generated Fibonacci numbers("+n+") are squares:");

        long f1 = 0, f2 = 1, fn = 0;

        for (int i=0; i<n; i++) {
            FibNumber fibNumber = new FibNumber(i, f1);
            System.out.print(fibNumber.toString());
            if (Utils.isSquare(fibNumber.getValue()))
                System.out.print(" -> is square;\n");
            else
                System.out.print(" -> is not square;\n");
            fn = Utils.nextFibNumber(f1, f2);
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