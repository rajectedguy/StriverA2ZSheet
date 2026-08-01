import java.util.Scanner;

public class FindNthrootofanumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = nthRoot(n, m);
        System.out.println(ans);
    }
    public static int nthRoot(int n, int m) {
        // code here
        if (m == 0) return 0;
        int left = 1;
        int right = m;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            double val = Math.pow(mid, n);
            if (val == m) {
                return mid;
            } else if (val < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}