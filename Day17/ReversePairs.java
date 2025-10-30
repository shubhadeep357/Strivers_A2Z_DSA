import java.util.Scanner;

public class ReversePairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        long result = countReversePairs(arr);
        System.out.println(result);
        
        scanner.close();
    }

    public static long countReversePairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int N = arr.length;
        int[] temp = new int[N];
        return mergeSortAndCount(arr, temp, 0, N - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCountSplitPairs(arr, temp, left, mid, right);
        }
        return count;
    }

    private static long mergeAndCountSplitPairs(int[] arr, int[] temp, int low, int mid, int high) {
        
        long reversePairs = 0;
        int ptr = mid + 1;
        
        for (int i = low; i <= mid; i++) {
            while (ptr <= high && (long)arr[i] > 2L * arr[ptr]) {
                ptr++;
            }
            reversePairs += (ptr - (mid + 1));
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        
        for (int l = low; l <= high; l++) {
            temp[l] = arr[l];
        }
        
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        
        while (j <= high) {
            arr[k++] = temp[j++];
        }

        return reversePairs;
    }
}
