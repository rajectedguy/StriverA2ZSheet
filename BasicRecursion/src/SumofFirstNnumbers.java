import java.util.Scanner;

public class SumofFirstNnumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumofnumber(n));
    }
    static int sumofnumber(int n){
        if(n == 0){
            return 0;
        }
        return n + sumofnumber(n-1);
    }
}
