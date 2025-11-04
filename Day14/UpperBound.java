import java.util.Scanner;

public class UpperBound {

    public static int findUpperBound(int[] nums, int target) {
        int N = nums.length;
        int low = 0;
        int high = N - 1;
        int ans = N;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
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

        int resultIndex = findUpperBound(nums, target);

        System.out.println(resultIndex);

        scanner.close();
    }
}
