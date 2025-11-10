import java.util.Scanner;

class LargestOddNumber {
    public String largestOddNumber(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            char digit = s.charAt(i);
            int value = digit - '0';

            if (value % 2 != 0) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a large integer string (e.g., 52048):");
            String input = scanner.nextLine();

            LargestOddNumber solution = new LargestOddNumber();
            String output = solution.largestOddNumber(input);

            if (output.isEmpty()) {
                System.out.println("No odd substring found.");
            } else {
                System.out.println("Largest odd integer substring:");
                System.out.println(output);
            }
        }
    }
}