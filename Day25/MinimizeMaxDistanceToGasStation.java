import java.util.Scanner;

class MinimizeMaxDistanceToGasStation {
    private boolean check(int[] arr, int k, double M) {
        int stationsNeeded = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            double gap = arr[i + 1] - arr[i];
            stationsNeeded += (int) (gap / M);
        }
        return stationsNeeded <= k;
    }

    public double findMinimumMaxDistance(int[] arr, int k) {
        double low = 0.0;
        double high = 0.0;

        for (int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        while (high - low > 1e-7) {
            double mid = (low + high) / 2.0;
            if (check(arr, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input for n.");
            scanner.close();
            return;
        }

        if (scanner.hasNextInt()) {
            k = scanner.nextInt();
        } else {
            System.out.println("Invalid input for k.");
            scanner.close();
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for array element.");
                scanner.close();
                return;
            }
        }
        scanner.close();

        MinimizeMaxDistanceToGasStation problem = new MinimizeMaxDistanceToGasStation();
        double result = problem.findMinimumMaxDistance(arr, k);
        System.out.printf("%.6f%n", result);
    }
}