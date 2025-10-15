import java.util.Scanner;

public class ArmstrongNumber {

    public static boolean isArmstrong(int n) {
        if (n < 0) return false;
        int original = n;
        int sum = 0;
        int digits = String.valueOf(n).length();
        while (n > 0) {
            sum += Math.pow(n % 10, digits);
            n /= 10;
        }
        return sum == original;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int number = scanner.nextInt();
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        scanner.close();
    }
}