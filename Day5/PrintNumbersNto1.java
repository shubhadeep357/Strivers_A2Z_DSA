public class PrintNumbersNto1 {
    public static void main(String[] args) {
        int N = 4;

        // Iterative solution (most direct and optimized)
        for (int i = N; i >= 1; i--) {
            System.out.print(i);
            
            // Print ", " for separation, but only between numbers
            if (i > 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
