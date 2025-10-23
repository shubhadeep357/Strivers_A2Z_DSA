package Day9;
import java.util.Scanner;

class SearchArray {
    public int findElement(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchArray searcher = new SearchArray();

        System.out.print("Enter the number of elements: ");
        int size = 0;
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
        } else {
            System.out.println("Invalid input for size. Exiting.");
            scanner.close();
            return;
        }

        if (size <= 0) {
            System.out.println("Array size must be positive. Exiting.");
            scanner.close();
            return;
        }

        int[] arr = new int[size];

        System.out.println("Enter " + size + " integer elements:");
        for (int i = 0; i < size; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for element " + (i + 1) + ". Exiting.");
                scanner.close();
                return;
            }
        }

        System.out.print("Enter the number to search: ");
        int num = 0;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Invalid input for search number. Exiting.");
            scanner.close();
            return;
        }

        int index = searcher.findElement(arr, num);

        System.out.println(index);

        scanner.close();
    }
}