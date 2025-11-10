import java.util.Scanner;

class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    result.append(c);
                }
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a valid parentheses string (e.g., (()())(())):");
            String input = scanner.nextLine();

            RemoveOutermostParentheses solution = new RemoveOutermostParentheses();
            String output = solution.removeOuterParentheses(input);

            System.out.println("Resulting string after removal:");
            System.out.println(output);
        }
    }
}