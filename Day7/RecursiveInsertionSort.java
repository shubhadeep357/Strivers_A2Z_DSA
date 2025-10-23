class RecursiveInsertionSort {
    private static void sortRecursive(int[] arr, int n) {
        if (n <= 1) return;
        sortRecursive(arr, n - 1);
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sortRecursive(arr, arr.length);
    }
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        sort(arr);
        printArray(arr);
    }
}
