import java.util.Scanner;

public class ButterflyPattern {
    public static void main(String[] args) {
        int n = 5;

        // Upper half
        for (int i = 1; i <= n; i++) {
            System.out.print("*".repeat(i));
            System.out.print(" ".repeat(2 * (n - i)));
            System.out.println("*".repeat(i));
        }

        // Lower half
        for (int i = n; i >= 1; i--) {
            System.out.print("*".repeat(i));
            System.out.print(" ".repeat(2 * (n - i)));
            System.out.println("*".repeat(i));
        }
    }
}
