import java.util.Scanner;

public class ShipmentOptimiser {

    private static int daysRequired(int[] weights, int capacity) {
        int days = 1;
        int currentWeight = 0;

        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                days++;
                currentWeight = weight;
            } else {
                currentWeight += weight;
            }
        }
        return days;
    }

    public static int leastWeightCapacity(int[] weights, int d) {
        int totalWeight = 0;
        int maxWeight = 0;

        for (int weight : weights) {
            totalWeight += weight;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        int low = maxWeight;
        int high = totalWeight;
        int result = totalWeight;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int days = daysRequired(weights, mid);

            if (days <= d) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int d = scanner.nextInt();

        int result = leastWeightCapacity(weights, d);
        System.out.println(result);
        
        scanner.close();
    }
}