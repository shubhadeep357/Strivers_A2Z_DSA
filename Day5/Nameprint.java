public class Nameprint{
    public static void main(String[] args) {
        int N = 3;
        String nameToPrint = "Ashish";
        
        for (int i = 0; i < N; i++) {
            System.out.print(nameToPrint);
            if (i < N - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
