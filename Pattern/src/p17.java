import java.util.Scanner;

public class p17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            char ch = 'A';
            int bp = (2*i+1)/2;
            for (int j = 0; j < 2*i+1; j++) {
                System.out.print(ch);
                if(j<bp){
                    ch++;
                }else {
                    ch--;
                }
            }
            for (int j = 0; j < n-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
