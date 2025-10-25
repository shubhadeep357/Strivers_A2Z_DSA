import java.util.Scanner;

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N;
        try {
            N = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            N = scanner.nextInt();
        }

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        rotate(matrix);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + (j == N - 1 ? "" : " "));
            }
            System.out.println();
        }
        scanner.close();
    }
}
