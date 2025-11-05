import java.util.Scanner;

public class SquareRootFinder {
    public static int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int low = 1;
        int high = x;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long)mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Input must be a positive integer.");
                return;
            }
            int result = sqrt(n);
            System.out.println(result);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } finally {
            scanner.close();
        }
    }
}