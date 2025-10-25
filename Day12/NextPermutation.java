import java.util.*;

public class NextPermutation {

    private static void reverse(int[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            
            swap(arr, i, j);
        }
        
        reverse(arr, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] Arr = new int[N];
        
        for (int k = 0; k < N; k++) {
            Arr[k] = sc.nextInt();
        }
        
        nextPermutation(Arr);
        
        for (int x : Arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
