import java.util.Scanner;

public class ReverseNumber {

    public static int reverseNumber(int n) {
        long reversed = 0; // Use long to prevent overflow during calculation
        while (n != 0) {
            reversed = reversed * 10 + (n % 10);
            n = n / 10;
        }
        // Return 0 if the reversed number is outside integer range
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer to reverse: ");
        int number = scanner.nextInt();
        int result = reverseNumber(number);
        if (result == 0 && number != 0) {
            System.out.println("Reversing this number caused an overflow.");
        } else {
            System.out.println("Reversed number: " + result);
        }
        scanner.close();
    }
}