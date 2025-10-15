import java.util.Scanner;

class loop{
    public void printGrade(Scanner sc) {
        // Taking input
        int marks = sc.nextInt();
        
        // Checking conditions for grade
        if (marks >= 90) {
            System.out.print("Grade A");
        } else if (marks >= 70) {
            System.out.print("Grade B");
        } else if (marks >= 50) {
            System.out.print("Grade C");
        } else if (marks >= 35) {
            System.out.print("Grade D");
        } else {
            System.out.print("Fail");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loop obj = new loop();
        obj.printGrade(sc);
        sc.close();
    }
}
