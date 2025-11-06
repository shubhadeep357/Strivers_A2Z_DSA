import java.util.Scanner;

public class SmallestDivisor {

    private static int calculateSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }

    public static int smallestDivisor(int[] arr, int limit) {
        int maxVal = 0;
        for (int num : arr) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int low = 1;
        int high = maxVal;
        int result = maxVal;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentSum = calculateSum(arr, mid);

            if (currentSum <= limit) {
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

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int limit = scanner.nextInt();

        int result = smallestDivisor(arr, limit);
        System.out.println(result);
        
        scanner.close();
    }
}