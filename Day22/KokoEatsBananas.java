import java.util.Scanner;
import java.util.Arrays;

public class KokoEatsBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int minK = high;

        while (low <= high) {
            int k = low + (high - low) / 2;
            if (k == 0) return 1;

            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (long) (pile + k - 1) / k;
                if (totalTime > h) break;
            }

            if (totalTime <= h) {
                minK = k;
                high = k - 1;
            } else {
                low = k + 1;
            }
        }
        return minK;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int n = scanner.nextInt();
            int[] piles = new int[n];
            for (int i = 0; i < n; i++) {
                piles[i] = scanner.nextInt();
            }
            int h = scanner.nextInt();

            if (n <= 0 || h <= 0 || piles.length != n) {
                System.out.println("Invalid input: Array size or time must be positive.");
                return;
            }

            int result = minEatingSpeed(piles, h);
            System.out.println(result);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please ensure all inputs are integers.");
        } catch (NegativeArraySizeException e) {
            System.out.println("Invalid input. The number of piles cannot be negative.");
        } finally {
            scanner.close();
        }
    }
}