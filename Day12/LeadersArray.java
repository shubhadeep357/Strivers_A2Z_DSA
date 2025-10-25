import java.util.*;

public class LeadersArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] Arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            Arr[i] = sc.nextInt();
        }
        
        List<Integer> leaders = new ArrayList<>();
        
        if (N > 0) {
            int maxRight = Arr[N - 1];
            leaders.add(maxRight);
            
            for (int i = N - 2; i >= 0; i--) {
                if (Arr[i] >= maxRight) {
                    maxRight = Arr[i];
                    leaders.add(maxRight);
                }
            }
        }
        
        Collections.reverse(leaders);
        
        for (int leader : leaders) {
            System.out.print(leader + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
