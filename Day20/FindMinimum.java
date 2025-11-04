import java.util.Arrays;
import java.util.Scanner;

class FindMinimum {
    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        if (arr.length == 0) {
            return -1;
        }
        
        if (arr[low] <= arr[high]) {
            return arr[low];
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array (N):");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the distinct elements of the rotated sorted array, separated by space (e.g., 4 5 6 7 0 1 2):");
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input for array element. Exiting.");
                return;
            }
            arr[i] = scanner.nextInt();
        }

        System.out.println("\n--- Result ---");
        System.out.println("Input Array: " + Arrays.toString(arr));

        if (n == 0) {
            System.out.println("Minimum Element: Array is empty.");
        } else {
            int minimum = findMin(arr);
            System.out.println("Minimum Element: " + minimum);
        }

        scanner.close();
    }
}
