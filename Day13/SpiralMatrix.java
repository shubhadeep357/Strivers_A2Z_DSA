import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int R = matrix.length;
        int C = matrix[0].length;
        int top = 0;
        int bottom = R - 1;
        int left = 0;
        int right = C - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            if (top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (left > right) break;
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom--;

            if (top > bottom) break;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int R, C;
        try {
            R = scanner.nextInt();
            C = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            R = scanner.nextInt();
            C = scanner.nextInt();
        }

        int[][] matrix = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        List<Integer> result = spiralOrder(matrix);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i == result.size() - 1 ? "" : " "));
        }
        System.out.println();
        
        scanner.close();
    }
}
