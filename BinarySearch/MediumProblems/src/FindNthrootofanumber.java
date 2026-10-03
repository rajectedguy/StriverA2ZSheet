import java.util.Scanner;

public class FindNthrootofanumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = nthRoot(n, m);
        System.out.println(ans);
    }
    private static int nthRoot(int n, int m) {
        int low = 0;
        int high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int check = helper(mid, n, m);
            if (check == 1) {
                return mid;
            } else if (check == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    private static int helper(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }
}