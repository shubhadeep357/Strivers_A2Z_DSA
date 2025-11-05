import java.util.Scanner;

public class NthRootFinder {
    public static int nthRoot(int N, int M) {
        if (M == 0) return 0;
        if (N == 1) return M;

        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long product = 1;
            boolean isTooBig = false;

            for (int i = 0; i < N; i++) {
                if (mid == 0) {
                    product = 0;
                    break;
                }
                if (product > M / mid) {
                    isTooBig = true;
                    break;
                }
                product = product * mid;
            }

            if (isTooBig || product > M) {
                high = mid - 1;
            } else if (product < M) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        int M = 0;

        try {
            N = scanner.nextInt();
            M = scanner.nextInt();
            if (N <= 0 || M < 0) {
                System.out.println(-1);
                return;
            }
            int result = nthRoot(N, M);
            System.out.println(result);
        } catch (java.util.InputMismatchException e) {
            System.out.println(-1);
        } finally {
            scanner.close();
        }
    }
}