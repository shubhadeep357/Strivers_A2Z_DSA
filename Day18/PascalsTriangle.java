import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentRow.add(1);
                } else {
                    List<Integer> previousRow = triangle.get(i - 1);
                    int sum = previousRow.get(j - 1) + previousRow.get(j);
                    currentRow.add(sum);
                }
            }
            triangle.add(currentRow);
        }
        
        return triangle;
    }

    public static void printTriangle(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            System.out.println("The triangle is empty.");
            return;
        }

        int lastRowSize = triangle.get(triangle.size() - 1).size();
        int maxDigits = String.valueOf(triangle.get(triangle.size() - 1).get(lastRowSize / 2)).length();

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            
            int padding = (triangle.size() - 1 - i) * (maxDigits + 1) / 2;
            for (int k = 0; k < padding; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < row.size(); j++) {
                String formattedNum = String.format("%" + maxDigits + "d", row.get(j));
                System.out.print(formattedNum);
                if (j < row.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numRows = 10;
        List<List<Integer>> result = generate(numRows);
        printTriangle(result);
    }
}
