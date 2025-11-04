import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = n / 3;

        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {
        MajorityElement solver = new MajorityElement();

        int[] arr1 = {3, 2, 3};
        System.out.println("Array: [3, 2, 3], Result: " + solver.majorityElement(arr1));

        int[] arr2 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("Array: [1, 1, 1, 3, 3, 2, 2, 2], Result: " + solver.majorityElement(arr2));
        
        int[] arr3 = {1, 2};
        System.out.println("Array: [1, 2], Result: " + solver.majorityElement(arr3));

        int[] arr4 = {1, 2, 3, 4};
        System.out.println("Array: [1, 2, 3, 4], Result: " + solver.majorityElement(arr4));
    }
}
