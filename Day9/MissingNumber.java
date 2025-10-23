package Day9;
import java.util.Scanner;

class MissingNumber {
    public int findMissingNumber(int[] arr, int n) {
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;

        for (int element : arr) {
            actualSum += element;
        }

        return (int) (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MissingNumber solver = new MissingNumber();

        System.out.print("Enter the value of N (the range is 1 to N): ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input for N. Exiting.");
            scanner.close();
            return;
        }

        if (n <= 1) {
            System.out.println("N must be greater than 1. Exiting.");
            scanner.close();
            return;
        }

        int arraySize = n - 1;
        int[] arr = new int[arraySize];

        System.out.println("Enter " + arraySize + " distinct integer elements (between 1 and " + n + "):");
        for (int i = 0; i < arraySize; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for element " + (i + 1) + ". Exiting.");
                scanner.close();
                return;
            }
        }

        int missingNumber = solver.findMissingNumber(arr, n);

        System.out.println("The missing number is: " + missingNumber);

        scanner.close();
    }
}