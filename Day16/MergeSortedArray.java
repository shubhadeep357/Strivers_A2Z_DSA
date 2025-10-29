import java.util.Scanner;

class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m = 0;
        if (scanner.hasNextInt()) {
            m = scanner.nextInt();
        } else {
            return;
        }

        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            return;
        }

        int[] nums1 = new int[m + n];
        for (int i = 0; i < m; i++) {
            if (scanner.hasNextInt()) {
                nums1[i] = scanner.nextInt();
            } else {
                return;
            }
        }

        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                nums2[i] = scanner.nextInt();
            } else {
                return;
            }
        }

        merge(nums1, m, nums2, n);

        System.out.print("Merged Array: ");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + (i == nums1.length - 1 ? "" : " "));
        }
        System.out.println();
    }
}
