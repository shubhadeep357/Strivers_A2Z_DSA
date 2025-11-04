import java.util.HashMap;
import java.util.Scanner;

class XorOp {

    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> xorCounts = new HashMap<>();
        xorCounts.put(0, 1);
        int currentXor = 0;
        int count = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            currentXor = currentXor ^ A[i];
            
            int requiredXor = currentXor ^ B;
            
            if (xorCounts.containsKey(requiredXor)) {
                count += xorCounts.get(requiredXor);
            }
            
            xorCounts.put(currentXor, xorCounts.getOrDefault(currentXor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        int B = scanner.nextInt();
        scanner.close();

        XorOp solution = new XorOp();
        int result = solution.solve(A, B);

        System.out.println(result);
    }
}
