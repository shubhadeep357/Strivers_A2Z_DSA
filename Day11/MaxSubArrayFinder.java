import java.util.Scanner;
import java.util.Arrays;

public class MaxSubArrayFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int max_so_far = Integer.MIN_VALUE;
        int current_max = 0;

        int max_start = 0;
        int max_end = 0;
        int current_start = 0;

        for (int i = 0; i < n; i++) {
            current_max = current_max + arr[i];

            if (current_max > max_so_far) {
                max_so_far = current_max;
                max_start = current_start;
                max_end = i;
            }

            if (current_max < 0) {
                current_max = 0;
                current_start = i + 1;
            }
        }

        System.out.println(max_so_far);
        
        System.out.print("[");
        for (int i = max_start; i <= max_end; i++) {
            System.out.print(arr[i]);
            if (i < max_end) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
