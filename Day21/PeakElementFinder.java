import java.util.Scanner;

public class PeakElementFinder {
    public static int findPeakElementIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the array (N):");
        int N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("Array length must be greater than 0.");
            scanner.close();
            return;
        }

        int[] arr = new int[N];
        System.out.println("Enter " + N + " integers:");
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int peakIndex = findPeakElementIndex(arr);
        
        if (peakIndex != -1) {
            System.out.println("An index of a peak element is: " + peakIndex);
            System.out.println("The peak element is: " + arr[peakIndex]);
        } else {
            System.out.println("Could not find a peak element (array is empty).");
        }

        scanner.close();
    }
}
