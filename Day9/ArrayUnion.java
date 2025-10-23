package Day9;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ArrayUnion {
    public List<Integer> findUnion(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;

        while (i < n || j < m) {
            // Skip duplicates in arr1
            if (i > 0 && i < n && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }

            // Skip duplicates in arr2
            if (j > 0 && j < m && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            // If arr1 is exhausted, take from arr2
            if (i >= n) {
                union.add(arr2[j]);
                j++;
            }
            // If arr2 is exhausted, take from arr1
            else if (j >= m) {
                union.add(arr1[i]);
                i++;
            }
            // Compare elements
            else if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                union.add(arr2[j]);
                j++;
            } else {
                // Elements are equal, take one and advance both
                union.add(arr1[i]);
                i++;
                j++;
            }
        }

        return union;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayUnion arrayUnion = new ArrayUnion();

        System.out.print("Enter the size of the first array (n): ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }

        if (n < 0) {
            System.out.println("Size must be non-negative. Exiting.");
            scanner.close();
            return;
        }

        int[] arr1 = new int[n];
        System.out.println("Enter " + n + " sorted integer elements for arr1:");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr1[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Exiting.");
                scanner.close();
                return;
            }
        }

        System.out.print("Enter the size of the second array (m): ");
        int m = 0;
        if (scanner.hasNextInt()) {
            m = scanner.nextInt();
        } else {
            System.out.println("Invalid input. Exiting.");
            scanner.close();
            return;
        }

        if (m < 0) {
            System.out.println("Size must be non-negative. Exiting.");
            scanner.close();
            return;
        }

        int[] arr2 = new int[m];
        System.out.println("Enter " + m + " sorted integer elements for arr2:");
        for (int i = 0; i < m; i++) {
            if (scanner.hasNextInt()) {
                arr2[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Exiting.");
                scanner.close();
                return;
            }
        }

        List<Integer> union = arrayUnion.findUnion(arr1, arr2);

        System.out.println("Union of the two arrays:");
        System.out.println(union);

        scanner.close();
    }
}