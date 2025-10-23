import java.util.*;

class TwoSum {
    public static String solveVariant1(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                return "YES";
            }
            set.add(num);
        }
        return "NO";
    }

    public static int[] solveVariant2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();

        String result1 = solveVariant1(arr, target);
        System.out.println(result1);

        int[] result2 = solveVariant2(arr, target);
        System.out.println(result2[0] + " " + result2[1]);
        
        scanner.close();
    }
}
