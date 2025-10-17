public class FactorialCalculator {

    // 1. Iterative Solution (O(X) time, O(1) space)
   
    public static long calculateFactorialIterative(int X) {
        // Base case: Factorial of 0 or 1 is 1
        if (X == 0 || X == 1) {
            return 1;
        }

        long result = 1;
        
        // Loop from 2 up to X, multiplying the result by each number
        for (int i = 2; i <= X; i++) {
            result = result * i;
        }
        return result;
    }

    // 2. Recursive Solution (O(X) time, O(X) space for the call stack)
  
    public static long calculateFactorialRecursive(int X) {
        // Base case: stops the recursion
        if (X == 1) {
            return 1;
        }

        // Recursive step: X * Factorial(X - 1)
        return X * calculateFactorialRecursive(X - 1);
    }

    public static void main(String[] args) {
        int inputX = 5;
        
        // Test Iterative Solution
        long iterativeResult = calculateFactorialIterative(inputX);
        System.out.println("Factorial of " + inputX + " (Iterative): " + iterativeResult); 
        
        // Test Recursive Solution
        long recursiveResult = calculateFactorialRecursive(inputX);
        System.out.println("Factorial of " + inputX + " (Recursive): " + recursiveResult); 
    }
}
