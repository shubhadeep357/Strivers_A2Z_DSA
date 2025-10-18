import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FrequencyCounter {
    public static void countFrequencies(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int element : arr) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of test cases (T):");
        int t = scanner.nextInt(); 

        while (t-- > 0) {
            System.out.println("Enter the size of the array (N):");
            int n = scanner.nextInt();
            
            System.out.println("Enter " + n + " elements:");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            
            System.out.println("Output:");
            countFrequencies(arr);
        }
        scanner.close();
    }
}
