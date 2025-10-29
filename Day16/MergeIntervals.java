import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || interval[0] > merged.getLast()[1]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input for number of intervals.");
            return;
        }

        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                intervals[i][0] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for interval start.");
                return;
            }
            if (scanner.hasNextInt()) {
                intervals[i][1] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for interval end.");
                return;
            }
        }

        int[][] result = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
