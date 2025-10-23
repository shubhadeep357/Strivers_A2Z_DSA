class RecursiveBubbleSort {
    private static void sort(int[] arr, int n) {
        if (n == 1) return;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swapped = true;
            }
        }
        if (swapped == false) return;
        sort(arr, n - 1);
    }
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        sort(arr, arr.length);
    }
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort(arr);
        printArray(arr);
    }
}
