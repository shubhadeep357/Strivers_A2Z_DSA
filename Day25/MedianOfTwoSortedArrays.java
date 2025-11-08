import java.util.Scanner;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0;
        int high = m;
        int halfLen = (m + n + 1) / 2;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = halfLen - cut1;

            int L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int R1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            
            int L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int R2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 <= R2 && L2 <= R1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(L1, L2);
                } else {
                    return (double)(Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }
            } else if (L1 > R2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int m, n;
        
        if (scanner.hasNextInt()) {
            m = scanner.nextInt();
        } else {
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
        
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            return;
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

        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        double median = solution.findMedianSortedArrays(arr1, arr2);
        System.out.println(median);
    }
}