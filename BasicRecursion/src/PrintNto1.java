import java.util.Scanner;

public class PrintNto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }
    static void print(int n){
        if(n < 1){
            return;
        }
        System.out.println(n);
        print(n-1);
    }
}
