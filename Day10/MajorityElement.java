import java.util.Scanner;

class MajorityElement {
    public static int findMajorityElement(int[] arr) {
        int count = 0;
        int candidate = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int result = findMajorityElement(arr);
        System.out.println(result);
        
        scanner.close();
    }
}
