import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        
        prefixSumCounts.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }
            
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
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
        
        int k = scanner.nextInt();

        System.out.println(subarraySum(nums, k));
        
        scanner.close();
    }
}
