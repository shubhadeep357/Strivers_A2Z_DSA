import java.util.Scanner;

public class StringRotation {
    public boolean canRotate(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.isEmpty()) {
            return true;
        }

        String doubledS = s + s;
        return doubledS.contains(goal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String goal = scanner.nextLine();

        StringRotation solution = new StringRotation();
        boolean result = solution.canRotate(s, goal);

        System.out.println(result);

        scanner.close();
    }
}