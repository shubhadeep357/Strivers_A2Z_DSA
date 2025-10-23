package Day9;
import java.util.Scanner;

class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] arr) {
        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currentCount++;
            } else {
                // Check if the sequence just ended is the new maximum
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
                // Reset counter for the new sequence
                currentCount = 0;
            }
        }

        // Final check in case the array ends with a sequence of ones
        if (currentCount > maxCount) {
            maxCount = currentCount;
        }

        return maxCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaxConsecutiveOnes solver = new MaxConsecutiveOnes();

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

        System.out.println("Enter " + n + " elements (only 0 or 1):");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input == 0 || input == 1) {
                    arr[i] = input;
                } else {
                    System.out.println("Invalid element. Only 0 or 1 allowed. Exiting.");
                    scanner.close();
                    return;
                }
            } else {
                System.out.println("Invalid input for element. Exiting.");
                scanner.close();
                return;
            }
        }

        int maxOnes = solver.findMaxConsecutiveOnes(arr);

        System.out.println("Maximum consecutive ones: " + maxOnes);

        scanner.close();
    }
}