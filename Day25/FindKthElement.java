import java.util.Scanner;

class FindKthElement {
    private int findKth(int[] arr1, int idx1, int[] arr2, int idx2, int k) {
        if (idx1 >= arr1.length) {
            return arr2[idx2 + k - 1];
        }
        if (idx2 >= arr2.length) {
            return arr1[idx1 + k - 1];
        }
        if (k == 1) {
            return Math.min(arr1[idx1], arr2[idx2]);
        }

        int p1 = Math.min(k / 2, arr1.length - idx1);
        int p2 = k - p1;

        int val1 = (idx1 + p1 - 1 < arr1.length) ? arr1[idx1 + p1 - 1] : Integer.MAX_VALUE;
        int val2 = (idx2 + p2 - 1 < arr2.length) ? arr2[idx2 + p2 - 1] : Integer.MAX_VALUE;

        if (val1 < val2) {
            return findKth(arr1, idx1 + p1, arr2, idx2, k - p1);
        } else {
            return findKth(arr1, idx1, arr2, idx2 + p2, k - p2);
        }
    }

    public int findKthElement(int[] arr1, int[] arr2, int k) {
        return findKth(arr1, 0, arr2, 0, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m, n, k;
        
        if (scanner.hasNextInt()) {
            m = scanner.nextInt();
        } else {
            return;
        }

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            return;
        }

        if (scanner.hasNextInt()) {
            k = scanner.nextInt();
        } else {
            return;
        }

        if (k <= 0 || k > m + n) {
            System.out.println("Invalid k value");
            return;
        }

        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            if (scanner.hasNextInt()) {
                arr1[i] = scanner.nextInt();
            } else {
                return;
            }
        }
        
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr2[i] = scanner.nextInt();
            } else {
                return;
            }
        }

        scanner.close();

        FindKthElement solution = new FindKthElement();
        int result = solution.findKthElement(arr1, arr2, k);
        System.out.println(result);
    }
}