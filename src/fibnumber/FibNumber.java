package fibnumber;

/**
 * This class is for Fibonacci numbers
 * It has a constructor and methods to access number's index and value.
 * There is also a method to display number as a string (<i>public String toString()</i>)
 * */

public class FibNumber {
    private int index;
    private long value;

    /** Constructor
     *
     * @param index Index of Fibonacci number
     * @param value Value of Fibonacci number
     * */
    public FibNumber (int index, long value){
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

    public boolean isSquare() {
        long sqrt = (long) Math.sqrt(this.getValue());
        return sqrt * sqrt == this.getValue();
    }


    /** Method to display a number
     *
     * @return A string of this type: F(index) = value
     * */
    public String toString() {
        return "F(" + index + ") = " + value;
    }
}