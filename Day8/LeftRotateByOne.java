import java.util.Arrays;
import java.util.Scanner;

class LeftRotateByOne {
    public void leftRotate(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int firstElement = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = firstElement;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeftRotateByOne rotator = new LeftRotateByOne();

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

        rotator.leftRotate(arr);

        System.out.println("Array after one left rotation: " + Arrays.toString(arr));

        scanner.close();
    }
}