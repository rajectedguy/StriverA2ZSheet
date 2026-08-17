import java.util.Scanner;

public class p11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s = 1;
            }else {
                s = 0;
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(s+" ");
                s = 1 - s;
            }
            System.out.println();
        }
    }
}
