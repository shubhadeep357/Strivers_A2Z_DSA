import java.util.Scanner;

public class CheckPalindrome {

    public static boolean isPalindrome(int n) {
        if (n < 0 || (n != 0 && n % 10 == 0)) {
            return false;
        }
        int reversedHalf = 0;
        while (n > reversedHalf) {
            reversedHalf = reversedHalf * 10 + (n % 10);
            n = n / 10;
        }
        return (n == reversedHalf) || (n == reversedHalf / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer to check: ");
        int number = scanner.nextInt();
        if (isPalindrome(number)) {
            System.out.println(number + " is a palindrome.");
        } else {
            System.out.println(number + " is not a palindrome.");
        }
        scanner.close();
    }
}