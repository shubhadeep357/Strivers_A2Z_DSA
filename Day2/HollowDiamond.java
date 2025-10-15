public class HollowDiamond {
    public static void main(String[] args) {
        int n = 5;

        // Upper half
        for (int i = 1; i <= n; i++) {
            System.out.print(" ".repeat(n - i));
            if (i == 1) System.out.println("*");
            else {
                System.out.print("*");
                System.out.print(" ".repeat(2 * (i - 1) - 1));
                System.out.println("*");
            }
        }

        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            System.out.print(" ".repeat(n - i));
            if (i == 1) System.out.println("*");
            else {
                System.out.print("*");
                System.out.print(" ".repeat(2 * (i - 1) - 1));
                System.out.println("*");
            }
        }
    }
}

