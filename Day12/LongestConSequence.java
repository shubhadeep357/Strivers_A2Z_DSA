import java.util.*;

public class LongestConSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] Arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            Arr[i] = sc.nextInt();
        }
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : Arr) {
            numSet.add(num);
        }
        
        int maxLength = 0;
        
        for (int num : Arr) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        System.out.println(maxLength);
        
        sc.close();
    }
}
