import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FrequencyAnalyzer {
    public static void findHighLowFrequency(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int element : arr) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int maxElement = -1;
        int minFreq = Integer.MAX_VALUE;
        int minElement = -1;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int element = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                maxElement = element;
            }

            if (freq < minFreq) {
                minFreq = freq;
                minElement = element;
            }
        }

        System.out.println(maxElement + " " + minElement);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of test cases (T):");
        int t = scanner.nextInt(); 

        while (t-- > 0) {
            System.out.println("Enter the size of the array (N):");
            int n = scanner.nextInt();
            
            int[] arr = new int[n];
            if (n > 0) {
                 System.out.println("Enter " + n + " elements:");
                 for (int i = 0; i < n; i++) {
                     arr[i] = scanner.nextInt();
                 }
            }
            
            System.out.print("Output: ");
            findHighLowFrequency(arr);
        }
        scanner.close();
    }
}
