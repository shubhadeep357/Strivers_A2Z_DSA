import java.util.Scanner;

class inputOutput{
    public void printNumber(Scanner sc) {
        // taking integer input
        int num = sc.nextInt();
        // printing the number
        System.out.println(num);
    }

    // main method to test the function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inputOutput obj = new inputOutput();
        obj.printNumber(sc);
        sc.close();
    }
}
