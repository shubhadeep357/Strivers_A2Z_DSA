package Day9;
import java.util.Scanner;

class SingleNumber {
    public int findSingleNumber(int[] arr) {
        int result = 0;
        for (int element : arr) {
            result = result ^ element;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SingleNumber solver = new SingleNumber();

        System.out.print("Enter the number of elements in the array (must be odd, e.g., 3, 5, 7...): ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input for size. Exiting.");
            scanner.close();
            return;
        }

        if (n <= 0 || n % 2 == 0) {
            System.out.println("Size must be a positive odd number. Exiting.");
            scanner.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integer elements (where one number appears once and others appear twice):");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for element. Exiting.");
                scanner.close();
                return;
            }
        }

        int singleNumber = solver.findSingleNumber(arr);

        System.out.println("The single unique number is: " + singleNumber);

        scanner.close();
    }
}