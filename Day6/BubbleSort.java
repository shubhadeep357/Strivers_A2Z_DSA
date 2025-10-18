import java.util.Scanner;

class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
        System.out.println();
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
            
            bubbleSort(arr);
            
            System.out.print("Output: ");
            printArray(arr);
        }
        scanner.close();
    }
}
