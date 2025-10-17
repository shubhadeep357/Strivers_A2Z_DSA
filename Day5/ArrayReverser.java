public class ArrayReverser {

    // Optimized Two-Pointer method for in-place reversal
    public static void reverseArray(int[] arr) {
        // Initialize the two pointers
        int start = 0;
        int end = arr.length - 1;

        // Loop until the pointers meet or cross (reversing half the array)
        while (start < end) {
            // Swap the elements at the start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move the pointers inward
            start++;
            end--;
        }
    }

  
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int[] arr1 = {5, 4, 3, 2, 1};
        System.out.print("Original Array 1: ");
        printArray(arr1);
        
        reverseArray(arr1);
        System.out.print("Reversed Array 1: ");
        printArray(arr1); // Output: 1, 2, 3, 4, 5

        System.out.println();
        
       
        // Note: I corrected N=6 to N=4 based on the array size {10, 20, 30, 40}
        int[] arr2 = {10, 20, 30, 40}; 
        System.out.print("Original Array 2: ");
        printArray(arr2);

        reverseArray(arr2);
        System.out.print("Reversed Array 2: ");
        printArray(arr2); // Output: 40, 30, 20, 10
    }
}
