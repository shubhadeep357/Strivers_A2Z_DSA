import java.util.Scanner;

public class CountDigits {

    public static int countDigits(int n) {
        if (n == 0) return 1;
        int count = 0;
        n = Math.abs(n); // Handle negative numbers
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        System.out.println("Number of digits: " + countDigits(number));
        scanner.close();
    }
}