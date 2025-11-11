import java.util.Scanner;

public class AnagramChecker {
    public boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] counts = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)]++;
            counts[s2.charAt(i)]--;
        }

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String t = scanner.nextLine();

        AnagramChecker solution = new AnagramChecker();
        boolean result = solution.check(s, t);

        System.out.println(result);

        scanner.close();
    }
}