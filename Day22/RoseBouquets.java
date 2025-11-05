import java.util.Scanner;

public class RoseBouquets {
    public static long getBouquets(int[] arr, int day, int k) {
        long bouquets = 0;
        int adjacentBloomed = 0;
        for (int bloomDay : arr) {
            if (bloomDay <= day) {
                adjacentBloomed++;
                if (adjacentBloomed == k) {
                    bouquets++;
                    adjacentBloomed = 0;
                }
            } else {
                adjacentBloomed = 0;
            }
        }
        return bouquets;
    }

    public static int minDays(int[] arr, int k, int m) {
        if (arr.length < (long) k * m) {
            return -1;
        }

        int minDay = arr[0];
        int maxDay = arr[0];
        for (int day : arr) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        int low = minDay;
        int high = maxDay;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (getBouquets(arr, mid, k) >= m) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            int m = scanner.nextInt();

            if (k <= 0 || m <= 0) {
                System.out.println("-1");
                return;
            }

            int result = minDays(arr, k, m);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("-1");
        } finally {
            scanner.close();
        }
    }
}