import java.util.Scanner;

public class LastOccurrence {
    public int findLastOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int lastIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                lastIndex = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements (N): ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the target key (x): ");
        int target = scanner.nextInt();

        LastOccurrence finder = new LastOccurrence();
        int result = finder.findLastOccurrence(arr, target);

        if (result != -1) {
            System.out.println("The index of the last occurrence of " + target + " is: " + result);
        } else {
            System.out.println("The target key " + target + " was not found. Result: -1");
        }

        scanner.close();
    }
}
