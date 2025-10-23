import java.util.Scanner;

class SecondMinMax {
    public int[] findSecondMinMax(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return new int[]{-1, -1};
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int element : arr) {
            // Find Largest and Second Largest
            if (element > largest) {
                secondLargest = largest;
                largest = element;
            } else if (element > secondLargest && element < largest) {
                secondLargest = element;
            }

            // Find Smallest and Second Smallest
            if (element < smallest) {
                secondSmallest = smallest;
                smallest = element;
            } else if (element < secondSmallest && element > smallest) {
                secondSmallest = element;
            }
        }

        // If secondLargest is still MIN_VALUE, it means all elements were the same or n < 2 (already handled)
        // For the purpose of the problem, if the array is {5, 5, 5}, the second largest/smallest do not exist
        // in a non-duplicate sense. Since we're tracking the second distinct value, we check if
        // secondLargest/secondSmallest were updated from their initial extreme values.
        
        int secondLargestResult = (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
        int secondSmallestResult = (secondSmallest == Integer.MAX_VALUE) ? -1 : secondSmallest;

        return new int[]{secondSmallestResult, secondLargestResult};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecondMinMax solver = new SecondMinMax();

        System.out.print("Enter the number of elements in the array: ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("-1");
            scanner.close();
            return;
        }

        if (n <= 0) {
            System.out.println("-1, -1");
            scanner.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integer elements:");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Exiting.");
                scanner.close();
                return;
            }
        }

        int[] result = solver.findSecondMinMax(arr);

        System.out.println(result[0] + " " + result[1]);

        scanner.close();
    }
}