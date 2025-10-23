import java.util.Arrays;
import java.util.Scanner;

class MoveZeros {
    public void moveZerosToEnd(int[] arr) {
        int n = arr.length;
        int nonZeroIndex = 0;

        // Iterate through the array. If the current element is non-zero,
        // swap it with the element at nonZeroIndex and increment nonZeroIndex.
        // This effectively places all non-zero elements at the front in their original order.
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                // Only perform the swap if the non-zero element is not already at its correct place
                if (i != nonZeroIndex) {
                    arr[nonZeroIndex] = arr[i];
                }
                nonZeroIndex++;
            }
        }
        
        // After the first loop, nonZeroIndex points to the first position where a zero should be.
        // Fill the rest of the array (from nonZeroIndex to the end) with zeros.
        for (int i = nonZeroIndex; i < n; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MoveZeros solver = new MoveZeros();

        System.out.print("Enter the number of elements in the array: ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input for size. Exiting.");
            scanner.close();
            return;
        }

        if (n < 0) {
            System.out.println("Size must be non-negative. Exiting.");
            scanner.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integer elements:");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for element. Exiting.");
                scanner.close();
                return;
            }
        }

        solver.moveZerosToEnd(arr);

        System.out.println("Array after moving zeros: " + Arrays.toString(arr));

        scanner.close();
    }
}