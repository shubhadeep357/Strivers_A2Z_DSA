import java.util.HashMap;
import java.util.Scanner;

class ZeroSum {

    public int maxLen(int[] arr, int n) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            if (currentSum == 0) {
                maxLength = i + 1;
            } else if (sumMap.containsKey(currentSum)) {
                maxLength = Math.max(maxLength, i - sumMap.get(currentSum));
            } else {
                sumMap.put(currentSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        ZeroSum solution = new ZeroSum();
        int result = solution.maxLen(arr, n);

        System.out.println(result);
    }
}
