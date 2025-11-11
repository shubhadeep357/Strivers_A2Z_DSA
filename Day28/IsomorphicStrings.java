import java.util.Scanner;

public class IsomorphicStrings {
    public boolean areIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sToT = new char[256];
        char[] tToS = new char[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (sToT[charS] == 0) {
                if (tToS[charT] != 0) {
                    return false;
                }
                sToT[charS] = charT;
                tToS[charT] = charS;
            } else {
                if (sToT[charS] != charT) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String t = scanner.nextLine();

        IsomorphicStrings solution = new IsomorphicStrings();
        boolean result = solution.areIsomorphic(s, t);

        System.out.println(result);

        scanner.close();
    }
}