import java.util.Scanner;

class CheckSorted {
    public boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckSorted checker = new CheckSorted();

        System.out.print("Enter the number of elements in the array: ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("false");
            scanner.close();
            return;
        }

        if (n <= 0) {
            System.out.println("true");
            scanner.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integer elements:");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Exiting.");
                scanner.close();
                return;
            }
        }

        boolean sorted = checker.isSorted(arr);

        System.out.println(sorted);

        scanner.close();
    }
}