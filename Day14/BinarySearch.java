import java.util.Scanner;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N;
        try {
            N = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            N = scanner.nextInt();
        }

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int target = scanner.nextInt();

        int resultIndex = search(nums, target);

        System.out.println(resultIndex);
        
        scanner.close();
    }
}
