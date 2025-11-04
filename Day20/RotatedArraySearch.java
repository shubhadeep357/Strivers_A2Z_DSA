import java.util.Scanner;
import java.util.Arrays;

class RotatedArraySearch {
    public static boolean search(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return true;
            }

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] < k && k <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array (N):");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the rotated sorted array, separated by space (e.g., 4 5 6 7 0 1 2):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the target value (k) to search for:");
        int k = scanner.nextInt();

        System.out.println("\n--- Search Result ---");
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target (k): " + k);

        boolean isPresent = search(arr, k);
        
        System.out.println("Result: " + (isPresent ? "True" : "False"));
        System.out.println("The target " + k + (isPresent ? " is present" : " is NOT present") + " in the array.");

        scanner.close();
    }
}
