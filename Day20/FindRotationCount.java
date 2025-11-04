import java.util.Arrays;
import java.util.Scanner;

class FindRotationCount {
    public static int findRotationCount(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int low = 0;
        int high = n - 1;

        if (arr[low] <= arr[high]) {
            return low;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
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
            System.out.println("Rotation Count: 0 (Empty array)");
        } else {
            int rotationCount = findRotationCount(arr);
            System.out.println("Rotation Count: " + rotationCount);
            System.out.println("The array has been rotated " + rotationCount + " times.");
        }

        scanner.close();
    }
}
