import java.util.Scanner;

public class p10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= 2*n-1; i++) {
            int s =i;
            if(i>n){
                s = 2*n-i;
            }
            for (int j = 1; j <= s; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
