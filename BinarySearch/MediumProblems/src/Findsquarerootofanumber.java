import java.util.Scanner;

public class Findsquarerootofanumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ans = floorSqrt(n);
        System.out.println(ans);
    }
    public static int floorSqrt(int n) {
        // code here
        int ans = 0;
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sqrt = (long) mid * mid;
            if (sqrt <= n) {
                ans = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return ans;
    }
}