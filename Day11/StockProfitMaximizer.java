import java.util.Scanner;

public class StockProfitMaximizer {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        scanner.close();

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        System.out.println(maxProfit);
    }
}
