import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        if (n < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Triplets: " + solver.threeSum(nums1)); 
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0, 1, 1};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Triplets: " + solver.threeSum(nums2)); 
        // Expected: []

        int[] nums3 = {0, 0, 0, 0};
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Triplets: " + solver.threeSum(nums3)); 
        // Expected: [[0, 0, 0]]
    }
}
