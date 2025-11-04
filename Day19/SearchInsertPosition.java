import java.util.Arrays;

public class SearchInsertPosition {
    public int searchInsert(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        // If the loop completes, the target was not found.
        // 'low' points to the index where the target should be inserted
        // to maintain the sorted order.
        return low;
    }

    public static void main(String[] args) {
        SearchInsertPosition solver = new SearchInsertPosition();

        int[] arr1 = {1, 3, 5, 6};
        
        // Case 1: Target is present
        int target1 = 5;
        System.out.println("Array: " + Arrays.toString(arr1) + ", Target: " + target1 + 
                           ", Result Index: " + solver.searchInsert(arr1, target1)); // Expected: 2

        // Case 2: Target should be inserted at the end
        int target2 = 7;
        System.out.println("Array: " + Arrays.toString(arr1) + ", Target: " + target2 + 
                           ", Result Index: " + solver.searchInsert(arr1, target2)); // Expected: 4
                           
        // Case 3: Target should be inserted in the middle
        int target3 = 2;
        System.out.println("Array: " + Arrays.toString(arr1) + ", Target: " + target3 + 
                           ", Result Index: " + solver.searchInsert(arr1, target3)); // Expected: 1
                           
        // Case 4: Target should be inserted at the start
        int target4 = 0;
        System.out.println("Array: " + Arrays.toString(arr1) + ", Target: " + target4 + 
                           ", Result Index: " + solver.searchInsert(arr1, target4)); // Expected: 0
    }
}
