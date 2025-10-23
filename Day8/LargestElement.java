import java.util.Scanner;

class LargestElement {
    public int findLargestElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LargestElement solver = new LargestElement();

        System.out.print("Enter the number of elements in the array: ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input for size. Exiting.");
            scanner.close();
            return;
        }

        if (n <= 0) {
            System.out.println("Size must be a positive integer. Exiting.");
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

        int largest = solver.findLargestElement(arr);

        System.out.println("The largest element is: " + largest);

        scanner.close();
    }
}