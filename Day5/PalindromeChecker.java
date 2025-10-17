import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the string to check for palindrome:");
        String userInput = scanner.nextLine();
        
        boolean result = isPalindrome(userInput);
        
        System.out.println("Input: \"" + userInput + "\"");
        System.out.println("Output: " + (result ? "Palindrome" : "Not Palindrome")); 

        scanner.close();
    }
}
