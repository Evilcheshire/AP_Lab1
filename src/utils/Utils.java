package utils;

/**
 * Class for utilities
 * */

public class Utils {

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