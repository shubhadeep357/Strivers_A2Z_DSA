import java.util.*;

public class RearrangeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        
        for (int x : A) {
            if (x > 0) {
                positives.add(x);
            } else {
                negatives.add(x);
            }
        }
        
        int[] result = new int[N];
        int nHalf = N / 2;
        
        for (int i = 0; i < nHalf; i++) {
            result[2 * i] = positives.get(i);
            result[2 * i + 1] = negatives.get(i);
        }
        
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
