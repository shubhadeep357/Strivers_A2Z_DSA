import java.util.Scanner;

public class SingleNumberFinder {
    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of elements (N):");
        int N = scanner.nextInt();
        
        if (N % 2 == 0 || N <= 0) {
            System.out.println("The number of elements must be odd and greater than zero.");
            scanner.close();
            return;
        }
        
        int[] arr = new int[N];
        
        System.out.println("Enter " + N + " integers, where all numbers but one appear twice:");
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int singleNumber = findSingleNumber(arr);
        
        System.out.println("The single number is: " + singleNumber);
        
        scanner.close();
    }
}
