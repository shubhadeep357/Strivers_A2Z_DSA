package Day9;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LongestSubarraySumK {
    public int findLongestSubarrayWithSumK(int[] arr, int k) {
        int maxLength = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // This handles the case where the subarray starts from index 0
        prefixSumMap.put(0, -1); 

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // If a previous prefix sum exists such that (currentSum - k) is found,
            // it means the elements between prefixSumMap.get(currentSum - k) and i sum to k.
            if (prefixSumMap.containsKey(currentSum - k)) {
                int startIndex = prefixSumMap.get(currentSum - k);
                int currentLength = i - startIndex;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }

            // Store the current prefix sum and its index, but only store the first occurrence
            // to ensure we get the longest possible subarray length.
            if (!prefixSumMap.containsKey(currentSum)) {
                prefixSumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongestSubarraySumK solver = new LongestSubarraySumK();

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

        System.out.println("Enter " + n + " integer elements (positives or negatives):");
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

        System.out.println(maxLength);

        scanner.close();
    }
}