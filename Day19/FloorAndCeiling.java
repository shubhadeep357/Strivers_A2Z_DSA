import java.util.Arrays;

public class FloorAndCeiling {

    // Function to find the floor of x (largest element <= x)
    private int findFloor(int[] arr, int x) {
        int floor = -1; // Sentinel value if no floor is found
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                // Potential floor found, store it and look for a larger floor in the right half
                floor = arr[mid];
                low = mid + 1;
            } else {
                // arr[mid] is too large, discard the right half
                high = mid - 1;
            }
        }
        return floor;
    }

    // Function to find the ceiling of x (smallest element >= x)
    private int findCeil(int[] arr, int x) {
        int ceil = -1; // Sentinel value if no ceiling is found
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                // Potential ceiling found, store it and look for a smaller ceiling in the left half
                ceil = arr[mid];
                high = mid - 1;
            } else {
                // arr[mid] is too small, discard the left half
                low = mid + 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        FloorAndCeiling solver = new FloorAndCeiling();
        int[] arr = {3, 4, 7, 8, 8, 10, 13};

        // Example 1: Target present (8)
        int x1 = 8;
        System.out.println("Array: " + Arrays.toString(arr) + ", Target: " + x1);
        System.out.println("Floor of " + x1 + ": " + solver.findFloor(arr, x1));
        System.out.println("Ceiling of " + x1 + ": " + solver.findCeil(arr, x1));

        // Example 2: Target not present (5)
        int x2 = 5;
        System.out.println("\nArray: " + Arrays.toString(arr) + ", Target: " + x2);
        System.out.println("Floor of " + x2 + ": " + solver.findFloor(arr, x2));
        System.out.println("Ceiling of " + x2 + ": " + solver.findCeil(arr, x2));
        
        // Example 3: Target smaller than all elements (2)
        int x3 = 2;
        System.out.println("\nArray: " + Arrays.toString(arr) + ", Target: " + x3);
        System.out.println("Floor of " + x3 + ": " + solver.findFloor(arr, x3)); // Expected: -1
        System.out.println("Ceiling of " + x3 + ": " + solver.findCeil(arr, x3)); // Expected: 3

        // Example 4: Target larger than all elements (15)
        int x4 = 15;
        System.out.println("\nArray: " + Arrays.toString(arr) + ", Target: " + x4);
        System.out.println("Floor of " + x4 + ": " + solver.findFloor(arr, x4)); // Expected: 13
        System.out.println("Ceiling of " + x4 + ": " + solver.findCeil(arr, x4)); // Expected: -1
    }
}
