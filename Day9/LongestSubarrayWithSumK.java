package Day9;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LongestSubarrayWithSumK {
    public int findLongestSubarrayWithSumK(int[] arr, int k) {
        int maxLength = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Key: prefix sum, Value: the index where this prefix sum first occurred
        prefixSumMap.put(0, -1); // Handle the case where the subarray starts from index 0

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Case 1: The current subarray from index 0 to i sums to k
            if (currentSum == k) {
                maxLength = i + 1;
            }

            // Case 2: Check if (currentSum - k) exists in the map
            // If it exists, the subarray from (index of currentSum - k) + 1 to i sums to k
            if (prefixSumMap.containsKey(currentSum - k)) {
                int start_index = prefixSumMap.get(currentSum - k);
                int currentLength = i - start_index;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }

            // Store the current prefix sum and its index, only if it hasn't been seen before.
            // We want to store the earliest index for a given sum to maximize the subarray length.
            if (!prefixSumMap.containsKey(currentSum)) {
                prefixSumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongestSubarrayWithSumK solver = new LongestSubarrayWithSumK();

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

        System.out.print("Enter the target sum k: ");
        int k = 0;
        if (scanner.hasNextInt()) {
            k = scanner.nextInt();
        } else {
            System.out.println("Invalid input for k. Exiting.");
            scanner.close();
            return;
        }

        int maxLength = solver.findLongestSubarrayWithSumK(arr, k);

        System.out.println("The length of the longest subarray with sum " + k + " is: " + maxLength);

        scanner.close();
    }
}