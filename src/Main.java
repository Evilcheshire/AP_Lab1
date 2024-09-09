import java.util.Scanner;
import java.util.InputMismatchException;
// клас для числа Фібоначчі
class FibNumber {
    private long index, // порядковий номер числа
                 value; // його значення

    // консруктор класу
    public FibNumber (long index, long value){
        this.index = index;
        this.value = value;
    }

    // метод доступу до індекса
    public long getIndex(){
        return index;
    }

    // метод доступу до значення
    public long getValue(){
        return value;
    }

    // метод для перетворення числа в символьний рядок типу "F(index) = value"
    public String toString() {
        return "F(" + index + ") = " + value;
    }
}

// клас для допоміжних методів (генерація й перевірка)
class Utils {
    // метод для перевірки того, чи є число Фібоначі квадратом
    public static boolean isSquare(long number) {
        long sqrt = (long) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    // метод для генерації n чисел Фібоначчі
    public static FibNumber[] generateFibNumber(int n) {
        FibNumber[] fibNumbers = new FibNumber[n]; // масив об'єктив чисел Фібоначчі
        long f1 = 0, f2 = 1; // перші два числа Фібоначчі

        //цикл для генерації чисел
        for (int i = 0; i < n; i++) {
            fibNumbers[i] = new FibNumber (i, f1); // додавання об'єкту в масив
            long fn = f1 + f2; // обчислення наступного числа Фібоначчі
            f1 = f2;
            f2 = fn;
        }
        return fibNumbers; // метод повертає згенерований масив з об'єктами
    }
}

class IOHandler {
    private Scanner sc;

    public IOHandler() {
        sc = new Scanner(System.in);
    }

    // метод для отримання кількості чисел Фібоначчі
    public int getFibCount() {
        int n = 0;
        while (true) {
            System.out.println("Enter the amount of Fibonacci numbers to be generated (N, non-negative integer): ");
            try {
                n = sc.nextInt();
                if (n < 0)
                    System.out.println("Error: N must be a non-negative integer. Please try again.");
                else
                    break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid non-negative integer.");
                sc.next();
            }
        }
        return n;
    }

    // метод для виведення результатів
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

    public void close() {
        sc.close();
    }
}

// головний клас програми
public class Main {
    public static void main(String[] args) {
        IOHandler ioHandler = new IOHandler(); // створення об'єкта для введення/виведення

        // отримання кількості чисел для генерації
        int n = ioHandler.getFibCount();

        // генерація чисел Фібоначчі
        FibNumber[] fibNumbers = Utils.generateFibNumber(n);

        // виведення результатів
        ioHandler.displayResults(fibNumbers, n);

        ioHandler.close();
    }
}