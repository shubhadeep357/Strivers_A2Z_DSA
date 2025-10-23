import java.util.Scanner;

class RemoveDuplicates {
    public int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoveDuplicates solver = new RemoveDuplicates();

        System.out.print("Enter the number of elements in the sorted array: ");
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

        System.out.println("Enter " + n + " integer elements in non-decreasing order:");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for element. Exiting.");
                scanner.close();
                return;
            }
        }

        int k = solver.removeDuplicates(arr);

        System.out.println("Number of unique elements (k): " + k);
        System.out.print("Array after removing duplicates (first " + k + " elements): [");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + (i < k - 1 ? ", " : ""));
        }
        System.out.println("]");

        scanner.close();
    }
}