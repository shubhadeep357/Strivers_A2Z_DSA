import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class PrintDivisors {

    public static void printAllDivisors(int n) {
        if (n <= 0) return;
        System.out.print("Divisors of " + n + ": ");
        ArrayList<Integer> secondHalf = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i * i != n) {
                    secondHalf.add(n / i);
                }
            }
        }
        Collections.reverse(secondHalf);
        for (int divisor : secondHalf) {
            System.out.print(divisor + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        printAllDivisors(number);
        scanner.close();
    }
}