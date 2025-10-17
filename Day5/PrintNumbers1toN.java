public class PrintNumbers1toN {
    public static void main(String[] args) {
        int N = 4;

        // Iterative solution (most direct and optimized)
        for (int i = 1; i <= N; i++) {
            System.out.print(i);
            
            // Print ", " for separation, but only between numbers
            if (i < N) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
} 
    

