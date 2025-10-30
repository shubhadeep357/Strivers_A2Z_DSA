import java.util.Scanner;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        long result = maxProductSubarray(arr);
        System.out.println(result);
        
        scanner.close();
    }

    public static long maxProductSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        long max_so_far = arr[0];
        long current_max = arr[0];
        long current_min = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            
            long temp_max = current_max;
            
            current_max = Math.max((long)arr[i], Math.max(current_max * arr[i], current_min * arr[i]));
            
            current_min = Math.min((long)arr[i], Math.min(temp_max * arr[i], current_min * arr[i]));
            
            max_so_far = Math.max(max_so_far, current_max);
        }
        
        return max_so_far;
    }
}
