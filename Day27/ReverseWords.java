import java.util.Scanner;

class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a string (e.g., 'the sky is blue'):");
            String input = scanner.nextLine();

            ReverseWords solution = new ReverseWords();
            String output = solution.reverseWords(input);

            System.out.println("Resulting string with words reversed:");
            System.out.println("'" + output + "'");
        }
    }
}