import java.util.Arrays;
import java.util.Scanner;

class ArrayRotation {
    
    // Function to reverse a segment of the array
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Rotates the array to the left by k positions
    public void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;
        
        // Ensure k is within the bounds of the array length
        k = k % n;
        if (k == 0) return;

        // The three steps of the Juggling/Reversal algorithm for left rotation:
        // 1. Reverse the first k elements
        reverse(arr, 0, k - 1);
        
        // 2. Reverse the remaining n - k elements
        reverse(arr, k, n - 1);
        
        // 3. Reverse the whole array
        reverse(arr, 0, n - 1);
    }

    // Rotates the array to the right by k positions
    public void rotateRight(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;
        
        // Right rotation by k is equivalent to left rotation by n - k
        int effectiveLeftRotations = n - (k % n);
        
        rotateLeft(arr, effectiveLeftRotations);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayRotation rotator = new ArrayRotation();

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

        System.out.print("Enter the number of steps to rotate (k): ");
        int k = 0;
        if (scanner.hasNextInt()) {
            k = scanner.nextInt();
        } else {
            System.out.println("Invalid input for k. Exiting.");
            scanner.close();
            return;
        }
        
        if (n > 0) {
            // Create a copy for the right rotation test
            int[] arrCopy = Arrays.copyOf(arr, n);

            rotator.rotateLeft(arr, k);
            System.out.println("Left rotated array by " + k + " steps: " + Arrays.toString(arr));
            
            rotator.rotateRight(arrCopy, k);
            System.out.println("Right rotated array by " + k + " steps: " + Arrays.toString(arrCopy));
        } else {
            System.out.println("Array is empty. No rotation performed.");
        }

        scanner.close();
    }
}