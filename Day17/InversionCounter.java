import java.util.Scanner;

public class InversionCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        long result = countInversions(arr);
        System.out.println(result);
        
        scanner.close();
    }

    public static long countInversions(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int N = arr.length;
        int[] temp = new int[N];
        return mergeSortAndCount(arr, temp, 0, N - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            invCount += mergeAndCountSplitInversions(arr, temp, left, mid, right);
        }
        return invCount;
    }

    private static long mergeAndCountSplitInversions(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;
        long inversionCount = 0;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
                inversionCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        
        return inversionCount;
    }
}
