public class SumOfNaturals {

    // Method using the optimized mathematical formula (O(1) complexity)
    public static long calculateSumOptimized(int N) {
       
        // The formula is N * (N + 1) / 2
        return (long)N * (N + 1) / 2;
    }

    public static void main(String[] args) {
        int N = 5;
        long sum = calculateSumOptimized(N);
        
        System.out.println("Input N: " + N);
        System.out.println("Output Sum: " + sum);
        // Output for N=5 is 15 (1 + 2 + 3 + 4 + 5)
    }
}