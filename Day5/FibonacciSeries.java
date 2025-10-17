import java.util.Scanner;

public class FibonacciSeries {
    public static void printFibonacciSeries(int N) {
        if (N <= 0) {
            return;
        }

        // Initialize the first two terms
        long a = 0;
        long b = 1;

        // Print the first term (0)
        System.out.print(a);

        // Handle N=1 case (already printed)
        if (N == 1) {
            System.out.println();
            return;
        }
        
        // Print the second term (1)
        System.out.print(" " + b);

        // Generate and print the rest of the terms
        for (int i = 3; i <= N; i++) {
            long c = a + b;
            System.out.print(" " + c);
            
            // Shift the numbers for the next iteration
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of terms (N) for the Fibonacci series:");
        
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            if (N < 0) {
                System.out.println("N must be a non-negative integer.");
            } else {
                printFibonacciSeries(N);
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
        }
        
        scanner.close();
    }
}
