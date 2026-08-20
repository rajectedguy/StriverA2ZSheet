import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = fibonacci(n);
        System.out.println(ans);
    }
    static int fibonacci(int n){
        if(n<=1) return n;
        int last = fibonacci(n-1);
        int slast = fibonacci(n-2);
        return last+slast;
    }
}
