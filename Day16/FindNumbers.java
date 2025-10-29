import java.util.Scanner;

class FindNumbers {

    public static int[] find(int[] arr) {
        long n = arr.length;
        long S = 0;
        long S2 = 0;

        for (int val : arr) {
            S += val;
            S2 += (long)val * val;
        }

        long S_correct = n * (n + 1) / 2;
        long S2_correct = n * (n + 1) * (2 * n + 1) / 6;

        long X = S - S_correct;
        long Y = S2 - S2_correct;

        long ApB = Y / X;

        long A = (X + ApB) / 2;
        long B = (ApB - X) / 2;

        return new int[]{(int)A, (int)B};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                return;
            }
        }

        int[] result = find(arr);

        System.out.println("Repeating Number A: " + result[0]);
        System.out.println("Missing Number B: " + result[1]);
    }
}
