import java.util.Scanner;

public class KthMissingPositive {

    public static int findKthPositive(int[] vec, int k) {
        int n = vec.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingCount = vec[mid] - (mid + 1);

            if (missingCount < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (high == -1) {
            return k;
        }

        int missingCountBefore = vec[high] - (high + 1);
        int remaining = k - missingCountBefore;
        return vec[high] + remaining;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] vec = new int[n];
        for (int i = 0; i < n; i++) {
            vec[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        int result = findKthPositive(vec, k);
        System.out.println(result);
        
        scanner.close();
    }
}